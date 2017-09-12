package com.icona.helper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.icona.helper.DAO.ClassDAO;
import com.icona.helper.DAO.FunctionDAO;

public class APIMappingTable {
	
	//Hashmap to store the details of Class and Functions extracted from the Databse
	static private HashMap<String,ClassDAO> classData=new HashMap<String, ClassDAO>();
	static private MultiKeyMap<FunctionDAO> functionData=new MultiKeyMap<FunctionDAO>();
	
	//Hashmap indexed on id and references data from classData and functionData
	static private HashMap<Integer,ClassDAO> classDataIDIndexed=new HashMap<Integer, ClassDAO>();
	static private HashMap<Integer,FunctionDAO> functionDataIDIndexed=new HashMap<Integer, FunctionDAO>();
	
	//HashMaps to store the mapping details provided in the database, the values are references from the objects in classData and FunctionData
	static private HashMap<String, ClassDAO> classMapping=new HashMap<String, ClassDAO>();
	static private MultiKeyMap<FunctionDAO> functionMapping=new MultiKeyMap<FunctionDAO>();
	
	
	//Private constructor so that no instance of it can be created
	private APIMappingTable(){};
	
	static public boolean populateFromDatabase(){
		DBDataPopulator populator=new DBDataPopulator();
		return populator.populateAllDB();
	}
	static public ClassDAO getClassData(String name){
		return classData.get(name);
	}
	static public ClassDAO getClassData(Integer id){
		return classDataIDIndexed.get(id);
	}
	
	static public FunctionDAO getFunctionData(String className,String functionName){
		return functionData.get(className, functionName);
	}
	
	static public FunctionDAO getFunctionData(Integer id){
		return functionDataIDIndexed.get(id);
	}
	
	static public ClassDAO getClassMapping(String key){
		return classMapping.get(key);
	}
	
	static public FunctionDAO getFunctionMapping(String className,String functionName){
		return functionMapping.get(className, functionName);
	}
	
	/*
	 * Takes the FunctionDAO as parameter
	 * by default the key1 is "" and if the Function in FunctionDAO
	 * is associated to some class then that class name is key1
	 * so total key is CLASS FUNCTION , where the function FUNCTION 
	 * belongs to class CLASS, in case of "" it means the FUNCTION is 
	 * global
	 */
	static public FunctionDAO addFunctionData(FunctionDAO dao){
		
		//dao.parameters=new DBDataPopulator().getFunctionParameters(dao);
		
		Object key1=dao.functionName.getName();
		Object key2="";
		
		//TODO: Check why was the below condition dao.parentClass==null
		if(dao.parentClass != null){
			key2=dao.parentClassName.getName();
			
			//dao.parentClass=getClassData((String)key2);
		}
		functionDataIDIndexed.put(dao.id, dao);
		return functionData.put(key2, key1, dao);
	}
	
	static public ClassDAO addClassData(ClassDAO dao){
		classDataIDIndexed.put(dao.id, dao);
		return classData.put(dao.className.getName(), dao);
	}
	
	static public ClassDAO addClassMapping(String fromClassName,String toClassName){
		return classMapping.put(fromClassName, classData.get(toClassName));
	}
	
	static public ClassDAO addClassMapping(Integer fromClassId,Integer toClassId){
		String fromClassName=classDataIDIndexed.get(fromClassId).className.getName();
		return classMapping.put(fromClassName, classDataIDIndexed.get(toClassId));
	}
	
	/*
	 * Takes mapping of function from , to the functions it maps
	 * So if the function owner is no one i.e it doesnt belong to any class
	 * then it means its a global function and its key1 will be ""
	 */
	static public FunctionDAO addFunctionMapping(Integer fromFunctionId,Integer toFunctionId){
		FunctionDAO fromFunctionDAO=functionDataIDIndexed.get(fromFunctionId);
		String key1="";
		if(fromFunctionDAO.parentClassName!=null)
			key1=fromFunctionDAO.parentClassName.getName();
		String key2=fromFunctionDAO.functionName.getName();
		
		return functionMapping.put(key1, key2, functionDataIDIndexed.get(toFunctionId));
	}
	
	
	/*
	 * Resolves all the entries in the classData hashtable so that
	 * each classDAO in hashTable refers to its superclass ClassDAO 
	 * if present in the classData
	 */
	static public void resolveSuperclassLinks(){
		Iterator it=classData.entrySet().iterator();
		
		while(it.hasNext() ){
			Map.Entry pair=(Map.Entry)it.next();
			ClassDAO dao=(ClassDAO)pair.getValue();
			if(dao.superClassDAO==null)
				dao.superClassDAO=(ClassDAO)APIMappingTable.getClassData(dao.superClassId);
		}
	}
	
	
	

}
