package com.icona.tree.nodes;

import java.util.Iterator;

import com.icona.helper.CodeStringBuilder;

public class Protocol extends Node {

	
	 Identifier protocolName = null;
	
	 ListProtocol listProtocol = null; //protocol reference list
	
	 ListFunction functions=null;
	 
	 ListImport imports = null;
	 
	 ClassInterface superClass = null;
	 public void setImports(ListImport imports_) {
			this.imports = imports_;
	 }
	 public void setSuperClass(ClassInterface superClass){
		 this.superClass = superClass;
	 }
	 public ListImport getImportList(){
		
			return this.imports;
	 }
	 public void addFunction(Function function_){
		 functions.addFunction(function_);
	 }
	 public void addReferenceProtocol(Protocol protocol_){
		 listProtocol.addProtocol(protocol_);
	 }

	public ListFunction getFunctions() {
		return functions;
	}

	public void setFunctions(ListFunction functions) {
		this.functions = functions;
	}

	public Protocol(Node parent, IdentifierType definitionType, int line_no) {
		super(parent, definitionType, line_no);
		functions = new ListFunction(this, -1);  //TODO is this a hack or it should really be initialized here rather then in grammer?
		listProtocol = new ListProtocol(this, -1);
		// TODO Auto-generated constructor stub
	}
	
	public Identifier getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(Identifier protocolName) {
		this.protocolName = protocolName;
	}

	public ListProtocol getProtocolList() {
		return this.listProtocol;
	}

	public void setProtocolList(ListProtocol protocolList) {
		this.listProtocol = protocolList;
	}

	public Protocol(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		
		CodeStringBuilder sb= new CodeStringBuilder();
		sb.appendWithNewLine("package "+((PackageDef)this.parent).getPackageName());
		
		//TODO: Add imports
		//if(imports!=null)
		//	sb.appendWithNewLine(imports.toString());
		sb.appendWithTab("public interface ");
		sb.append(protocolName.toString());
		if(superClass!=null){
			sb.appendWithTab("extends "+superClass.getClassName().getName());
		}
		if(listProtocol!=null){
			sb.appendWithTab(" implements ");
			Iterator<Protocol> itr = listProtocol.protocols.iterator();
			while(itr.hasNext()){
				sb.append(itr.next().protocolName.toString() + (itr.hasNext()?" ,": " "));
			}
		}
		sb.appendWithNewLine("{");
		
		CodeStringBuilder.addTab();
		if(functions != null)
		sb.append(functions.toString());
		
		CodeStringBuilder.removeTab();
		
		sb.appendWithTab("}");
		
		
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
