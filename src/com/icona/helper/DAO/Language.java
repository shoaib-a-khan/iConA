package com.icona.helper.DAO;

/**
 * Enumeration of type of language
 *
 */
public enum Language {
	JAVA("java"),OBJC("objc");
	
	String str="";
	
	private Language(String str){
		this.str=str;
	}
	/**
	 * Gives back the appropriate ENUM
	 * @param language The language whose ENUM to get
	 * @return The appropriate ENUM for the language
	 */
	public static Language getLanguageEnum(String language){
		if(language.equals("java")) return JAVA;
		return OBJC;
	}
	
	public String toString(){
		return str;
	}
}
