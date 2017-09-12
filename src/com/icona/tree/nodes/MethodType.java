package com.icona.tree.nodes;

import com.icona.helper.CodeStringBuilder;
import com.icona.tree.nodes.Type.ArrayType;
import com.icona.tree.nodes.Type.DataType;
import com.icona.tree.nodes.Type.DataType.BasicDataType;
import com.icona.tree.nodes.Type.DataType.ClassType;
import com.icona.tree.nodes.Type.PointerType;

public class MethodType extends Node {
	
	private BasicModifier modifier=null;
	private DataType dataType=null;
	private Specifier specifier=null;
	private PointerType pointerType=null;
	
	private ArrayType arrayType;
	
	
	public PointerType getPointerType() {
		return pointerType;
	}



	public void setPointerType(PointerType pointerType) {
		this.pointerType = pointerType;
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



	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}



	public Specifier getSpecifier() {
		return specifier;
	}



	public void setSpecifier(Specifier specifier) {
		this.specifier = specifier;
	}



	public MethodType(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString(){
		CodeStringBuilder sb=new CodeStringBuilder();
		
		sb.append(modifier.toString()+" ");
		sb.append(dataType.toString());
		if(pointerType!=null){
			if(arrayType==null) arrayType=new ArrayType();
			
			if(dataType.getClass() == BasicDataType.class)
				arrayType.increaseDimensionBy(pointerType.getNumPointers());
			else if(dataType.getClass() == ClassType.class)
				arrayType.increaseDimensionBy(pointerType.getNumPointers()-1);
		}
		if(arrayType!=null)sb.append(arrayType.toStringEmptyBraces());
		
		return sb.toString();
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
