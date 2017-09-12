package com.icona.tree.nodes;

import com.icona.helper.APIMappingTable;
import com.icona.helper.DAO.ClassDAO;



public class Identifier {

	private IdentifierType type=IdentifierType.NO_TYPE;
	private String name="";
	
	public Identifier(){
		
	}
	public Identifier(String name){
		
		this.name=name;
		//Type is by default set to NO_TYPE
	}
	public Identifier(String name,IdentifierType type) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.type=type;
		
	}
	
	public void setType(IdentifierType type){
		this.type=type;
	}
	
	public void removeType(IdentifierType type){
		this.type=IdentifierType.NO_TYPE;
	}
	
	public IdentifierType getType(){
		return type;
	}

	
	public void resetType(){
		type=IdentifierType.NO_TYPE;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFunction(){
		return type==IdentifierType.FUNCTION;
	}
	
	public boolean isClass(){
		return type==IdentifierType.CLASS;
	}
	
	public boolean isDeclaration(){
		return type==IdentifierType.DECLARATION; 
	}

	private String getJavaName(){
		if(type==IdentifierType.CLASS || type==IdentifierType.DECLARATION){
			ClassDAO mappedTo=APIMappingTable.getClassMapping(name);
			if(mappedTo!=null)
				return mappedTo.className.getName();
		}

		
		return name;
	}
	
	@Override
	public String toString(){
		return getJavaName()+" ";
	}
	
	public String toStringWithNoFormatting(){
		//TODO implement toString of Identifier
		return getJavaName();
	}
	
	public String unIndentatedString(){
		return name;
	}
	
	@Override
	public Object clone(){
		Identifier id=new Identifier(name);
		id.type=type;
		
		return (Object)id;
	}
	
	
	

}