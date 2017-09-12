package com.icona.helper.DAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

import com.icona.helper.APIMappingTable;
import com.icona.helper.CodeStringBuilder;
import com.icona.tree.nodes.Identifier;

/**
 * The data access object for class
 *
 */
public class ClassDAO {
	public Integer id=null;
	public Identifier className=null;
	public String classInitBody=null;
	public String classEndBody=null;
	public Language language=null;
	public String importName=null;
	
	public Integer superClassId=null;
	public ClassDAO superClassDAO=null;
	
	public ClassDAO(Integer id,String className,Integer superClassId,String classInitBody,String classEndBody,Language language,String importName){
		this.id=id;
		this.className=new Identifier(className);
		this.superClassId=superClassId;
		this.classInitBody=classInitBody;
		this.classEndBody=classEndBody;
		this.language=language;
		this.importName=importName;
		
		this.superClassDAO=APIMappingTable.getClassData(superClassId);	
	}
	
	public String getClassName()
	{
		return this.className.toString();
		
		
	}
	public int getClassId()
	{
		return this.id;
		
	}
	public ClassDAO getSuperClass(){
		return APIMappingTable.getClassData(this.superClassId);
	}
	
	public String getClassInitBodyUnescaped(){
		if(classInitBody==null)
			return null;
		
		Pattern pattern = Pattern.compile("\\t+");
	    Matcher matcher = pattern.matcher(StringEscapeUtils.unescapeJava(this.classInitBody));
	    StringBuilder sb=new StringBuilder(StringEscapeUtils.unescapeJava(this.classInitBody));
	    
	    while(matcher.find()){
	    	sb.insert(matcher.start(), CodeStringBuilder.getTabString());
	    }
	    
	    String tempString=sb.toString();
	    
	    pattern=Pattern.compile("\\n+");
	    matcher=pattern.matcher(tempString);
	    
	    while(matcher.find()){
	    	sb.insert(matcher.end(), CodeStringBuilder.getTabString());
	    }
		return sb.toString();
	}
	
	public String getClassEndBodyUnescaped(){
		if(classEndBody==null)
			return null;
		
		Pattern pattern = Pattern.compile("\\t+");
	    Matcher matcher = pattern.matcher(StringEscapeUtils.unescapeJava(this.classEndBody));
	    StringBuilder sb=new StringBuilder(StringEscapeUtils.unescapeJava(this.classEndBody));
	    
	    while(matcher.find()){
	    	sb.insert(matcher.start(), CodeStringBuilder.getTabString());
	    }
		return sb.toString();
	}
	
	
	
	
	
}
