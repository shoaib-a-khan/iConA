package com.icona.helper.DAO;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

import com.icona.helper.APIMappingTable;
import com.icona.helper.CodeStringBuilder;
import com.icona.tree.nodes.Identifier;

/**
 * Stores the data related to 'function' table in the database
 * 
 * Stores the parent class, function name, its initialization body, comment, return type, return type
 * function to call and other parameters
 *
 */
public class FunctionDAO {
	
	private static final Integer POSITION_FOR_NO_PARAM=-1;
	public Integer id=null;
	public Integer classId=null;
	public Identifier functionName=null;
	public Integer parentClassId=null;
	public Identifier parentClassName=null;
	public ClassDAO parentClass=null;
	
	public String returnType=null;
	public String returnTypeFunction=null;
	
	public String functionInitBody=null;
	
	public String comment=null;
	
	
	//List of parameters
	public ArrayList<FunctionParamDAO> parameters=null;
	
	public FunctionDAO(Integer id,Integer classId,String functionName,Integer parentClassId,String returnType,String returnTypeFunction,String functionInitBody,String comment){
		this.id=id;
		this.classId=id;
		this.functionName=new Identifier(functionName);
		this.parentClassId=parentClassId;
		this.returnType=returnType;
		this.returnTypeFunction=returnTypeFunction;
		this.functionInitBody=functionInitBody;
		this.comment=comment;
		
		
		this.parentClass=APIMappingTable.getClassData(parentClassId);
		if(this.parentClass!=null)
			parentClassName=this.parentClass.className;
		
		parameters=null;
		
	}
	
	public void addParameter(FunctionParamDAO param){
		if(parameters==null){
			parameters=new ArrayList<FunctionParamDAO>();
		}
		parameters.add(param);
	}
	/**
	 * Creates the parameter string , comma separated
	 * @return Comma separated parameters
	 */
	public String getParameterStringCommaSeperated(){
		if(parameters==null || parameters.size()==0)
			return null;

		
		StringBuilder sb=new StringBuilder();
		int size=parameters.size()-1;
		
		//Checking for position -1 in first index so it will return empty string
		FunctionParamDAO p=parameters.get(0);
		if(p.position==POSITION_FOR_NO_PARAM){
			return "";
		}
		
		//Iterating over the FunctionParamDAO to create a list of parameter separated by comma
		for(int i=0;i<=size;++i){
			FunctionParamDAO param=parameters.get(i);
			sb.append(param.type);
			sb.append(" ");
			sb.append(param.name);
			sb.append((i==size)?"":",");
		}
		
		return sb.toString();
	}
	
	/**
	 * Number of parameters of function in table 'function_parameter_mapping'
	 * @return Total number of parameters, if no parameters then null;
	 */
	public Integer getNumberOfParameters(){
		if(parameters!=null){
			return parameters.size();
		}
		
		return null;
	}
	
	/**
	 * Pretifies the function initialization body of the function, by adding appropriate number of tabs
	 * @return Pretified code
	 */
	public String getFunctionInitBodyUnescaped(){
		if(functionInitBody==null)
			return null;
		
		Pattern pattern = Pattern.compile("\\t+");
	    Matcher matcher = pattern.matcher(StringEscapeUtils.unescapeJava(this.functionInitBody));
	    StringBuilder sb=new StringBuilder(StringEscapeUtils.unescapeJava(this.functionInitBody));
	    
	    while(matcher.find()){
	    	sb.insert(matcher.start(), CodeStringBuilder.getTabString());
	    }
		return StringEscapeUtils.unescapeJava(sb.toString());
	}
	
	
	
}
