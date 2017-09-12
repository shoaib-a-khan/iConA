package com.icona.helper;

/* class to store the values retrieved from mapping database as an entry object for later use in hashmap etc */

public class DbEntry {

	String CValue;        //should be type Node or something
	String JavaValue;
	String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	int Id;
	
	public DbEntry( int Id, String Cvalue, String JavaValue, String type){
		
		this.CValue = Cvalue;
		this.JavaValue = JavaValue;
		this.Id = Id;
		
	}

	public String getCValue() {
		return CValue;
	}

	public void setCValue(String cValue) {
		CValue = cValue;
	}

	public String getJavaValue() {
		return JavaValue;
	}

	public void setJavaValue(String javaValue) {
		JavaValue = javaValue;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	
}
