package com.icona.tree.nodes;

public class GenericRef {
	String str="";
	RefType type=null;
	
	public enum RefType{
		IDENTIFIER,STRING,CONSTANT
	}
	
	public GenericRef(String str,RefType type){
		this.str=str;
		this.type=type;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public RefType getType() {
		return type;
	}

	public void setType(RefType type) {
		this.type = type;
	}
	
	public String toString(){
		
		if(str.equals("YES") ){
			return "true";
		}
		else if(str.equals("NO") ){
			return "false";
		}
		else if(str.equals("nil") ){
			return "null";
		}
		
		if(type==RefType.STRING){
			return str.replace("%@", "%s");
		}
		return str;//TODO if in String case quotes are needed
	}
	
	
}
