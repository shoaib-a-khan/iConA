package com.icona.tree.nodes;

import java.util.ArrayList;
import java.util.Iterator;

import com.icona.helper.CodeStringBuilder;

public class ListClass extends Node {

private ArrayList<ClassInterface> classes;
	
	
	public ListClass(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
		classes=new ArrayList<ClassInterface>();
	}
	
	public ListClass(Node parent,IdentifierType definitionType, int line_no) {
		super(parent, definitionType, line_no);
		// TODO Auto-generated constructor stub
		classes=new ArrayList<ClassInterface>();
	}

	public ArrayList getList(){
		return this.classes;
	}
	public void assignImports(ListImport imports_){
		System.out.println("import assigned:"+imports_.toString());
			Iterator iterator = classes.listIterator();
			while(iterator.hasNext()){
			    	ClassInterface class_ = (ClassInterface) iterator.next();
			    	class_.setImports(imports_);
			 
			    }
	}
	public void addClass(ClassInterface class_){
		//System.out.println("added class:"+class_.getClassName().getName());
		this.classes.add(class_);
	}
	
	public void setAllClassOwner(PackageDef owner){
		for(int i=0;i<classes.size();i++){
			classes.get(i).setParent(owner); //TODO: Check if function owner is set correctly or not
		}
	}
	
	public Iterator getIterator(){
		
		return classes.iterator();
	}
	
	@Override
	public String toString(){
		CodeStringBuilder sb=new CodeStringBuilder();
		Iterator it = classes.listIterator();
		while(it.hasNext()){
			sb.appendWithTabNewLine(it.next().toString());			
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
