package com.icona.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.icona.tree.nodes.BasicModifier;
import com.icona.tree.nodes.ClassInterface;
import com.icona.tree.nodes.Declaration;
import com.icona.tree.nodes.Expression.PrimaryExpression;
import com.icona.tree.nodes.Function;
import com.icona.tree.nodes.GenericRef.RefType;
import com.icona.tree.nodes.Identifier;
import com.icona.tree.nodes.IdentifierType;
import com.icona.tree.nodes.Import;
import com.icona.tree.nodes.ListClass;
import com.icona.tree.nodes.ListImport;
import com.icona.tree.nodes.Node;
import com.icona.tree.nodes.PackageDef;
import com.icona.tree.nodes.Parameter;
import com.icona.tree.nodes.Protocol;
import com.icona.tree.nodes.Statement.CompoundStatement;
import com.icona.tree.nodes.Statement.JumpStatement;
import com.icona.tree.nodes.Statement.JumpStatement.JumpType;
import com.icona.tree.nodes.Statement.StatementList;
import com.icona.tree.nodes.Type.DataType;

public class SymbolTable {
	
	Stack activeScopes;
	Stack unReferenced;
	Multimap symbolTable;
	
	Node currentParent;
	PackageDef currentPackage;
	ClassInterface currentClass;
	File currentFile;
	
	private SymbolTable(){
		activeScopes = new Stack();
		symbolTable = HashMultimap.create();
		unReferenced = new Stack();
		currentParent = null;
		currentPackage = null;
		currentClass = null;
		currentFile = null;
		
		
	}
	
	
	private static SymbolTable INSTANCE = null;
	public static void forceNull(){
		INSTANCE = null;
		System.out.println("ST=> Forced reset");
	}
    public static SymbolTable getInstance() {
    	if(INSTANCE == null)
    		INSTANCE = new SymbolTable();
    	return INSTANCE;
    }

    private static class SymbolTableHolder {
        private static final SymbolTable INSTANCE = new SymbolTable();
    }
    
    
	
    public void setCurrentFile(File file) {
    	System.out.println("ST => Current file set to:" + file.getName());
        currentFile = file;
    }   
	
    public File getCurrentFile() {
        return this.currentFile;
    }   
	
	public PackageDef getCurrentPackage() {
		return currentPackage;
	}

	public void addCurrentPackage(){
		System.out.println("ST => Added Packaged " + currentPackage.getPackageName() );
		this.symbolTable.put(currentPackage.getPackageName(), this.currentPackage);
	}
	public void setCurrentPackage(PackageDef currentPackage) {
		//System.out.println("current package set to:" + currentPackage.getPackageName());
		this.currentPackage = currentPackage;
	}

	public ClassInterface getCurrentClass() {

		return currentClass;
	}

	public void setCurrentClass(ClassInterface currentClass) {
		
		if(currentClass!=null)
		System.out.println("ST => Current class set to: "+ currentClass.getClassName().getName());
		this.currentClass = currentClass;
	}

	public Node getCurrentParent(){
		
		return currentParent;
	}
	public void setCurrentParent(Node parent){
		
		currentParent = parent;
	}
	
	public void replaceObject(String key, Object val){
	     
		symbolTable.remove(key, val);
		symbolTable.put(key, val);
		//symbolTable.replaceValues(key, (Iterable) val);
		
	}
	
	public boolean addPackage(String key, Object object){  //TODO may conflict with variable name
		if(!symbolTable.containsKey(key)){
			System.out.println("ST => Added Package: " + currentPackage.getPackageName() );
			symbolTable.put(key, object);
			return true;
		}
		return false;
	}
	public Object addObject(String key, Object object){
		
		System.out.println("ST => Added object with key:"+ key);
		return symbolTable.put(key, object);
		
	}
	
	//TODO this function is not being used any longer
	
	public boolean assignImports(String packageName, ListImport imports){
		//System.out.println(packageName);
		//if(symbolTable.containsKey(packageName)){
			System.out.println("ST=> Assigning imports");
			//PackageDef package_ = (PackageDef) this.getObject(packageName, IdentifierType.PACKAGE);
			Iterator iterator = this.currentPackage.getClassList().getIterator();
			/*while(iterator.hasNext()){
			    	ClassInterface class_ = (ClassInterface) iterator.next();
			    	//currentPackage.getClassList().assignImports(imports);
			    	if(class_.getImportList()==null)  //TODO this would only add either of <h or m files> imports
			    		class_.setImports(imports);
			   }*/
		  iterator = this.currentPackage.getProtocolList().getIterator();
			while(iterator.hasNext()){
			    	Protocol protocol_ = (Protocol) iterator.next();
			    	if(protocol_.getImportList()==null)
			    		protocol_.setImports(imports);
			    		
			    }
		
			return true;
	//	}
		//return false;
		
	}
	public Object getObject(String key, IdentifierType definitionType){
		
		Collection nodes = symbolTable.get(key);
		
		for (int i=0; i<nodes.toArray().length;i++)
			if( ((Node)nodes.toArray()[i]).getDefinitionType() ==  definitionType)
				return nodes.toArray()[i];
	
		
		/*Iterator nodeIterator = nodes.iterator();
		
		while(nodeIterator.hasNext()){
			Node node = (Node)nodeIterator.next(); 
			if( node.getDefinitionType() ==  definitionType){
				return node;
			}
		}*/
		return null;
		
	}
	public ListClass getClasses(){
		
         Collection nodes = symbolTable.values();
		
         ListClass classes = new ListClass(null, -1);
         
		Iterator nodeIterator = nodes.iterator();

		while(nodeIterator.hasNext()){
			Node node = (Node)nodeIterator.next(); 
			if( node.getDefinitionType() ==  IdentifierType.CLASS){
				classes.addClass((ClassInterface)node);
			}
		}
		return classes;
	}

	
	//TODO for testing...keep if its better than conventional grammar actions
	public boolean mergeFunctions(Function function){
		
		String functionName = (function.getIdentifier()!=null?function.getIdentifier().getName():function.getParameterAt(0).getSelector().getName());
		
		 if(symbolTable.containsKey(functionName)){
			 
			 Function prevFunction = (Function)this.getObject(functionName, IdentifierType.FUNCTION);
			 
			 if(prevFunction.getOwner().getClassName().getName().equals(currentClass.getClassName().getName())){
				 
				 System.out.println("ST => Function '"+functionName+"' exists with parent class '"+currentClass.getClassName().getName()+"'..merging");
			   
				 if(prevFunction.getCompoundStatement() == null){
					 
					 prevFunction.getOwner().replaceFunctionInList(prevFunction, function);
				 }
			 }
			 
			 return true;
		 }
		 
		 else{
			 
			 String className = currentClass.getClassName().getName();
			 
			 ClassInterface prevClass = (ClassInterface) (this.getObject(className, IdentifierType.CLASS));
			 if(prevClass!=null){
				   
			      prevClass.addFunction(function);
			 }
			 
			      this.addObject(functionName, function); //TODO not sure if this has to be added
			 
			 return false;
		 }	
	}
	
	
	public boolean mergeClasses(ClassInterface class_, ListImport imports){
		
		String className = class_.getClassName().getName();
		if (symbolTable.containsKey(className)) {

			System.out.println("ST => class '"+ class_.getClassName().getName()+ "' already exists...merging");

			ClassInterface prevClass = (ClassInterface) (this.getObject(className, IdentifierType.CLASS));
			
			if(class_.getImportList()!=null){
				System.out.println("ST => Merging imports...");
				Iterator itr = class_.getImportList().getIterator();
				while(itr.hasNext()){
					Import imp = (Import) itr.next();
					prevClass.getImportList().addImport(imp);
				}
				
			}
			
			if(prevClass.getSuperClass() == null)
				prevClass.setSuperClass(class_.getSuperClass());
			
			if(prevClass.getProtocolList() == null)
				prevClass.setProtocols(class_.getProtocolList());
			
			if(class_.getInstanceVariables()!=null){
					Iterator<Declaration> decl = class_.getInstanceVariables().getIterator();
					while(decl.hasNext())
						prevClass.addInstanceVariable(decl.next());
			}
			
	
			//ClassInterface interface_ = (!class_.isImplementation())? class_ : prevClass;
				
		//	ClassInterface implementation_ = (class_.isImplementation())? class_: prevClass;		

					
			Iterator <Function>itr1 = class_.getFunctions().getIterator();

			boolean func_match=false;
			boolean matched = true;
			
			while(itr1!=null && itr1.hasNext()){

				Iterator <Function>itr2 = prevClass.getFunctions().getIterator();
				Function func1 = itr1.next();
				func_match=false;

				while(itr2!=null && itr2.hasNext()){
					
					Function func2 = itr2.next();
					
					if(func1.getFunctionName().equals(func2.getFunctionName())){
						
						if(func1.getParameterList() != null){
						
						Iterator <Parameter> pItr1 = func1.getParameterIterator();

						Iterator <Parameter> pItr2 = func2.getParameterIterator();
						
						matched = true;

						
						while(pItr1.hasNext() && pItr2.hasNext()){
							
							Parameter param1 = pItr1.next();
						
							Parameter param2= pItr2.next();
								
							if(!param1.getParameterName().getName().equals(param2.getParameterName().getName()) ){
									
									if(prevClass.isImplementation()){
										prevClass.addFunction(func2);
									
									}
									matched =false;
								}
							}
							
						}
						
						if(matched == true){
							if(!prevClass.isImplementation()){
								prevClass.replaceFunctionInList(func2, func1);
							}
							func_match=true;
							break;
						}

					}
				}

				
				if(!func_match){
					prevClass.addFunction(func1);
				}

				if(!matched){
					
					prevClass.addFunction(func1);
				}	
			}
			
			return true;
		}
		else{
			class_.setImports(imports);
			class_.addFunction(getAllocFunction(class_.getClassName()));
			this.addObject(className, class_);
			this.currentPackage.addClass(class_);
			return false;

		}
		
	}
	
	private Function getAllocFunction(Identifier className){
		Function f=new Function(null,-1);
		f.setIdentifier(new Identifier("alloc"));
		CompoundStatement statement=new CompoundStatement(null, -1);
		StatementList list=new StatementList(null, -1);
		statement.setStatement(list);
		JumpStatement js=new JumpStatement(null, -1, JumpType.RETURN);
		PrimaryExpression pe=new PrimaryExpression(null, -1, "new "+className.getName()+"()", RefType.IDENTIFIER);
		js.setExpression(pe);
		list.addStatement(js);
		DataType dt=new DataType.ClassType(new Identifier(className.getName()));
		js.setParent(f);
		
		f.setCompoundStatement(statement);
		f.setDataType(dt);
		BasicModifier bm=new BasicModifier(null, BasicModifier.STATIC);
		f.setModifier(bm);
		
		return f;
	}
	public boolean checkKeyExistence(String key){
		  
		//if( symbolTable.containsKey(key) == true) 
			//  System.out.println("key '"+key + "' exists");
	
		return symbolTable.containsKey(key);
	}

	public boolean checkObjectExistence(Object object){
		
		return symbolTable.containsValue(object);
	}
	
	public void addToUnreferencedStack(Object object){
		this.unReferenced.add(object);
	}
	public void setReference(String key, Object object){
		
		Collection nodes = symbolTable.get(key);
	/*	while(nodes.iterator().hasNext()){
			if( ( (ClassInterface) nodes.iterator().next() ).getClassName().getName();
		}*/
	}

	public void resolveReference(String key, Node object){
		
		if(symbolTable.containsKey(key))
			object = (Node) symbolTable.get(key);
		else
			unReferenced.add(object);
		
	}
	
	
	public void printUnreferenced(){
		for(int i = 0;i < unReferenced.size(); i++){
			System.out.println(((Node)unReferenced.elementAt(i)).toString());
		}
	}
	
	public void printRaw(){
		
		System.out.println(symbolTable.asMap().toString());
		
	}
	public void printFormulated(){
		
		Collection entries =  symbolTable.values();
		Iterator<Node> entryIterator = entries.iterator();
		while(entryIterator.hasNext()){
			Node entry = entryIterator.next();
			
			if(entry.getDefinitionType() == IdentifierType.PACKAGE){    //if it is a package
				System.out.println(((PackageDef)entry));
			}
		}
		
		//System.out.println(symbolTable.asMap().values().toString());
	}
	void addToCurrentScope(Node definition){ //pass node
	
		activeScopes.add(definition);

	}
	
	public ArrayList getPackages(){
	    ArrayList<PackageDef> packages = new ArrayList<PackageDef>();
		Collection entries =  symbolTable.values();
		Iterator<Node> entryIterator = entries.iterator();
		while(entryIterator.hasNext()){
			Node entry = entryIterator.next();
			
			if(entry.getDefinitionType() == IdentifierType.PACKAGE){    //if it is a package
			   packages.add((PackageDef)entry);
			}
		}
		return packages;
	}
	Object getCurrentScope(){
		
		if(activeScopes.empty())
			return null;
		
		return activeScopes.peek();
	}

}
