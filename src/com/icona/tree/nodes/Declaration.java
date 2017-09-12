package com.icona.tree.nodes;

import com.icona.helper.CodeStringBuilder;
import com.icona.tree.nodes.Type.ArrayType;
import com.icona.tree.nodes.Type.DataType;
import com.icona.tree.nodes.Type.DataType.BasicDataType;
import com.icona.tree.nodes.Type.DataType.ClassType;
import com.icona.tree.nodes.Type.PointerType;
import com.icona.tree.nodes.interfaces.Conversion;

public class Declaration extends Statement implements Conversion{
	
	public enum AccessType{
		PUBLIC("public"),PRIVATE("private"),PACKAGE("package"),PROTECTED("protected");
		
		String conversion;
		private AccessType(String conversion){
			this.conversion=conversion;
		}
		
		public String toString(){
			return this.conversion;
		}
	}
	
	//TODO: Set the variables to null if it is must that they are set otherwise
	public BasicModifier modifier=new BasicModifier(this);//All the basic modifiers
	public Specifier specifier=new Specifier(this);
	public Identifier identifier=new Identifier();
	public DataType dataType=new BasicDataType(); // TODO Hardcoded for now, will be generic type later on
	public ArrayType arrayDimensions=new ArrayType();
	public Expression initializationExpression =null;	
	public AccessType accessType=null;
	public PointerType pointerType=null;
	
	
	
	public Declaration(Node parent, int line_no) {
		super(parent, line_no);
		
		// TODO Auto-generated constructor stub
		
	}
	
	
	public PointerType getPointerType() {
		return pointerType;
	}


	public void setPointerType(PointerType pointerType) {
		this.pointerType = pointerType;
	}


	public AccessType getAccessType() {
		return accessType;
	}




	public void setAccessType(AccessType accessType) {
		this.accessType = accessType;
	}



	//TODO: Refactor the getListExpression to remove it
	public Expression getListExpression() {
		return initializationExpression;
	}



	//TODO: Refactor the setListExpression to remove it
	public void setListExpression(Expression listExpression) {
		this.initializationExpression = listExpression;
	}

	


	public Expression getInitializationExpression() {
		return initializationExpression;
	}




	public void setInitializationExpression(Expression initializationExpression) {
		this.initializationExpression = initializationExpression;
	}




	public BasicModifier getModifier() {
		return modifier;
	}




	public void setModifier(BasicModifier modifier) {
		this.modifier = modifier;
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




	public DataType getDataType() {
		return dataType;
	}




	public void setDataType(DataType type) {
		this.dataType = type;
	}




	public ArrayType getArrayDimensions() {
		return arrayDimensions;
	}




	public void setArrayDimensions(ArrayType arrayDimensions) {
		this.arrayDimensions = arrayDimensions;
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
	
	@Override
	public String toString(){
		transformSelf();
		
		CodeStringBuilder sb=new CodeStringBuilder();
		if(accessType!=null)
			sb.append(accessType.toString()+" ");
		sb.append(modifier.toString());
		sb.append(dataType.toString());
		
		
		//TODO: CHECK out if pointer converion is correct, was done in a hurry
		if(pointerType!=null){
			if(arrayDimensions==null) arrayDimensions=new ArrayType();
			
			if(dataType.getClass() == BasicDataType.class)
				arrayDimensions.increaseDimensionBy(pointerType.getNumPointers());
			else if(dataType.getClass() == ClassType.class)
				arrayDimensions.increaseDimensionBy(pointerType.getNumPointers()-1);
		}
		if(arrayDimensions!=null){
			sb.append(arrayDimensions.toStringEmptyBraces());
		}
		sb.append(identifier.toString());
		
		//TODO This part is hard coded should be generic LHS later on
		if( arrayDimensions!=null && arrayDimensions.numOfNonEmptyDimensions()>0){
			sb.append("= new ");
			sb.append(dataType.toString());
			sb.append(arrayDimensions.toString());
		}
		if(initializationExpression!=null)
		{
			sb.append("= ");
			sb.append(initializationExpression.toStringWithNoFormatting());
			
		}
		
		//sb.append(";");
		//sb.append("\n"); //New line
		
		return sb.toString();
	}


	@Override
	public void addChild(Node node) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Object clone(){
		Declaration d=new Declaration(parent, line_no);
		d.arrayDimensions=(ArrayType)arrayDimensions.clone();
		d.dataType=(DataType)dataType.clone(); //TODO cloning dataType should be generic
		d.identifier=(Identifier)identifier.clone();
		d.modifier=(BasicModifier)modifier.clone();
		d.specifier=(Specifier)specifier.clone();
		
		return (Object)d;
		
	}




	@Override
	public void transformSelf() {
		// NOTE: The order here matters //TODO Declaration: Try to get rid of order
		modifier.setParent(this);//TODO: Check wether its correct or not
		BasicDataType tempDataType=(BasicDataType)modifier.transformDependents();
		if(tempDataType!=null)
			dataType=tempDataType;
		tempDataType=(BasicDataType)specifier.transformDependents();
		if(tempDataType!=null)
			dataType=tempDataType;
		
	}




	@Override
	public Object transformDependents() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}




	@Override
	public boolean hasMultipleExpressions() {
		// TODO Auto-generated method stub
		return false;
	}

}
