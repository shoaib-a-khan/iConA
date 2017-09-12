package com.icona.helper.DAO;

import com.icona.helper.APIMappingTable;
/**
 * The data access object for the function parameters
 *
 */
public class FunctionParamDAO {
	public Integer functionId=null;
	public String type=null;
	public String name=null;
	public Integer position=null;
	
	public FunctionDAO functionDAO=null;
	
	public FunctionParamDAO(Integer functionId,String type,String name,Integer position){
		this.functionId=functionId;
		this.type=type;
		this.name=name;
		this.position=position;
		
		this.functionDAO=APIMappingTable.getFunctionData(functionId);
		
	}
}
