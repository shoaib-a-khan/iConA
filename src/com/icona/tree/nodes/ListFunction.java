package com.icona.tree.nodes;

import java.util.ArrayList;
import java.util.Iterator;

import com.icona.helper.CodeStringBuilder;

public class ListFunction extends Node {

	private ArrayList<Function> functions;
	
	
	public ListFunction(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
		functions=new ArrayList<Function>();
	}

	public Iterator getIterator(){
		
		return functions.listIterator();
		
	}
	
	public boolean checkExistence(Function ft){
		
		return functions.contains(ft);

	}

	public void addFunction(Function func){
		this.functions.add(func);
	}
	
	public void replaceFunction(Function prevFunction, Function newFunction){
		
		this.functions.set(functions.indexOf(prevFunction), newFunction);

	}
	public void setAllFunctionsOwner(ClassInterface owner){
		for(int i=0;i<functions.size();i++){
			functions.get(i).setOwner(owner); //TODO: Check if function owner is set correctly or not
		}
	}
	//TODO remove the above afterwards
	public void setAllFunctionsParent(Node parent){ //used with protocol
		for(int i=0;i<functions.size();i++){
			functions.get(i).setParent(parent); //TODO: Check if function owner is set correctly or not
		}
	}
	@Override
	public String toString(){
		CodeStringBuilder sb=new CodeStringBuilder();
		
		for(int i=0;i<functions.size();i++){
			sb.appendWithNewLine(functions.get(i).toString());
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
