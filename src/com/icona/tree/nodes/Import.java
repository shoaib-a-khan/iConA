package com.icona.tree.nodes;

import com.icona.helper.CodeStringBuilder;

public class Import extends Node{

	private Identifier importName;
	
	public Import(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
	}
	
	public Import(Node parent, IdentifierType definitionType, int line_no) {
		super(parent, definitionType, line_no);
	}

	@Override
	public String toString(){
		CodeStringBuilder sb=new CodeStringBuilder();
		sb.append("import " + importName.toString() + ";");
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
	public Identifier getImportName() {
		return importName;
	}
	public void setImportName(Identifier importName) {
		this.importName = importName;
	}

}
