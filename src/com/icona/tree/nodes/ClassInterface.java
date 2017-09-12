package com.icona.tree.nodes;

import java.util.Iterator;

import com.icona.helper.APIMappingTable;
import com.icona.helper.CodeStringBuilder;
import com.icona.helper.DAO.ClassDAO;
import com.icona.tree.nodes.Statement.ListDeclaration;

public class ClassInterface extends Node {

	private boolean isImplementation; //if the class is interface or implementation
	private Identifier className=null;
	private Identifier superClassName=null;
	private ListDeclaration instanceVariables=null;
	
	private ClassInterface superClass = null;
	private ListFunction functions=new ListFunction(null, -1);
	
	private ListProtocol protocols = null; //protocol reference list
	
	private ListImport imports = null;  //list of imports (includes too)
	
	
	public ClassInterface(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
	}
	
	public ListImport getImportList(){
		
		return this.imports;
	}
	public ClassInterface(Node parent, IdentifierType definitionType, int line_no) {
		super(parent, definitionType, line_no);
		// TODO Auto-generated constructor stub
	}
	
	public void setIsImplementation(boolean val){
		isImplementation = val;
	}
	
	public boolean isImplementation(){
		return isImplementation;
	}

	public void addInstanceVariable(Declaration variable){
		
		this.instanceVariables.add(variable);

	}
	

	public void addInstanceVariables(ListDeclaration instanceVariables) {
		
		this.instanceVariables.addAll(instanceVariables);
	}

	@Override
	public String toString(){
		CodeStringBuilder sb= new CodeStringBuilder();
		ClassDAO classDao=APIMappingTable.getClassData(className.getName());
		 sb.appendWithNewLine("package "+((PackageDef)this.parent).getPackageName());
		//TODO: Adding imports
		//if(imports!=null)
		//	sb.append(imports.toString());
		sb.appendWithTab("public class ");
		sb.append(className.toString());
		if(superClassName!=null) sb.append("extends "+superClassName.toString()+" ");
		if(protocols != null){
			String protocolNames = "";
			Iterator it = protocols.getIterator();
			while(it.hasNext()){
				protocolNames +=((Protocol)it.next()).getProtocolName().toString() + (it.hasNext()?",": " ");
			}
		
			sb.append("implements "+ protocolNames);
		}
			sb.appendWithNewLine("{");
		
		CodeStringBuilder.addTab();
		
		if(instanceVariables!=null) sb.append(instanceVariables.toString());
		
		if(classDao!=null) sb.appendWithTabNewLine(classDao.getClassInitBodyUnescaped() );
		CodeStringBuilder.removeTab();
		

		if(functions!=null) sb.append(functions.toString());
		
		
		if(classDao!=null) sb.append(classDao.getClassEndBodyUnescaped());
		sb.appendWithTab("}");
		
		
		return sb.toString();
	}
	
	public Identifier getClassName() {
		return className;
	}


	public void setClassName(Identifier className) {
		this.className = className;
	}


	public Identifier getSuperClassName() {
		return superClassName;
	}


	public void setSuperClassName(Identifier superClassName) {
		this.superClassName = superClassName;
	}


	public ListDeclaration getInstanceVariables() {
		return instanceVariables;
	}


	public void setInstanceVariables(ListDeclaration instanceVariables) {
		this.instanceVariables = instanceVariables;
	}


	public ListFunction getFunctions() {
		return functions;
	}
	
	public void addFunction(Function function){
		function.setOwner(this);
		functions.addFunction(function);
	}
	public void replaceFunctionInList(Function prevFunction, Function newFunction){
		newFunction.setOwner(this);
		functions.replaceFunction(prevFunction, newFunction);
	}


	public void setFunctions(ListFunction functions) {
		this.functions = functions;
	}

	public void setImports(ListImport imports_) {
		this.imports = imports_;
	}

	public void setProtocols(ListProtocol protocols_){
		this.protocols = protocols_;
	}
	@Override
	public void addChild(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node getNextChild(Node existing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getPreviousChild(Node existing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean replaceChild(Node existing, Node by) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node getNextSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getPreviousSibling() {
		// TODO Auto-generated method stub
		return null;
	}


	public ClassInterface getSuperClass() {
		return superClass;
	}


	public void setSuperClass(ClassInterface superClass) {
		this.superClass = superClass;
	}

	public ListProtocol getProtocolList(){
		return protocols;
	}
}
