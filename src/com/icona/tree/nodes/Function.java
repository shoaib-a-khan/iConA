package com.icona.tree.nodes;

import java.util.ArrayList;
import java.util.Iterator;

import com.icona.helper.APIMappingTable;
import com.icona.helper.CodeStringBuilder;
import com.icona.helper.DAO.ClassDAO;
import com.icona.helper.DAO.FunctionDAO;
import com.icona.tree.nodes.Statement.CompoundStatement;
import com.icona.tree.nodes.Statement.ListDeclaration;
import com.icona.tree.nodes.Type.ArrayType;
import com.icona.tree.nodes.Type.DataType;

public class Function extends Node {

	private BasicModifier modifier=null;
	private DataType dataType=null;
	private Specifier specifier=null;
	
	private Identifier identifier=null;
	
	private ArrayType arrayType;
	private ListDeclaration declarationList;
	
	private ArrayList<Parameter> parameters=null;
	
	private Statement compoundStatement;
	
	private ClassInterface owner=null;  
	
	private Node parent = null;  ////TODO owner should be replaced by this
	
	private FunctionType functionType=null;
	
	
	public static enum FunctionType{
		CLASS_METHOD("static"),INSTANCE_METHOD(""),GLOBAL_METHOD("static");
		
		String type;
		private FunctionType(String type){
			this.type=type;
		}
		
		public String toString(){return type;}
	}
	
	
	
	public Function(Node parent, int line_no) {
		super(parent, line_no);
		
		parameters=new ArrayList<Parameter>();
		functionType=FunctionType.INSTANCE_METHOD;
	}
	
	public Function(Node parent, IdentifierType definitionType, int line_no) {
		super(parent, definitionType, line_no);
		
		parameters=new ArrayList<Parameter>();
		functionType=FunctionType.INSTANCE_METHOD;
	}
	
	
	public ArrayList getParameterList(){
		
		return parameters;
	}
	
	public Iterator<Parameter> getParameterIterator(){
		return parameters.iterator();
	}
	public void setParent(Node parent_){
		
		this.parent = parent_;
	}
	public Node getParent(){
		return this.parent;
	}
	public ClassInterface getOwner() {
		return owner;
	}


	public void setOwner(ClassInterface owner) {
		this.owner = owner;
	}


	public FunctionType getFunctionType() {
		return functionType;
	}


	public void setFunctionType(FunctionType functionType) {
		this.functionType = functionType;
	}


	public void addParameter(Parameter param){
		this.parameters.add(param);
		
	}
	
	public Parameter getParameterAt(int index){
		return this.parameters.get(index);
	}
	
	public ListDeclaration getDeclarationList() {
		return declarationList;
	}


	public void setDeclarationList(ListDeclaration declarationList) {
		this.declarationList = declarationList;
	}


	public ArrayType getArrayType() {
		return arrayType;
	}
	
	public void setArrayType(ArrayType arrayType) {
		this.arrayType = arrayType;
	}

	public BasicModifier getModifier() {
		return modifier;
	}

	public void setModifier(BasicModifier modifier) {
		this.modifier = modifier;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType type) {
		this.dataType = type;
	}

	public Specifier getSpecifier() {
		return specifier;
	}

	public void setSpecifier(Specifier specifier) {
		this.specifier = specifier;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	public Statement getCompoundStatement() {
		return compoundStatement;
	}

	public void setCompoundStatement(Statement compoundStatement) {
		this.compoundStatement = compoundStatement;
		this.compoundStatement.setParent(this);
	}

	private String createFunctionName(){
		String s="";
		for(int i=0;i<parameters.size();i++){
			if(parameters.get(i).getSelector()!=null) //If there is no selector for a parameter
				s+=((i==0)?"":"_")+parameters.get(i).getSelector().unIndentatedString();
		}
		return s;
	}
	
	public String getFunctionName(){
		if(identifier!=null)
			return identifier.unIndentatedString();
		return createFunctionName();
	}
	
	public FunctionDAO getFunctionMappingDAOOrFunctionDAO(){
		String className=(owner==null)? "":owner.getClassName().getName();

		String functionName=getFunctionName();
		System.err.print(className+":"+functionName);
		FunctionDAO dao=APIMappingTable.getFunctionMapping(className, functionName);
		if(dao!=null)
			System.err.print("Function MApping available");
		if(dao==null){
			if(owner!=null && owner.getSuperClassName()!=null){
				className=owner.getSuperClassName().getName();
				ClassDAO classDao=APIMappingTable.getClassMapping(className);
				if(classDao!=null) className=classDao.className.getName();
				
				//System.err.print("  "+className+":"+functionName);
				dao=APIMappingTable.getFunctionMapping(className, functionName);
				if(dao!=null)
					dao=getFunctionDAO();
			}
			else{
				dao=getFunctionDAO();
			}
			
		}
		System.err.println();
		
		return dao;
	}
	@Override
	public String toString(){
		
		FunctionDAO dao=getFunctionMappingDAOOrFunctionDAO();
		
		
		CodeStringBuilder sb=new CodeStringBuilder();
		CodeStringBuilder.addTab();
		
		if(dao!=null && dao.comment!=null)
			sb.appendWithTabNewLine(dao.comment);
		
		sb.appendWithTab("public ");
		sb.append(functionType.toString()+" ");
		sb.append(modifier.toString()+" ");//TODO: Check if modifier should be after or not
		
		//Mapping the return type if provided in the function mapping
		if(dao!=null && !dao.returnType.equals("")){
			sb.append(dao.returnType);
			sb.append(" ");
		}
		else{
			sb.append(dataType.toString());
			sb.append(" ");
		}
		
		//Mapping the function name if provided in the mapping
		if(dao!=null && dao.functionName!=null && !dao.functionName.getName().equals("")){
			sb.append(dao.functionName.unIndentatedString());
		}
		else{
			if(identifier!=null)
				sb.append(identifier.unIndentatedString());
			else
				sb.append(createFunctionName());
			
		}
		sb.append("(");
		
		/*
		 *If the function is global C type functions then its parameters 
		 *are stored in declarationList otherwise if OBJ-C class function 
		 *then in Parameter class
		 */
		if(dao!=null && dao.parameters!=null){
			sb.append(dao.getParameterStringCommaSeperated());
		}
		else{
			if(functionType==FunctionType.GLOBAL_METHOD && declarationList!=null){
				sb.append(declarationList.toStringCommaSeperated());
			}
			else{
				int size=parameters.size()-1;
				for(int i=0;i<=size;i++){
					Parameter p=parameters.get(i);
					sb.append(p.toString());
					sb.append((i==size)?"":",");
				}
			}
		}
		
		
		
		sb.append(")");
			
		
		if(compoundStatement!=null && (((CompoundStatement)compoundStatement).getDeclaration()!=null || ((CompoundStatement)compoundStatement).getStatement()!=null) ){
			sb.appendWithNewLine("");
			sb.append(compoundStatement.toString());
		}
		//TODO: URGENT: check if it breaks or works
		else if(compoundStatement == null || (parent!=null) && (parent.getDefinitionType() == IdentifierType.PROTOCOL)){
			sb.appendWithNewLine(";");
		}
		else{
			sb.appendWithNewLine("{\n\t\tthrow new UnsupportedOperationException();\n }");
		}
		
		
		CodeStringBuilder.removeTab();
		return sb.toString();
	}
	
	
	public FunctionDAO getFunctionDAO(){
		String className=(owner==null)? "":owner.getClassName().getName();
		String functionName=getFunctionName();
		return APIMappingTable.getFunctionData(className, functionName);	
	}
	
	
	public String getOwnerName()
	{
		return owner.getClassName().getName();
		
		
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

}
