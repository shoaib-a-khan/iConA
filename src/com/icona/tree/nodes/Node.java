package com.icona.tree.nodes;

public abstract class Node {
	Node parent;
	
	String defType;  //definition type: class, package, methods, variables
	
	IdentifierType definitionType; //notype=0, Package=1, Class=2, Function=3, Declaration=4, Protocol=5
	
	int line_no=-1;
	
	public IdentifierType getDefinitionType() {
		return definitionType;
	}

	public void setDefinitionType(IdentifierType definitionType) {
		this.definitionType = definitionType;
	}

	public Node(Node parent,int line_no){
		this.parent=parent;
		this.line_no=line_no;
	}
	
	public Node(Node parent,IdentifierType definitionType, int line_no){
		this.parent=parent;
		this.line_no=line_no;
		this.definitionType = definitionType;
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public abstract void addChild(Node node);
	
	
	public abstract Node getNextChild(Node existing);
	public abstract Node getPreviousChild(Node existing);
	public abstract boolean replaceChild(Node existing,Node by);
	
	public abstract Node getNextSibling();
	public abstract Node getPreviousSibling();
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("");
		return sb.toString();
	}
	
}
