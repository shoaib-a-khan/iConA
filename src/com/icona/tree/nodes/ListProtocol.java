package com.icona.tree.nodes;

import java.util.ArrayList;
import java.util.Iterator;

import com.icona.helper.CodeStringBuilder;

public class ListProtocol extends Node {

	protected ArrayList<Protocol> protocols;
	
	public ListProtocol(Node parent, IdentifierType definitionType, int line_no) {
		super(parent, definitionType, line_no);
		protocols=new ArrayList<Protocol>();
		// TODO Auto-generated constructor stub
	}

	public ListProtocol(Node parent, int line_no) {
		super(parent, line_no);
		protocols=new ArrayList<Protocol>();
		// TODO Auto-generated constructor stub
	}
	
	public void assignImports(ListImport imports_){
		Iterator iterator = protocols.listIterator();
		while(iterator.hasNext()){
		    	Protocol protocol_ = (Protocol) iterator.next();
		    	protocol_.setImports(imports_);
		    }
}
	
	public Iterator getIterator(){
		
		return protocols.listIterator();
	}
	public void addProtocol(Protocol protocol_){
		
		//System.out.println("ST=> Added protocol: "+protocol_.getProtocolName().getName());
		this.protocols.add(protocol_);
	}
	
	public void setAllProtocolOwner(PackageDef owner){
		for(int i=0;i<protocols.size();i++){
			protocols.get(i).setParent(owner); //TODO: Check if function owner is set correctly or not
		}
	}
	
	@Override
	public String toString(){
		CodeStringBuilder sb=new CodeStringBuilder();
		
		for(int i=0;i<protocols.size();i++){
			sb.appendWithTabNewLine(protocols.get(i).toString());
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
