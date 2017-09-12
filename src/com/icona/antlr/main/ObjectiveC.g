/*
 * Reference:
 * Most of the grammar file rules are taken from http://www.antlr.org/grammar/1212699960054/ObjectiveC2ansi.g
 */
grammar ObjectiveC;

options {
  backtrack=true;
     
}  

scope CurrentFunction{
	Identifier functionName;
	Function function;
}
scope VariableScopeTable{
	VariableScopeTable variableScopeTable;
}

@header{ 
	package com.icona.antlr.main;  
	import java.util.Iterator;
import com.icona.helper.APIMappingTable;
import com.icona.helper.SymbolTable;
import com.icona.helper.VariableScopeTable;
import com.icona.helper.DAO.ClassDAO;
import com.icona.helper.DAO.FunctionDAO;
import com.icona.tree.nodes.BasicModifier;
import com.icona.tree.nodes.ClassInterface;
import com.icona.tree.nodes.Declaration;
import com.icona.tree.nodes.Declaration.AccessType;
import com.icona.tree.nodes.Expression;
import com.icona.tree.nodes.Expression.AssignmentExpression;
import com.icona.tree.nodes.Expression.BinaryExpression;
import com.icona.tree.nodes.Expression.CastExpression;
import com.icona.tree.nodes.Expression.ListExpression;
import com.icona.tree.nodes.Expression.PostfixExpression;
import com.icona.tree.nodes.Expression.PostfixExpression.PostfixExpressionCollector;
import com.icona.tree.nodes.Expression.PostfixExpression.PostfixExpressionCollector.PostfixExpressionType;
import com.icona.tree.nodes.Expression.PrimaryExpression;
import com.icona.tree.nodes.Expression.TertiaryExpression;
import com.icona.tree.nodes.Expression.UnaryExpression;
import com.icona.tree.nodes.Function;
import com.icona.tree.nodes.Function.FunctionType;
import com.icona.tree.nodes.GenericRef.RefType;
import com.icona.tree.nodes.Identifier;
import com.icona.tree.nodes.IdentifierType;
import com.icona.tree.nodes.Import;
import com.icona.tree.nodes.ListClass;
import com.icona.tree.nodes.ListFunction;
import com.icona.tree.nodes.ListImport;
import com.icona.tree.nodes.ListProtocol;
import com.icona.tree.nodes.MessageExpression;
import com.icona.tree.nodes.MethodType;
import com.icona.tree.nodes.Node;
import com.icona.tree.nodes.Operator.AssignmentOperator;
import com.icona.tree.nodes.Operator.AssignmentOperator.AssignmentSymbol;
import com.icona.tree.nodes.Operator.BinaryOperator;
import com.icona.tree.nodes.Operator.BinaryOperator.BinarySymbol;
import com.icona.tree.nodes.Operator.UnaryOperator;
import com.icona.tree.nodes.Operator.UnaryOperator.UnarySymbol;
import com.icona.tree.nodes.PackageDef;
import com.icona.tree.nodes.Parameter;
import com.icona.tree.nodes.Protocol;
import com.icona.tree.nodes.SourceFile;
import com.icona.tree.nodes.Specifier;
import com.icona.tree.nodes.Statement;
import com.icona.tree.nodes.Statement.JumpStatement;
import com.icona.tree.nodes.Statement.JumpStatement.JumpType;
import com.icona.tree.nodes.Statement.ListDeclaration;
import com.icona.tree.nodes.Type.ArrayType;
import com.icona.tree.nodes.Type.DataType;
import com.icona.tree.nodes.Type.DataType.BasicDataType;
import com.icona.tree.nodes.Type.DataType.ClassType;
import com.icona.tree.nodes.Type.PointerType;

}
@members { 
	SourceFile src=new SourceFile(null,-1);
	
	
	public String getCurrentFileNameWithoutExtension(){
		String f=symbolTable.getCurrentFile().getName();            	 		
        String fileName=f.substring(0, f.lastIndexOf('.'));
        return fileName;
	}
	public SourceFile getSrc(){
		return src;
	}
	public void printRawSymbolTable(){
	     
	     symbolTable.printRaw();
	}
	
	public void printFormulatedSymbolTable(){
	     
	     symbolTable.printFormulated();
	}
	private Declaration mergeAndCreateDeclaration(Declaration declaration,Identifier identifier,ArrayType arrayType, Expression initializations,PointerType pointerType){
		Declaration decl=(Declaration)declaration.clone();
		decl.setIdentifier(identifier);
		decl.setArrayDimensions(arrayType);
		decl.setListExpression(initializations);
		decl.setPointerType(pointerType);
		
		return decl;
	}
	
	private BinaryExpression createAndMergeBinaryExpression(Expression parent,int line_no,BinarySymbol op,Expression prev,BinaryExpression addTo,Expression newExpression){
		BinaryExpression temp=new BinaryExpression(parent,line_no,op);
		
		temp.setLhs((Expression)prev);
		temp.setRhs((Expression)newExpression);
		addTo.setRhs((Expression)temp);
		
		return temp;
	}
	
	private AssignmentExpression createAndMergeAssignmentExpression(Expression parent,int line_no,AssignmentSymbol op,Expression prev,AssignmentExpression addTo,Expression newExpression){
		AssignmentExpression temp=new AssignmentExpression(parent,line_no,op);
		
		temp.setTarget((Expression)prev);
		temp.setValue((Expression)newExpression);
		addTo.setValue((Expression)temp);
		
		return temp;
	}
	
	private Declaration mergeSpecifierDetailsWithDeclaration(Declaration specifierDetails,Declaration declaration){
		declaration.setModifier(specifierDetails.getModifier());
		declaration.setSpecifier(specifierDetails.getSpecifier());
		declaration.setDataType(specifierDetails.getDataType());
		
		return declaration;
		
	 }
  
  //TODO why use this function when you can directly add function via rule interface_declaration_list
	private ListFunction mergeProtocolFunctions(ListFunction list1, ListFunction list2){
	   
	   	   if(list2 != null){
			Iterator it = list2.getIterator();
			while(it.hasNext()){
			    	list1.addFunction((Function)it.next());
			    }
			    return list1;
			}
			else
				return list1;      
	}
   
	
	SymbolTable symbolTable = SymbolTable.getInstance();

	 	
    
    //TODO have this function replaced by singleton pattern
    /*public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }*/
    
    	PackageDef packageDef = symbolTable.getCurrentPackage();
	 
	 /*public void setPackage(PackageDef packageDef){
	 
	  this.packageDef = packageDef;//new PackageDef(null, 1, -1);

     }*/

	
	/*
	 * Functions related to scope resolution
	 *
	 */
	 
	 String getVariableType(String id) {
	 	for (int s=$VariableScopeTable.size()-1; s>=0; s--) {
	 		if ( $VariableScopeTable[s]::variableScopeTable.containsVariable(id) ) {
	 			Declaration decl=$VariableScopeTable[s]::variableScopeTable.get(id);
	 			return decl.getDataType().toStringUnformatted();
	 		}
	 	}
	 	System.err.println("SCOPE TABLE:"+id+" not declared");
	 	return null;
	 }
	 
	 String getVariableType(Identifier id) {
	 	for (int s=$VariableScopeTable.size()-1; s>=0; s--) {
	 		if ( $VariableScopeTable[s]::variableScopeTable.containsVariable(id) ) {
	 			Declaration decl=$VariableScopeTable[s]::variableScopeTable.get(id);
	 			return decl.getDataType().toStringUnformatted();
	 		}
	 	}
	 	System.err.println("SCOPE TABLE:"+id+" not declared");
	 	return null;
	 }
	 
	 
	 
	 //list of imports for the current file
     ListImport importsInFile = new ListImport(null, -1); //TODO this object should be someplace else
     
     //list of classes for the current file
     ListClass classesInFile = new ListClass(packageDef, -1);
     
     //List of protocol declaration in current file
     ListProtocol protocolsInFile = new ListProtocol(packageDef, -1);
     
     public static int currentLineNumber=1;
	 
}

 
@lexer::header{
	package com.icona.antlr.main;

}
@lexer::init{
	ObjectiveCParser.currentLineNumber=1;
}
translation_unit:
	 (
	 	ed=external_declaration  
	 )+ EOF;

external_declaration returns [ Function func, ListDeclaration decl]			// works only for 1 function
scope VariableScopeTable;
@init{
	$VariableScopeTable::variableScopeTable=new VariableScopeTable();
	$decl=null;
	$func=null;
}   

	: 
	   d=declaration {
		   //src.addChild((Node)$d.declarations); 
		   $decl=$d.declarations;
		   
		   $VariableScopeTable::variableScopeTable.put($d.declarations); 
		   
		   $d.declarations.setAllDeclarationsAccessType(AccessType.PUBLIC);

		  
	 		
	 		String className="ICONA_GLOBAL_"+getCurrentFileNameWithoutExtension();
	 		ClassInterface c=(ClassInterface)symbolTable.getObject(className,IdentifierType.CLASS);
	 		if(c==null){
	 			c=new ClassInterface(packageDef,IdentifierType.CLASS,-1);
	 			c.setClassName(new Identifier(className)); 
	 			$decl.setAllDeclarationParent(c);
	 			c.setInstanceVariables($decl);
	 			//packageDef.addClass(c);
	 			//System.out.println(c.toString());
	 			symbolTable.addObject(className,c);
	 			//ClassInterface m=(ClassInterface)symbolTable.getObject(className,IdentifierType.CLASS);
	 	
	 		}else{
	 		
	 			$decl.setAllDeclarationParent(c);
	 			c.addInstanceVariables($decl);
	 		}
	 		
	 		for(int i=0;i<$decl.size();i++)
				symbolTable.addObject($decl.get(i).getIdentifier().getName(),$decl.get(i));
	 	
				
	 		

	   }
	 |struct=struct_or_union_definition{
	 	symbolTable.addObject($struct.struct.getClassName().getName(),$struct.struct);
	 	packageDef.addClass($struct.struct);
	 } 
	 | class_interface {src.addChild((Node)$class_interface.classInterface); $class_interface.classInterface.setImports(importsInFile); symbolTable.mergeClasses($class_interface.classInterface,  importsInFile); }
	 | class_implementation {
	 
	 ClassInterface class_ = (ClassInterface) symbolTable.getObject($class_implementation.classImplementation.getClassName().getName(),IdentifierType.CLASS);
	 if(class_!=null)	
	 {	 if(class_.getInstanceVariables()!=null){
			Iterator<Declaration> decl = class_.getInstanceVariables().getIterator();
			while(decl.hasNext())
				decl.next();
		}
	 }
	 src.addChild((Node)$class_implementation.classImplementation); $class_implementation.classImplementation.setImports(importsInFile);symbolTable.mergeClasses($class_implementation.classImplementation, importsInFile); /*classesInFile.addClass($class_implementation.classImplementation);*/ 
	 }
	 
	 | protocol_declaration {src.addChild((Node)$protocol_declaration.protocol); $protocol_declaration.protocol.setImports(importsInFile); protocolsInFile.addProtocol($protocol_declaration.protocol); packageDef.addProtocol($protocol_declaration.protocol); }
	 | COMMENT | LINE_COMMENT | preprocessor_declaration
	 | fd=function_definition {
	 		$fd.functionDefinition.setFunctionType(FunctionType.GLOBAL_METHOD);
	 		
	 		//src.addChild((Node)$fd.functionDefinition); //TODO: Add global functions in a global class
	 		
	 		
	 		$func = new Function(null, IdentifierType.FUNCTION,-1);
	 		$func=$fd.functionDefinition;
	 		
	 		String className="ICONA_GLOBAL_"+getCurrentFileNameWithoutExtension();
	 		ClassInterface c=(ClassInterface)symbolTable.getObject(className,IdentifierType.CLASS);
	 		if(c==null){
	 			c=new ClassInterface(packageDef,IdentifierType.CLASS,currentLineNumber);
	 			c.setClassName(new Identifier(className));
	 			$func.setOwner(c);
	 			c.addFunction($func);
	 			packageDef.addClass(c);
	 			//System.out.println(c.toString());
	 			symbolTable.addObject(className,c);
	 		}else{
	 			$func.setOwner(c);
	 			c.addFunction($func);
	 		} 
	 		
	 		symbolTable.addObject($func.getFunctionName(),$func);
	 		//symbolTable.getObject("GlobalFunction",IdentifierType.FUNCTION);
	 }
	 |protocol_declaration_list
	 |class_declaration_list
	 
	 
	 ;

file_specification
returns [String importName]
@init{
		$importName = "";
}
@after{
///System.out.println($importName);
}
:
 ('<'|'"') (IDENTIFIER   { $importName+=$IDENTIFIER.text; }  ('/' {$importName+="/";} | '\\'  | '.' {$importName+=".";})? )+   ('>' | '"');

macro_specification: '.+';


//****************************
//****************************	
class_name:
	IDENTIFIER; 

superclass_name:
	IDENTIFIER;
	
preprocessor_declaration:
  '#import' file_specification {Import import_ = new Import(null,currentLineNumber); 
  								import_.setImportName(new Identifier($file_specification.importName, IdentifierType.IMPORT));
    							importsInFile.addImport(import_);
    							}
| '#include' file_specification 
| '#define' macro_specification
| '#ifdef' expression
| '#if' expression
| '#undef' expression
| '#ifndef' expression
| '#endif';
		
protocol_interface_declaration
returns [ListFunction functions]
@init{

	ListFunction annotated_ = null;
	ListFunction required_ = null;
	$functions = null;
}
@after{

	if(annotated_ != null && required_ !=null){
		$functions = mergeProtocolFunctions(annotated_, required_);
	}
	else
		$functions = annotated_!=null?annotated_: required_;
}
: 
(interface_declaration_list { required_ = $interface_declaration_list.functions; } )*

(qualified_protocol_interface_declaration { 
   
    annotated_ = mergeProtocolFunctions( $qualified_protocol_interface_declaration.qualifiedList, annotated_);
 })*
 ;

qualified_protocol_interface_declaration
returns [ListFunction qualifiedList]
@init{

$qualifiedList = null;
}
:
      '@optional' interface_declaration_list { $qualifiedList = $interface_declaration_list.functions;   }
    | '@required' interface_declaration_list { $qualifiedList = $interface_declaration_list.functions;   }
    ;

protocol_declaration
returns [Protocol protocol]

@init{
   
    $protocol = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber);
    //symbolTable.setCurrentParent($protocol); //Set protocol as current Parent in symboltable
    }
    :
	'@protocol'
	
   	pName=protocol_name { $protocol.setProtocolName( new Identifier($pName.text) ); }
	
	(':' superclass_name {  	 Identifier className = new Identifier($superclass_name.text,IdentifierType.CLASS);
			                     
			                        if( symbolTable.checkKeyExistence($superclass_name.text) == true){
			                        
			                            System.out.println("ST => superclass'" + $superclass_name.text +"' found in ST and referenced"); 
			                            $protocol.setSuperClass((ClassInterface) symbolTable.getObject($superclass_name.text, IdentifierType.CLASS));
			                           
			                        }
			                        else{
			                        
			                            System.out.println("ST => superclass '" + $superclass_name.text +"' not found..creating placeholder");
			                           
			                            ClassInterface class_ = new ClassInterface(packageDef, IdentifierType.CLASS, -1);
			                            class_.setClassName(className);
			                            $protocol.setSuperClass(class_);
			                            symbolTable.addToUnreferencedStack(class_);
			                           
			                        }
			                        
			             } 
		)?

	( pList = protocol_reference_list )? { $protocol.setProtocolList($pList.protocolRefList); }
	
	( protocol_interface_declaration ){	
		if($protocol_interface_declaration.functions!=null){
			$protocol_interface_declaration.functions.setAllFunctionsParent($protocol);
			$protocol.setFunctions($protocol_interface_declaration.functions); 
			}
		
	}

	'@end'
	; 
	

protocol_declaration_list:
	('@protocol' protocol_list';')
	;
	
protocol_reference_list
 returns [ListProtocol protocolRefList]
 :
	 '<'   protocol_list { $protocolRefList = $protocol_list.listProtocol; }  '>' ;

protocol_list
 returns [ListProtocol listProtocol]
 @init{
 //Protocol protocol_ = (Protocol)symbolTable.getCurrentParent();
 listProtocol=new ListProtocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber);
 }
 :
 
	n1 = protocol_name{
			  				   	       Protocol p1 = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber);  //TODO: packageDef?? shouldn't it be the one the protocol is in
		  							   p1.setProtocolName(new Identifier($n1.text));
			                        
	
	    	  if( symbolTable.checkKeyExistence($n1.text) == true){
		  

			                            System.out.println("ST => protocol'" + $n1.text +"' found and referenced");
			                            
			                          //  protocol_.addReferenceProtocol ( p1 );
			                        }
			                        else{
			                        
			                            System.out.println("ST => protocol '" + $n1.text +"' not found..creating placeholder");
			                           
			                            Protocol placeHolder = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber); 
			                            
			                            placeHolder.setProtocolName(new Identifier($n1.text,IdentifierType.PROTOCOL));
			                            
			                            symbolTable.addToUnreferencedStack(placeHolder);
			                            
                                      //  protocol_.addReferenceProtocol ( p1 );
                                   
                                        $listProtocol.addProtocol(p1);
			                       
			                            }
			                       
			                         }
	 (',' n2=protocol_name{
	 
	 				  Protocol p2 = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber);  //TODO: packageDef?? shouldn't it be the one the protocol is in
	 				  							    
		  	          p2.setProtocolName(new Identifier($n2.text));
	 				  
	 				  if( symbolTable.checkKeyExistence($n2.text) == true){
		  			                        
			                            System.out.println("ST => protocol'" + $n2.text +"' found and referenced");

			                        }
			                        else{
			                        
			                            System.out.println("ST => protocol '" + $n2.text +"' not found..creating placeholder");
			                           
			                            Protocol placeHolder = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber); 
			                            
			                            placeHolder.setProtocolName(new Identifier($n2.text,IdentifierType.PROTOCOL));
			                            
			                            symbolTable.addToUnreferencedStack(placeHolder);
			                        
			                           // protocol_.addReferenceProtocol ( p2 );
			                            
			                            $listProtocol.addProtocol(p2);
			                            
			                            }
	                          
			})*
	; 
	
protocol_name
 returns[String text]
 :
	v = IDENTIFIER {$text = $v.text;};



	 
class_interface
returns [ClassInterface classInterface]
//TODO: Dekhna hai URGENT scope VariableScopeTable;
@init{
     
	$VariableScopeTable::variableScopeTable=new VariableScopeTable();
	$classInterface=new ClassInterface( packageDef, IdentifierType.CLASS, currentLineNumber);
	$classInterface.setIsImplementation(false);

}
:
	
	'@interface'
	(
		class_name { $classInterface.setClassName(new Identifier($class_name.text,IdentifierType.CLASS)); 	symbolTable.setCurrentClass($classInterface);} 
		
		(
			':' superclass_name {  Identifier className = new Identifier($superclass_name.text,IdentifierType.CLASS);
			                       $classInterface.setSuperClassName(new Identifier($superclass_name.text,IdentifierType.CLASS));  
		
			                       
			                        if( symbolTable.checkKeyExistence($superclass_name.text) == true){
			                        
			                            System.out.println("ST => superclass'" + $superclass_name.text +"' found in ST and referenced");
			                            
			                            $classInterface.setSuperClass ( (ClassInterface) symbolTable.getObject($superclass_name.text, IdentifierType.CLASS) );
			                        }
			                        else{
			                        
			                            System.out.println("ST => superclass '" + $superclass_name.text +"' not found..creating placeholder");
			                           
			                            ClassInterface placeHolder = new ClassInterface(packageDef, IdentifierType.CLASS, currentLineNumber); 
			                            
			                            placeHolder.setClassName(new Identifier($superclass_name.text,IdentifierType.CLASS));
			                            
			                            symbolTable.addToUnreferencedStack(placeHolder);
			                            
			                            $classInterface.setSuperClass ( placeHolder ); //or pass it null-not sure
			                               
			                        }
			                        
			                    } 
		)?
	    ( protocol_reference_list )? { $classInterface.setProtocols($protocol_reference_list.protocolRefList); } 
		( 
			instance_variables  {$classInterface.setInstanceVariables($instance_variables.declarations); $VariableScopeTable::variableScopeTable.put($instance_variables.declarations);}
		)?
		(
		 	idl=interface_declaration_list {
		 		$idl.functions.setAllFunctionsOwner($classInterface); //this is already being set
		 		$classInterface.setFunctions($idl.functions);
		 		$classInterface.getInstanceVariables().addAll($idl.declarations); //TODO: Check wether This actually adds to the $classInterface or instead creates new object
		 		
		 	}
		 )?
	)
	'@end'
	;
interface_declaration_list
returns [ListFunction functions,ListDeclaration declarations]
@init{
	$functions = new ListFunction(null,currentLineNumber);
	$declarations=new ListDeclaration(null,currentLineNumber);
	//Protocol protocol_ = (Protocol)symbolTable.getCurrentParent();
}

:
	(
		  declaration 					{$declarations.addAll($declaration.declarations);}
		| class_method_declaration 		{$functions.addFunction($class_method_declaration.function);}
		| instance_method_declaration	{$functions.addFunction($instance_method_declaration.function);}
		| property_declaration
	)+ //TODO: Check if declaration should be in it or not
	;
	
class_method_declaration
returns [Function function]
:
	(
		'+' method_declaration{
			$function=$method_declaration.function;
			$function.setFunctionType(Function.FunctionType.CLASS_METHOD);
		}
	)
	;

instance_method_declaration
returns [Function function]
:
	(
		'-' method_declaration{
			$function=$method_declaration.function;
			$function.setFunctionType(Function.FunctionType.INSTANCE_METHOD);
		}
	)
	;

method_declaration
returns [Function function]
scope CurrentFunction; //This is just for dumy not usable in this method_declaration
@init{
	$function=null;
	MethodType methodType=null;
}

:
	( 
		method_type {methodType=$method_type.methodType;}
	)? method_selector {
		$function=$method_selector.function;
		if(methodType!=null){
			$function.setModifier(methodType.getModifier());
			$function.setSpecifier(methodType.getSpecifier());
			$function.setDataType(methodType.getDataType());
			$function.setArrayType(methodType.getArrayType());
		}
	
	}
	';'
	
	;
	
	
instance_variables
returns [ListDeclaration declarations]
:
	'{' 
		ivd=instance_variable_declaration {$declarations=$ivd.declarations; System.err.println("I have added class vars");}
	'}'
	;

instance_variable_declaration
returns [ListDeclaration declarations]
@init{
	AccessType accessType=AccessType.PRIVATE;
	$declarations=new ListDeclaration(null,currentLineNumber);
}
:
	(
	  vs=visibility_specification {accessType=$vs.accessType;} 
	/*| struct_declarator_list instance_variables */ //TODO: See what the rule struct_declarator_list instance_variables is for
	| struct_declaration {
		$struct_declaration.declarationList.setAllDeclarationsAccessType(accessType);
		$declarations.addAll($struct_declaration.declarationList);
	}
	)+
	;

visibility_specification
returns [AccessType accessType]
:
	'@private' {$accessType=AccessType.PRIVATE;}
	| '@protected' {$accessType=AccessType.PROTECTED;}
	| '@package' {$accessType=AccessType.PACKAGE;}
	| '@public'{$accessType=AccessType.PUBLIC;}
	;


	
class_implementation
returns [ClassInterface classImplementation]
@init{
     
     
     $classImplementation=new ClassInterface(packageDef, IdentifierType.CLASS, currentLineNumber);
     $classImplementation.setIsImplementation(true);
     
  //   ListFunction functions = null;
     
   //  ListDeclaration declarations = null;
}
:
	'@implementation'
	(
		class_name {
			$classImplementation.setClassName(new Identifier($class_name.text,IdentifierType.CLASS));symbolTable.setCurrentClass($classImplementation); 
			ClassInterface ci=(ClassInterface)symbolTable.getInstance().getObject($class_name.text,IdentifierType.CLASS);
			if(ci!=null){
				 $VariableScopeTable::variableScopeTable.put(ci.getInstanceVariables());
				 System.err.println("Added class variable from interface"); 
			}
		} 
		
		( 
			':' superclass_name { Identifier className = new Identifier($superclass_name.text,IdentifierType.CLASS);
			
			                      $classImplementation.setSuperClassName(new Identifier($superclass_name.text,IdentifierType.CLASS));
		                       
			                        if( symbolTable.checkKeyExistence($superclass_name.text) == true){
			                        
			                            System.out.println("ST => superclass'" + $superclass_name.text +"' found and referenced");
			                            
			                            $classImplementation.setSuperClass ( (ClassInterface) symbolTable.getObject($superclass_name.text, IdentifierType.CLASS) );
			                        }
			                        else{
			                        
			                            System.out.println("ST => superclass '" + $superclass_name.text +"' not found..creating placeholder");
			                           
			                            ClassInterface placeHolder = new ClassInterface(packageDef, IdentifierType.CLASS, currentLineNumber); 
			                            
			                            placeHolder.setClassName(new Identifier($superclass_name.text,IdentifierType.CLASS));
			                            
			                            symbolTable.addToUnreferencedStack(placeHolder);
			                            
			                            $classImplementation.setSuperClass ( placeHolder ); 
			                               
			                        }
			                      
			                    }
			
		)?
		
		( 
			idl=implementation_definition_list {
				$idl.functions.setAllFunctionsOwner($classImplementation);
				$classImplementation.setFunctions($idl.functions);
				$classImplementation.setInstanceVariables($idl.declarations);
				//functions = $idl.functions; TODO if something goes wrong uncomment
				//declarations = $idl.declarations;
			}
		)?
		
		
	)
	'@end'
	;
	
implementation_definition_list
returns[ListFunction functions,ListDeclaration declarations]
@init{
$functions=new ListFunction(null,currentLineNumber);
$declarations=new ListDeclaration(null,currentLineNumber);
}
:
	(
		  function_definition  	{$functions.addFunction($function_definition.functionDefinition);}
		| declaration 			{$declarations.addAll($declaration.declarations); $VariableScopeTable::variableScopeTable.put($declaration.declarations); }
		| class_method_definition {$functions.addFunction($class_method_definition.function);}
		| instance_method_definition{$functions.addFunction($instance_method_definition.function);}
		| property_implementation 
	)+;

class_method_definition
returns [Function function]
scope CurrentFunction;
:
	(
		'+' method_definition { 
			$function=$method_definition.function;
			$function.setFunctionType(Function.FunctionType.CLASS_METHOD);
		}
	)
	;

instance_method_definition
returns [Function function]
scope CurrentFunction;
:
	(
		'-' method_definition { 
			$function=$method_definition.function;
			$function.setFunctionType(Function.FunctionType.INSTANCE_METHOD);
		}
		
	)
	;
	
method_definition
returns [Function function]
@init{
	MethodType methodType=null;
}
:
	(
		method_type {methodType=$method_type.methodType;}
	)? 
	method_selector {
		$function=$method_selector.function;
		if(methodType!=null){
			$function.setModifier(methodType.getModifier());
			$function.setSpecifier(methodType.getSpecifier());
			$function.setDataType(methodType.getDataType());
			$function.setArrayType(methodType.getArrayType());
		}
		
		$CurrentFunction::function=$function;
	} 
	/*(init_declarator_list)?*/ 
	cs=compound_statement {
		$function.setCompoundStatement((Statement)$cs.statement);
	}
	
	; //TODO: (init_declarator_list)? is commented coz no parameter yet to pass to it uncomment when implement it

method_selector
returns [Function function]
@init{
	$function=new Function(null, IdentifierType.FUNCTION, currentLineNumber);
}

:
	selector {
		Identifier identifier=new Identifier($selector.text,IdentifierType.FUNCTION);
		$function.setIdentifier(identifier);
		
		
	} 
	| 
	(
		(
			keyword_declarator{
				$function.addParameter($keyword_declarator.parameter);
			}
		)+ 
		
		(
			parameter_list{
				$function.setDeclarationList($parameter_list.declarationList);
			}
		)? 
	)
	;

keyword_declarator
returns [Parameter parameter]
@init{
	$parameter=new Parameter(null,currentLineNumber);
}
:
	(
		selector{
			$parameter.setSelector(new Identifier($selector.text,IdentifierType.SELECTOR));
		}
	)? 
	':' (
		method_type{
			$parameter.addType($method_type.methodType);
		}
		)* id=IDENTIFIER { $parameter.setParameterName(new Identifier($id.text,IdentifierType.PARAM_DECLARATION));}
	;

parameter_list 
returns [ListDeclaration declarationList]
: 
	pdl=parameter_declaration_list /*( ',' '...' )?*/ {
		$declarationList=$pdl.declarationList;
	} //TODO not going to handle variable number of params yet  
	;

parameter_declaration_list
returns [ListDeclaration declarationList]
scope VariableScopeTable;
@init{
	$declarationList=new ListDeclaration(null,currentLineNumber);
	$VariableScopeTable::variableScopeTable=new VariableScopeTable();
}
  : pd1=parameter_declaration {
  		$declarationList.add($pd1.declaration);
  		$VariableScopeTable::variableScopeTable.put($pd1.declaration);
  	} 
  	( 
  		',' pd2=parameter_declaration {
  			$declarationList.add($pd2.declaration);
  			$VariableScopeTable::variableScopeTable.put($pd1.declaration);
  		}
  		
  	)* 
  ;
  
parameter_declaration 
returns [Declaration declaration]
@init{
	$declaration=new Declaration(null,currentLineNumber);
}
  : ds=declaration_specifiers{
  
  	$ds.modifier.setParent((Statement)$declaration);
	$ds.specifier.setParent((Statement)$declaration);
		
	$declaration.setModifier($ds.modifier);
	$declaration.setSpecifier($ds.specifier);
	$declaration.setDataType($ds.dataType);
	
  } (
  
  	(
  		dec=declarator{
  			$declaration.setIdentifier($dec.identifier);
  			$declaration.setArrayDimensions($dec.arrayType);
  		}
  	)? 
  	
  	| ad=abstract_declarator{
  		$declaration.setArrayDimensions($ad.arrayType);
  	}
  	
  	) 
  ;


  
abstract_declarator //TODO: Abstract delarator is uncompleted
returns [Identifier identifier,ArrayType arrayType,ListDeclaration declarationList,PointerType pointerType]
@init{
	$arrayType=null;
	Expression dimension=null;
	$identifier=null;
	$arrayType=null;
	$declarationList=null;
	$pointerType=null;
}

  : 

	'*' type_qualifier* dec=abstract_declarator {
	 	$identifier=$dec.identifier;
	 	$arrayType=$dec.arrayType;
	 	$declarationList=$dec.declarationList;
	 	
	 	$pointerType=$dec.pointerType;
	 	
	 	if($pointerType==null){
	 		$pointerType=new PointerType();
	 	}
	 	$pointerType.incrementPointer();
	 	
	 	
	 }
	 
	 | 
  
  //'(' abstract_declarator ')' abstract_declarator_suffix+ //TODO: abstract_declarator  rule
  //| 
  
  { $arrayType=new ArrayType(); }
  	('[' 
  	{dimension=null;}
  	(c=constant_expression{
  		dimension=$c.expression;	
  	})? 
  	{$arrayType.addDimensionExpression(dimension);}
  	']')+
  | ; //Was | here
  
abstract_declarator_suffix

  : '[' constant_expression? ']'
  | '('  parameter_declaration_list? ')' ;
  
selector:
IDENTIFIER;

method_type
returns [MethodType methodType]
:
	'(' 
		type_name {$methodType=$type_name.methodType;}
	')';

type_name 
returns [MethodType methodType]

@init{
	$methodType=new MethodType(null,currentLineNumber);
}
	: 
	sql=specifier_qualifier_list{
		$methodType.setModifier($sql.modifier);
		$methodType.setSpecifier($sql.specifier);
		$methodType.setDataType($sql.dataType);

	}

    ad=abstract_declarator{
    	$methodType.setArrayType($ad.arrayType);
    	$methodType.setPointerType($ad.pointerType);
    }
  
   ;


struct_or_union_definition
returns [ClassInterface struct]
@init{
	$struct=new ClassInterface(packageDef,IdentifierType.CLASS,currentLineNumber);
	
}
@after{
	$struct.getInstanceVariables().setAllDeclarationsAccessType(AccessType.PUBLIC);
}
: 
  ('typedef')?
  ('struct' | 'union') 
  id=IDENTIFIER {$struct.setClassName(new Identifier($id.text));}
  '{' 
  (
  	sd=struct_declaration{
  		if($struct.getInstanceVariables()==null){
  			$struct.setInstanceVariables($sd.declarationList);
  		}else{
  			$struct.addInstanceVariables($sd.declarationList);
  		}
  	} 
  )+
  '}' (id2=IDENTIFIER{$struct.setClassName(new Identifier($id2.text));})? ';'
  		
   
  ;
  

struct_or_union_specifier
returns [Identifier identifier]
: 
  ('struct' | 'union') 
  ( id=IDENTIFIER {$identifier=new Identifier($id.text);} ) ;
  
struct_declaration 
returns [ListDeclaration declarationList]
@init{
	Declaration specifierDetails=new Declaration(null,currentLineNumber);
}
	: sql=specifier_qualifier_list{
		specifierDetails.setModifier($sql.modifier);
		specifierDetails.setSpecifier($sql.specifier);
		specifierDetails.setDataType($sql.dataType);
	} 
	
	sdl=struct_declarator_list[specifierDetails] {
		$declarationList=$sdl.declarationList;
	}
	
	';' 
	
	;

struct_declarator_list[Declaration specifierDetails]
returns [ListDeclaration declarationList]
@init{
	$declarationList=new ListDeclaration(null,currentLineNumber);
}
 : 
 	sd=struct_declarator{
 		$declarationList.add(mergeSpecifierDetailsWithDeclaration($specifierDetails,$sd.declaration));
 	} 
 	( 
 		',' sdx=struct_declarator{
 			$declarationList.add(mergeSpecifierDetailsWithDeclaration($specifierDetails,$sdx.declaration));
 		}
 		
 	)* ;

struct_declarator
returns [Declaration declaration] 
@init {
	$declaration=new Declaration(null,currentLineNumber);
}
	:
	 dec=declarator {
	 	$declaration.setIdentifier($dec.identifier);
	 	$declaration.setArrayDimensions($dec.arrayType);
	 	//TODO: IMP $dec.declarationList not handled, see what it can be used for and handle it
	 } 
	 
	 | 
	 	(
	 		dec=declarator{
	 			$declaration.setIdentifier($dec.identifier);
	 			$declaration.setArrayDimensions($dec.arrayType);
	 			//TODO: IMP $dec.declarationList not handled, see what it can be used for and handle it
	 		}
	 	)? ':' c=constant {
	 		PrimaryExpression val=new PrimaryExpression($declaration,currentLineNumber,$c.text,RefType.CONSTANT);
	 		$declaration.setInitializationExpression(val);
	 	}
	 	
	 ;

specifier_qualifier_list 
returns [BasicModifier modifier,Specifier specifier,DataType dataType]
@init{ 
//Setting parent to null as its parent rule can define itself who the parent is
	$modifier=new BasicModifier(null);
	$specifier=new Specifier(null);
	$dataType=null;
}
	:
	 (
	 ts=type_specifier_ivar 
	 	{
			
			if($ts.dataType!=null){
				$dataType=$ts.dataType;
				
			}
			else{	
				$specifier.setSpecifier($ts.nativeSpecifier);
				
			}
		}
	 
	 | tq=type_qualifier
	 {
			$modifier.setModifier($tq.modifierType);
			
	 }
	 	
	 	
	 )+ 
	 
	 |
	  tsc=type_specifier_class{$dataType=new ClassType($tsc.identifier);} (tq=type_qualifier{$modifier.setModifier($tq.modifierType);})*
	 
	 ;
	 
type_specifier_ivar
returns [DataType dataType,Specifier.NativeSpecifier nativeSpecifier]
@init{
	$dataType=null;
	$nativeSpecifier=null;
}
	:
	  'void' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.VOID);}
	| 'char' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.CHAR);} 
	| 'short'{$nativeSpecifier=Specifier.NativeSpecifier.SHORT;}
	| 'long' {$nativeSpecifier=Specifier.NativeSpecifier.LONG;} 
	| 'int' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.INT);}
	| 'float' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.FLOAT);}
	| 'double' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.DOUBLE);}
	| 'BOOL' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.BOOLEAN);}
	| 'bool' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.BOOLEAN);}
	| 'signed' {$nativeSpecifier=Specifier.NativeSpecifier.SIGNED;}
	| 'unsigned' {$nativeSpecifier=Specifier.NativeSpecifier.UNSIGNED;}
	| 'unichar'  {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.UNICHAR);}
	 // Missing rules //Long added
		|	ss=struct_or_union_specifier {$dataType=new ClassType($ss.identifier);}
		/*|	enum_specifier */ //TODO: complete type_specifier_ivar
		;

type_specifier_class
returns [Identifier identifier]:
		('id' ( protocol_reference_list )? ){$identifier=new Identifier("id",IdentifierType.ID);} //TODO: add commented protocol_reference_list in type_specifier_class
	|	(class_name ( protocol_reference_list )?) {$identifier=new Identifier($class_name.text,IdentifierType.CLASS);}
	|   id=IDENTIFIER {$identifier=new Identifier($id.text,IdentifierType.CLASS);}
	;


function_definition
returns [Function functionDefinition]
scope CurrentFunction;
@init{
	$functionDefinition=new Function(null,currentLineNumber);
}

	: 
	ds=declaration_specifiers{
		$functionDefinition.setModifier($ds.modifier);
		$functionDefinition.setDataType($ds.dataType);
		$functionDefinition.setSpecifier($ds.specifier);
	}
	declarator{
		$functionDefinition.setIdentifier($declarator.identifier);
		$functionDefinition.setArrayType($declarator.arrayType);
		$functionDefinition.setDeclarationList($declarator.declarationList);
		
		
		$CurrentFunction::function=$functionDefinition;
	}
	
	c=compound_statement{
		$functionDefinition.setCompoundStatement($compound_statement.statement);
	} ;


//******************************

declaration
returns [ListDeclaration declarations]   //TODO Revert to Declaration
@init{

	Declaration tempDecl=new Declaration((Node)src,currentLineNumber);
	
}

	: 
	ds=declaration_specifiers{
	
		$ds.modifier.setParent((Statement)tempDecl);
		$ds.specifier.setParent((Statement)tempDecl);
		
		tempDecl.setModifier($ds.modifier);
		tempDecl.setSpecifier($ds.specifier);
		tempDecl.setDataType($ds.dataType);
		
	}
	
	(
		idl=init_declarator_list[tempDecl]{
			$declarations=$idl.declarationList;
		}
	)?  
	';'	
	;
 
declaration_specifiers
returns [BasicModifier modifier,Specifier specifier,DataType dataType]
@init{ 
//Setting parent to null as its parent rule can define itself who the parent is
	$modifier=new BasicModifier(null);
	$specifier=new Specifier(null);
	$dataType=null;
}

: //TODO Should return something instead of accesing $declaration directly
	(
		s=storage_class_specifier
		{
			$modifier.setModifier($s.modifierType);
			
		} 
		
		| ts=type_specifier
		{	
			if($ts.dataType!=null){
				$dataType=$ts.dataType; 
				
			}
			else{	
				$specifier.setSpecifier($ts.nativeSpecifier);
			
			}
		}
		
		| tq=type_qualifier
		{
			$modifier.setModifier($tq.modifierType);

		}
		
	)+
	|tsc=type_specifier_class{$dataType=new ClassType($tsc.identifier);} (tq=type_qualifier{$modifier.setModifier($tq.modifierType);})*
		
	;
	
init_declarator_list[Declaration tempDecl]
returns [ListDeclaration declarationList]
@init{
	$declarationList=new ListDeclaration(null,currentLineNumber);
}
	:id1=init_declarator
	{
		$declarationList.add(mergeAndCreateDeclaration($tempDecl,$id1.identifier,$id1.arrayType,$id1.initializations,$id1.pointerType));

	} 
	(
		',' idx=init_declarator
		{
			$declarationList.add(mergeAndCreateDeclaration($tempDecl,$idx.identifier,$idx.arrayType,$idx.initializations,$idx.pointerType));
		}
		
	)* 
		
	; 

init_declarator
returns [Identifier identifier,ArrayType arrayType, Expression initializations,PointerType pointerType ] //TODO return the coming expression
@init{
$initializations=null;
ListExpression listExpression=null;
$pointerType=null;
//ListExpression listExpression=new ListExpression(null,-1);
}
@after{
$initializations=(Expression)listExpression;
}


:	d=declarator
	{
	 	$identifier=$d.identifier;
	 	$arrayType=$d.arrayType;
	 	$pointerType=$d.pointerType;
	} 
	('=' 
	
	exp1=initializer{
		listExpression=$exp1.expression;
	} 
	

	)?
	;
initializer 
returns [ListExpression expression ]
@init{
$expression=null;
ListExpression listExpression=new ListExpression(null,currentLineNumber);
}
@after{
$expression=listExpression; //At the end of rule returning the list expression
}

: 		exp1=assignment_expression{
			listExpression.addExpression($exp1.expression);
		}

	| '{' exp2=initializer{
			listExpression.addExpression($exp2.expression);

		
		} 
	
	 (',' exp3=initializer{
			listExpression.addExpression($exp3.expression);
			}
	 
	 
	 )* '}' ;
	    

declarator
returns [Identifier identifier,ArrayType arrayType,ListDeclaration declarationList,PointerType pointerType] //TODO: Later put this into something in STRUCT
@init{
	$identifier=null;
	$arrayType=null;
	$declarationList=null;
	$pointerType=null;
}
	: 
	 '*' type_qualifier* dec=declarator {
	 	$identifier=$dec.identifier;
	 	$arrayType=$dec.arrayType;
	 	$declarationList=$dec.declarationList;
	 	
	 	$pointerType=$dec.pointerType;
	 	
	 	if($pointerType==null){
	 		$pointerType=new PointerType();
	 	}
	 	$pointerType.incrementPointer();
	 	
	 	
	 }
	|
	 d=direct_declarator  
	 {
	 	$identifier=$d.identifier;
	 	$arrayType=$d.arrayType;
	 	$declarationList=$d.declarationList;
	 }
	;
	 
direct_declarator
returns [Identifier identifier,ArrayType arrayType,ListDeclaration declarationList]

@init{
	$identifier=null;
	$arrayType=null;
	$declarationList=null;
}

	:
	  id=identifier
	  {
	  	$identifier=new Identifier($id.text,IdentifierType.DECLARATION);
	  } 
	  (
	  	ds=declarator_suffix
	  	{
	  		if($ds.declarationList!=null)
	  			$declarationList=$ds.declarationList;
	  		if($arrayType==null)
	  			$arrayType=new ArrayType();
	  		
	  		if($ds.dimension==-1)
	  			$arrayType.addDimension();
	  		else
	  			$arrayType.addDimension($ds.dimension);
	  	}
	  	
	  )* 
	
	//| '(' declarator ')' declarator_suffix* //TODO rule of direct_declarator
	
	;
	
declarator_suffix
returns [int dimension,ListDeclaration declarationList]
@init{
	$dimension=-1;
	$declarationList=null;
}
	:
	'[' 
		(
			c=constant
			{
				$dimension=Integer.parseInt($c.text);
			}
		)? 
	']'
			 //Changed to constant
			 
	| 
	
	'(' 
		(
			parameter_list {$declarationList=$parameter_list.declarationList;}
		)? 
		
	')'
	 
	; // one rule missing for e.g  String()
	
   

type_specifier
returns [Specifier.NativeSpecifier nativeSpecifier,DataType dataType]
@init{
	$nativeSpecifier=null;
	$dataType=null;
}
	:
	  'void' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.VOID);}
	| 'char' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.CHAR);} 
	| 'short'{$nativeSpecifier=Specifier.NativeSpecifier.SHORT;}
	| 'long' {$nativeSpecifier=Specifier.NativeSpecifier.LONG;} 
	| 'int' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.INT);}
	| 'float' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.FLOAT);}
	| 'double' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.DOUBLE);}
	| 'BOOL' {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.BOOLEAN);}
	| 'signed' {$nativeSpecifier=Specifier.NativeSpecifier.SIGNED;}
	| 'unsigned' {$nativeSpecifier=Specifier.NativeSpecifier.UNSIGNED;}
	| 'unichar'  {$dataType=new BasicDataType(DataType.BasicDataType.NativeType.UNICHAR);} 
	
	; // Missing rules //Long added
	
type_qualifier 
returns [int modifierType]
	:
	  'const' {$modifierType=BasicModifier.CONST;} 
	| 'volatile' {$modifierType=BasicModifier.VOLATILE;}
	; // missing rules
	
storage_class_specifier 
returns [int modifierType]

	:
	  'auto' {$modifierType=BasicModifier.AUTO;} 
	| 'register' {$modifierType=BasicModifier.REGISTER;} 
	| 'static' {$modifierType=BasicModifier.STATIC;} 
	| 'extern'  {$modifierType=BasicModifier.EXTERN;}
	
	; // Should be changed //Typedef removed
	
	
statement
returns [Statement statement]

@init{
$statement=null;
}
:
   sel_stmt=selection_statement{
     $statement=$sel_stmt.statement;
     }
     
    | decl=declaration {
    	$statement = $decl.declarations; 
    	$statement.setParent($CurrentFunction::function); 
    	$VariableScopeTable::variableScopeTable.put($decl.declarations);
    }
    | exp=expression ';'{ $statement=(Statement)$exp.expression;$statement.setParent($CurrentFunction::function); }
    | cmp_stmt=compound_statement{ $statement=$cmp_stmt.statement; $statement.setParent($CurrentFunction::function);}
    | itr_stmt=iteration_statement{$statement=$itr_stmt.Stmt; $statement.setParent($CurrentFunction::function);}
    | label_stmt = labeled_statement { $statement = $label_stmt.Stmt; $statement.setParent($CurrentFunction::function);}
    | jmp_stmt=jump_statement { $statement = $jmp_stmt.statement; $statement.setParent($CurrentFunction::function);} 
    | ';' //Statement can only return null here
    ;

jump_statement
returns[Statement statement]
  : 'goto' identifier ';'{$statement=new JumpStatement(null,currentLineNumber,JumpType.GOTO);}
  | 'continue' ';' {$statement=new JumpStatement(null,currentLineNumber,JumpType.CONTINUE);}
  | 'break' ';' {$statement=new JumpStatement(null,currentLineNumber,JumpType.BREAK);}
  | 'return' { 
  		$statement=new JumpStatement(null,currentLineNumber,JumpType.RETURN);
  		((JumpStatement)$statement).setCastingTypeInReturn(((Function)$CurrentFunction::function).getDataType());
  } 
  
  	(
  		expression {((JumpStatement)$statement).setExpression($expression.expression);}
  	)? ';' 
  ;
  
labeled_statement
returns [Statement Stmt]
@init{

   Statement.LabelStatement lStmt = null;
   Statement.CaseDefaultStatement cStmt = null;

}
  :  v = identifier { lStmt = new Statement.LabelStatement( null, - 1 );  lStmt.setIdentifier( $v.identifier ); } 
    ':'        
     s = statement { lStmt.setStatement( $s.statement ); $Stmt = ( Statement ) lStmt; }
     
  | 'case' { cStmt = new Statement.CaseDefaultStatement( null, - 1); }
     ce = constant_expression { cStmt.setConstExpression( $ce.expression ); }  
    ':'
     s = statement { cStmt.setStatement( $s.statement ); $Stmt = ( Statement ) cStmt; }
     
  | 'default' {cStmt = new Statement.CaseDefaultStatement( null, - 1 ); }
    ':'
     s = statement { cStmt.setStatement( $s.statement ); $Stmt = ( Statement ) cStmt; } 
  ;


selection_statement
returns [Statement statement]
@init{
$statement=null;
Statement.If statement_i=null;
Statement.Switch statement_s=null;

}
@end{ 
	if(statement_i!=null) $statement=(Statement)statement_i;
	else if(statement_s!=null) $statement=(Statement)statement_s;
}

: 
  'if' '(' 
   exp=expression{
   statement_i=new Statement.If(null,currentLineNumber);
    statement_i.setExpression($exp.expression);
   }   
   ')'
    stmtIf=statement{
      statement_i.setIfStatement($stmtIf.statement);
    
    }
    ('else'
     stmtElse=statement{
      statement_i.setElseStatement($stmtElse.statement);
      
     })?{$statement=(Statement)statement_i;}
     
     | 'switch' 
      '('
      
       exp=expression{
       statement_s=new Statement.Switch(null,currentLineNumber);
        statement_s.setExpression($exp.expression);
       }
        
       ')'
       switch_stmt=statement{
       statement_s.setSwitchStatement($switch_stmt.statement);
       $statement=(Statement)statement_s;
       } 
     
     ;
iteration_statement  
returns [Statement Stmt]
@init{
    $Stmt = null;
    Statement.While whileStmt = null; 
    Statement.ForLoop forStmt = null;
    Statement.doWhile doStmt = null;
}
  : 'while'  {  whileStmt = new Statement.While( null, currentLineNumber ); }
     	'(' 
  	    	e = expression { whileStmt.setExpression( $e.expression ); }
  		')' 
  	    	s=statement { whileStmt.setStatement( $s.statement );  $Stmt = ( Statement ) whileStmt; }
  
  | 'do' { doStmt = new Statement.doWhile( null, currentLineNumber ); }
          s = statement { doStmt.setStatement( $s.statement ); }
         'while' 
          '('
          e = expression { doStmt.setExpression( $e.expression ); }
          ')' 
          ';' { $Stmt = ( Statement ) doStmt; }
          
  | 'for' { forStmt = new Statement.ForLoop( null, currentLineNumber ); }
        '('      
         ( (e1 = expression { forStmt.setExprInit( $e1.expression ); })? ';' | decl=declaration {forStmt.setDeclInit($decl.declarations); } )? //Added declaration
         
         ( e2 = expression { forStmt.setExprCondition( $e2.expression ); } )?
         ';'
         ( e3 = expression { forStmt.setExprLast( $e3.expression ); } )?
        ')'
         s = statement { forStmt.setStatement( $s.statement ); $Stmt = ( Statement ) forStmt;  } ;
 

compound_statement 
returns [Statement.CompoundStatement statement]
scope VariableScopeTable;
@init{
$statement=new Statement.CompoundStatement(null,currentLineNumber);
$VariableScopeTable::variableScopeTable=new VariableScopeTable();
}
:
   '{'
    //Removed declarations
    (stmt_list=statement_list{
       $statement.setStatement($stmt_list.statement);
   
    })? 
    
    '}'
;

statement_list
returns [Statement.StatementList statement]
@init{
$statement=new Statement.StatementList(null,currentLineNumber);
}
:
 (
 stmt=statement{
 	if($stmt.statement!=null) $statement.addStatement($stmt.statement); 
 }
 
 )+
;
//######NEW RULES FOR EXPRESSION ######//

expression
returns [Expression expression] //TODO return the coming expression
@init{
$expression=null;
ListExpression listExpression=new ListExpression(null,currentLineNumber);
}
@after{
$expression=(Expression)listExpression; //At the end of rule returning the list expression
}
: //TODO Change it to something better instead of adding it to src directly
	exp1=assignment_expression{
		listExpression.addExpression($exp1.expression);
		//src.addChild((Statement) $exp1.expression);//TODO the src.addChild here should be removed, only for testing purpose
	} 
	
	(
		',' expx=assignment_expression{
			listExpression.addExpression($expx.expression);
			//src.addChild((Statement) $expx.expression);//TODO the src.addChild here should be removed, only for testing purpose
		} 
		
	)* ;

assignment_expression
returns [AssignmentExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	AssignmentExpression addTo=null; //Will tell where to add 
	$expression=new AssignmentExpression(null,currentLineNumber,null);
	addTo=$expression;
	AssignmentSymbol symbol=null;
}
	:
	exp1=conditional_expression {
		$expression.setTarget((Expression)$exp1.expression);
	} 
	
	
	(
		op=assignment_operator{symbol=$op.symbol;} 
		
		expx=assignment_expression{
			if(prev == null){
				$expression.setOperator(op);
				$expression.setValue((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeAssignmentExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
		
	)? ;
	
assignment_operator  
returns [AssignmentSymbol symbol] 
	: 
	  '=' {$symbol=AssignmentOperator.AssignmentSymbol.EQUAL;}
	| '*='{$symbol=AssignmentOperator.AssignmentSymbol.MUL_EQUAL;} 
	| '/=' {$symbol=AssignmentOperator.AssignmentSymbol.DIV_EQUAL;}
	| '%=' {$symbol=AssignmentOperator.AssignmentSymbol.MOD_EQUAL;}
	| '+=' {$symbol=AssignmentOperator.AssignmentSymbol.ADD_EQUAL;}
	| '-=' {$symbol=AssignmentOperator.AssignmentSymbol.SUB_EQUAL;}
	| '<<=' {$symbol=AssignmentOperator.AssignmentSymbol.SHL_EQUAL;}
	| '>>=' {$symbol=AssignmentOperator.AssignmentSymbol.SHR_EQUAL;}
	| '&=' {$symbol=AssignmentOperator.AssignmentSymbol.BITWISE_AND_EQUAL;}
	| '^=' {$symbol=AssignmentOperator.AssignmentSymbol.BITWISE_XOR_EQUAL;}
	| '|=' {$symbol=AssignmentOperator.AssignmentSymbol.BITWISE_OR_EQUAL;}
	;
	

conditional_expression
returns [TertiaryExpression expression]
@init{
	$expression=new TertiaryExpression(null,currentLineNumber);
}
	: //tertiary operator
	exp1=logical_or_expression{
		$expression.setConditionExpression((Expression)$exp1.expression);
	} 
	
	(
		'?' exp2=logical_or_expression{
			$expression.setIfExpression((Expression)$exp2.expression);
		} 
		
		':' exp3=logical_or_expression{
			$expression.setElseExpression((Expression)$exp3.expression);
		} 
		
	)? ;
	
constant_expression
returns [Expression expression]
: exp = conditional_expression { expression = $exp.expression; } ;

logical_or_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=logical_and_expression {
		$expression.setLhs((Expression)$exp1.expression);
	}
	
	(
		'||' {$expression.setOperator(BinaryOperator.LogicalOperator.OR);} 
		
		expx=logical_and_expression {
			if(prev == null){
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
	)* ;
	
logical_and_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=inclusive_or_expression {
		$expression.setLhs((Expression)$exp1.expression);
	}
	(
		'&&' {$expression.setOperator(BinaryOperator.LogicalOperator.AND);}
		
		expx=inclusive_or_expression{
			if(prev == null){
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
		
	)* ;
	
inclusive_or_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=exclusive_or_expression {
		$expression.setLhs((Expression)$exp1.expression);
	}
	
	(
		'|' {$expression.setOperator(BinaryOperator.BitwiseOperator.OR);} 
		
		expx=exclusive_or_expression{
			if(prev == null){
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
		
	)* ;
	
exclusive_or_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=and_expression {
		$expression.setLhs((Expression)$exp1.expression);
	}
	
	(
		'^' {$expression.setOperator(BinaryOperator.BitwiseOperator.XOR);}
		 
		expx=and_expression{
			if(prev == null){
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
		
	)* ;
	
and_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=equality_expression {
		$expression.setLhs((Expression)$exp1.expression);
	}
	
	(
		'&' {$expression.setOperator(BinaryOperator.BitwiseOperator.AND);}
		
		expx=equality_expression{
			if(prev == null){
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
		
	)* ;
	
equality_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	BinarySymbol op=null;
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=relational_expression{ 
		$expression.setLhs((Expression)$exp1.expression);
	}
	 
	( 
		(
			'!=' {op=BinaryOperator.RelationalOperator.NOT_EQUAL;} 
			| '==' {op=BinaryOperator.RelationalOperator.EQUAL;} 
		) 
		
		expx=relational_expression{
			if(prev == null){
				$expression.setOperator(op);
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
	)* ;
	
relational_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	BinarySymbol op=null;
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=shift_expression{ 
		$expression.setLhs((Expression)$exp1.expression);
	} 
	( 
		(
			'<' {op=BinaryOperator.RelationalOperator.LESS;} 
			| '>' {op=BinaryOperator.RelationalOperator.GREATER;} 
			| '<=' {op=BinaryOperator.RelationalOperator.LESS_EQUAL;} 
			| '>=' {op=BinaryOperator.RelationalOperator.GREATER_EQUAL;} 
		) 
		
		expx=shift_expression{
			if(prev == null){
				$expression.setOperator(op);
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
	)*;
	
shift_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	BinarySymbol op=null;
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=additive_expression { 
		$expression.setLhs((Expression)$exp1.expression);
	} 
	(
		(
			'<<' {op=BinaryOperator.ShiftOperator.SHL;} 
			| '>>'{op=BinaryOperator.ShiftOperator.SHR;} 
		) 
		
		expx=shift_expression{
			if(prev == null){
				$expression.setOperator(op);
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
	)* ;
	
additive_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	BinarySymbol op=null;
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=multiplicative_expression { 
		$expression.setLhs((Expression)$exp1.expression);
	} 
	(
		(
			'+' {op=BinaryOperator.ArithOperator.ADD;} 
			|'-'{op=BinaryOperator.ArithOperator.SUB;} 
		) 
		
		expx=multiplicative_expression{
			if(prev == null){
				$expression.setOperator(op);
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
	)* ;
	
multiplicative_expression
returns [BinaryExpression expression]
@init{
	Expression prev=null; //Will tell the prvious expression added;
	BinaryExpression addTo=null; //Will tell where to add
	BinarySymbol op=null;
	$expression=new BinaryExpression(null,currentLineNumber,null);
	addTo=$expression;
}
	:
	exp1=cast_expression{ 
		$expression.setLhs((Expression)$exp1.expression);
	} 
	(
		(
			'*' {op=BinaryOperator.ArithOperator.MUL;} 
			| '/' {op=BinaryOperator.ArithOperator.DIV;} 
			| '%'{op=BinaryOperator.ArithOperator.MOD;} 
		) 
		
		expx=cast_expression{ 
			if(prev == null){
				$expression.setOperator(op);
				$expression.setRhs((Expression) $expx.expression);
			}
			else{
				addTo=createAndMergeBinaryExpression(null,currentLineNumber,$expression.getOperator(),prev,addTo,(Expression)$expx.expression);
			}
			prev=$expx.expression;
			
		}
	)* ; 
	
cast_expression
returns [Expression  expression] //TODO should be UnaryExpression
@init{
	CastExpression castExpression=new CastExpression(null,currentLineNumber);
}
@after{
	$expression=castExpression;
}
	:
	'(' type_name ')' c=cast_expression { 
		castExpression.setCastedType($type_name.methodType);
		castExpression.setChildCastExpression((Expression)$c.expression); 
	} 
	|
	ex=unary_expression {castExpression.setUnaryExpression($ex.expression);} 
	; 
	
unary_expression
returns [UnaryExpression expression]
@init{
	UnarySymbol operator=null;
}
	:
	  exp=postfix_expression {$expression=new UnaryExpression(null,currentLineNumber,null,(Expression)$exp.expression);}
	| '++' exp=unary_expression  {$expression=new UnaryExpression(null,currentLineNumber,UnarySymbol.PRE_INC,(Expression)$exp.expression);}
	| '--' exp=unary_expression  {$expression=new UnaryExpression(null,currentLineNumber,UnarySymbol.PRE_DEC,(Expression)$exp.expression);}
	| op=unary_operator{operator=$op.symbol;} exp=cast_expression{$expression=new UnaryExpression(null,currentLineNumber,operator,(Expression)$exp.expression);}
	| 'sizeof' ('(' type_name ')' | unary_expression) //TODO: Implement size of
	; 
	
unary_operator
returns [UnarySymbol symbol]
	: 
	  '&' {$symbol=UnaryOperator.UnarySymbol.REFERENCE;} 
	| '*' {$symbol=UnaryOperator.UnarySymbol.DEREFERENCE;}
	| '-' {$symbol=UnaryOperator.UnarySymbol.SIGN_MINUS;}
	| '~' {$symbol=UnaryOperator.UnarySymbol.BITWISE_NOT;}
	| '!' {$symbol=UnaryOperator.UnarySymbol.LOGICAL_NOT;}
	
	;

postfix_expression
returns [PostfixExpression expression]
@init{
	$expression=new PostfixExpression(null,currentLineNumber);
	ListExpression expressions=null;
}
	:
	exp1=primary_expression {$expression.setPrimaryExpression($exp1.expression);}
	
	( 
	      '[' exp2=expression ']'{
	      	$expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.ARRAY,$exp2.expression));
	      	$expression.setArr(true);
	      } 
	    | '(' {expressions=null;}
	    	 (ael=argument_expression_list {expressions=$ael.expressions;} )? 
	       ')' {
	       
	       	
	       	Function f=(Function)symbolTable.getObject(expression.toString(),IdentifierType.FUNCTION);
	        if(f!=null)
	        	$expression.getPrimaryExpression().setGlobalReference(f.getOwnerName());
	       	$expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.FUNCTION_CALL,expressions));
	       } 
	    | '.' id1=identifier  {
	       	$expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.DEREFER,$id1.identifier));
	       }
	    | '->' id2=identifier{
	       	$expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.POINTER_DEREFER,$id2.identifier));
	       }
		| '++' {
	       	$expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.POST_INC,new UnaryOperator(UnarySymbol.POST_INC)));
	       }
		| '--' {
	       	$expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.POST_DEC,new UnaryOperator(UnarySymbol.POST_INC)));
	       }
	)* //TODO: Check wether something like [3]++[2][4] can come or not
	 
	;
	
argument_expression_list
returns[ListExpression expressions]
@init{
	$expressions=new ListExpression(null,currentLineNumber);
}
  : a1=assignment_expression{
  		$expressions.addExpression($a1.expression);
  	} 
  	( ',' 
  		ax=assignment_expression{
  			$expressions.addExpression($ax.expression);
  		}
  		
  	)* ;

primary_expression
returns [PrimaryExpression expression]
	:
	  id1=IDENTIFIER {$expression=new PrimaryExpression(null,currentLineNumber,$id1.text,RefType.IDENTIFIER);}
	| id2=constant	{$expression=new PrimaryExpression(null,currentLineNumber,$id2.text,RefType.CONSTANT);}
	| ('@')? id3=STRING_LITERAL {$expression=new PrimaryExpression(null,currentLineNumber,$id3.text,RefType.STRING);}
	| ('(' exp=expression ')') {$expression=new PrimaryExpression(null,currentLineNumber,$exp.expression);$expression.setHasParanthesis(true);}
	| mexp=message_expression {$expression=new PrimaryExpression(null,currentLineNumber,$mexp.expression);}
	| 'self' {$expression=new PrimaryExpression(null,currentLineNumber,"this",RefType.IDENTIFIER);}
	; // missing rules
	
	
message_expression
returns [MessageExpression expression]
@init{
	Expression rec=null;
}
:
	('[' 
		rece=receiver {rec=$rece.expression;}
		message_selector {
			$expression=$message_selector.expression;
			$expression.setReceiver(rec);
			
			ClassDAO cDao=APIMappingTable.getClassMapping($expression.getReceiverName());
			
			if(cDao!=null){
				$expression.setMappedReceiverName(cDao.className.getName());
				
			}
			
			String receiverType=getVariableType($expression.getReceiverName() ); 
			if(receiverType!=null){
				FunctionDAO dao=APIMappingTable.getFunctionMapping(receiverType,$expression.getFunctionName() );
				if(dao!=null){
					
					if($expression.getMessageName()!=null){ 
						$expression.setMessageName(dao.functionName);
					}
					else{
						$expression.setMappedMessageName(dao.functionName.getName());
					}
					$expression.setTotalMappedParameterLength(dao.getNumberOfParameters());
				}
			}
		}
	']')
	;
	
receiver
returns [Expression expression]
:
	  exp=expression{$expression=$exp.expression;}
	| class_name 	{$expression=new PrimaryExpression(null,currentLineNumber,$class_name.text,RefType.IDENTIFIER);}
	| 'super'		{$expression=new PrimaryExpression(null,currentLineNumber,"super",RefType.IDENTIFIER);}
	;

message_selector
returns [MessageExpression expression]
@init{
	$expression=new MessageExpression(null,currentLineNumber);
}
:
	selector {$expression.setMessageName(new Identifier($selector.text,IdentifierType.SELECTOR));}
	| (
		keyword_argument{$expression.addParameter($keyword_argument.parameter);}
	  )+
	
	;

keyword_argument
returns [Parameter parameter]
@init{
$parameter=new Parameter(null,currentLineNumber);
}
:
	(
		selector{$parameter.setSelector(new Identifier($selector.text,IdentifierType.SELECTOR));}
	)? 
	':' expression {$parameter.setMessageCallingExpression($expression.expression);}
	;

//@property grammar
property_declaration
	:	'@property' property_attributes_declaration? 'IBOutlet'? struct_declaration
    ;

property_attributes_declaration
    :	'(' property_attributes_list ')'
    ;

property_attributes_list
    :	property_attribute
    | property_attribute (',' property_attribute)*
    ;

property_attribute
    : 
    	  'nonatomic' | 'readwrite'| 'readonly'|'retain'| 'assign' | 'copy'
    ;

//@synthesize grammar
property_implementation
    : '@synthesize' property_synthesize_list ';'
    ;

property_synthesize_list
    : property_synthesize_item (',' property_synthesize_item)*
    ;

property_synthesize_item
    : identifier
    ;
    
//@class
class_declaration_list:
	('@class' class_list';')
	;

class_list:
	class_name (',' class_name)*;
	

//################# END ###############//

 
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;System.err.print($line+":"+$text);} //TODO: Add the comments into code too
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;ObjectiveCParser.currentLineNumber++;System.err.print($line+":"+$text);} //TODO: Add the comments into generated code to
    ;

identifier
returns [ Identifier identifier ]
: v = IDENTIFIER { $identifier = new Identifier( $identifier.text ); };

constant: DECIMAL_LITERAL | HEX_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | FLOATING_POINT_LITERAL ;

IDENTIFIER
	:	LETTER (LETTER|'0'..'9')*
	;
	
fragment
LETTER
	:	'$'
	|	'A'..'Z'
	|	'a'..'z'
	|	'_'
	;

CHARACTER_LITERAL
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

HEX_LITERAL : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

DECIMAL_LITERAL : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

OCTAL_LITERAL : '0' ('0'..'7')+ IntegerTypeSuffix? ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
IntegerTypeSuffix
	:	('u'|'U'|'l'|'L')
	;

FLOATING_POINT_LITERAL
    :   ('0'..'9')+ ('.' ('0'..'9')*)? Exponent? FloatTypeSuffix?
	;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n'{ObjectiveCParser.currentLineNumber++;})+ {$channel=HIDDEN;}
    ;
