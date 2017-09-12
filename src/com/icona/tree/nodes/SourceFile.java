package com.icona.tree.nodes;

import java.util.ArrayList;

public class SourceFile extends Node {
	
	
 
	private ArrayList<Node> nodes=new ArrayList<Node>();
	
	public SourceFile(Node parent, int line_no) {
		super(parent, line_no);
	}
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<nodes.size();i++){
			if(nodes.get(i)!=null)
			sb.append("\t"+nodes.get(i).toString()+"\n");//TODO the indentation is hard coded
		}
		return sb.toString();
		
	}
	@Override
	public void addChild(Node node) {
		nodes.add((Node)node);
		
	}
	
	@Override
	public Node getNextChild(Node existing) {
		int index=nodes.indexOf(existing);
		
		return (index<0) ? null : nodes.get(index+1);
	}
	
	
	

	@Override
	public Node getPreviousChild(Node existing) {
		int index=nodes.indexOf(existing);
		
		return (index<0) ? null : nodes.get(index-1);
	}

	@Override
	public boolean replaceChild(Node existing, Node by) {
		
		int index=nodes.indexOf(existing);
		if(index<0)
			return false;
		nodes.remove(index);
		nodes.add(index,by);
		
		return true;
	}

	@Override
	public Node getNextSibling() {
		return parent.getNextChild(this);
	}

	@Override
	public Node getPreviousSibling() {
		return parent.getPreviousChild(this);
	}
	

}
