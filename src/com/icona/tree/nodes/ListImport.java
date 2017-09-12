package com.icona.tree.nodes;

import java.util.ArrayList;
import java.util.Iterator;

import com.icona.helper.CodeStringBuilder;

public class ListImport extends Node{


	protected ArrayList<Import> imports;
	
	public ListImport(Node parent, int line_no) {
		super(parent,  line_no);
		imports=new ArrayList<Import>();
		// TODO Auto-generated constructor stub
	}
	public ListImport(Node parent, IdentifierType definitionType, int line_no) {
		super(parent, definitionType, line_no);
		// TODO Auto-generated constructor stub
	}
	
	public double listSize(){
		
		return imports.size();
	}
	public void addImport(Import import_){

		this.imports.add(import_);
	}
	public Iterator getIterator(){
		
		return imports.listIterator();
	}
	
	@Override
	public String toString(){
		
		CodeStringBuilder sb=new CodeStringBuilder();
		Iterator it = imports.listIterator();
		while(it.hasNext()){
			sb.appendWithNewLine(((Import)it.next()).toString());			
		}
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
