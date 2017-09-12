package com.icona.helper;

import java.util.HashMap;

import com.icona.tree.nodes.Declaration;
import com.icona.tree.nodes.Identifier;
import com.icona.tree.nodes.Statement.ListDeclaration;

public class VariableScopeTable {
	private HashMap<String, Declaration> variableHash=new HashMap<String, Declaration>();
	
	public Declaration put(Declaration d){
		Identifier id=d.getIdentifier();
		
		variableHash.put(id.getName(), d);
		return d;
	}
	public void put(ListDeclaration ld){
		
		for(int i=0;i<ld.size();++i){
			Declaration d=ld.get(i);
			Identifier id=d.getIdentifier();
			
			variableHash.put(id.getName(), d);
		}
		
		
	}
	
	public Declaration put(Identifier id,Declaration d){
		variableHash.put(id.getName(), d);
		return d;
	}
	
	public Declaration get(Identifier id){
		Declaration d=variableHash.get(id.getName());
		return d;
	}
	
	public Declaration get(String key){
		Declaration d=variableHash.get(key);
		
		return d;
	}
	
	public boolean containsVariable(String key){
		return variableHash.containsKey(key);
	}
	
	public boolean containsVariable(Identifier id){
		return variableHash.containsKey(id.getName());
	}
	

}
