package com.icona.tree.nodes;

import java.io.File;
import java.util.Iterator;

import com.icona.helper.CodeStringBuilder;

public class PackageDef extends Node {
	

	String packageName;  //TODO Replace it with identifier
	File file;
	ListClass classes;
	ListProtocol protocols; //list of protocols
	

	public PackageDef(Node parent, int line_no) {
		super( parent, line_no);
		// TODO Auto-generated constructor stub
		classes = new ListClass(this, IdentifierType.CLASS, -1);  //TODO should they be initialized?
		protocols = new ListProtocol(this, IdentifierType.PROTOCOL, -1);
	}
	
	public PackageDef(Node parent, IdentifierType definitionType, int line_no) {
		super( parent, definitionType, line_no);
		classes = new ListClass(this, IdentifierType.CLASS, -1); //TODO should they be initialized?
		protocols = new ListProtocol(this, IdentifierType.PROTOCOL, -1);
		// TODO Auto-generated constructor stub
	}
	
	/*public ArrayList getListClass(){  //TODO undo if something breaks. This function has been replaced by getClassList
		
		return null;// classes.getList();
	}*/
	
	public ListClass getClassList(){
		return classes;
	}
	public void addProtocol(Protocol protocol_){
		protocols.addProtocol(protocol_);	
		
	}
	public void appendClassList(ListClass classList){
		
		Iterator<ClassInterface> itr = classList.getIterator();
		while(itr.hasNext()){
			classes.addClass(itr.next());
		}
	}
	public void addClass(ClassInterface class_){
		this.classes.addClass(class_);
	}
	public ListProtocol getProtocolList() {
		return protocols;
	}

	public void setProtocolList(ListProtocol protocols) {
		this.protocols = protocols;
	}


	public void setFile(File file){
		this.file = file;
	}
	
	public ListClass getClasses() {
		return classes;
	}

	public void setClasses(ListClass classes) {
		this.classes = classes;
	}
	
	public void addPackageName(String packageName){
		if(!packageName.equals(""))
				this.packageName = "com."+ packageName;
		else
			this.packageName="com";
	}
	/*public void setPackageName(){
	
	
	    this.packageName = "com."+file.getPath();//+file.getParentFile().getName(); //TODO this doesn't make folder with in folder name
		this.packageName = this.packageName.replaceAll( "\\W", "."); //TODO modify regex in case of issues
	}*/
	
	public String getPackageName(){
		return this.packageName;
	}
	
	@Override
	public String toString(){
		CodeStringBuilder sb= new CodeStringBuilder();
		sb.append("package "+ packageName  + "\n\n" );
		if(classes != null)
			sb.append(classes.toString());
		if(protocols != null)
			sb.append(protocols.toString());
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
