package com.icona.tree.nodes;

import java.lang.reflect.Modifier;

import com.icona.tree.nodes.Type.DataType.BasicDataType;
import com.icona.tree.nodes.Type.DataType.BasicDataType.NativeType;
import com.icona.tree.nodes.interfaces.Conversion;

public class BasicModifier extends Modifier implements Conversion{
	
	Statement parent=null; //TODO: Should see if parent can be any other thing, not only statement
	private int mod=0;
	
	public static final int CONST=16;
	public static final int AUTO=0;
	public static final int REGISTER=0;
	public static final int EXTERN=0;
	
	
	public BasicModifier(Statement parent) {
		super();
		this.parent=parent;
			
	}
	
	public void setParent(Statement parent){
		this.parent=parent;
	}
	
	//Constructor for one modifier
	public BasicModifier(Declaration parent,int modifier){
		super();
		this.parent=parent;
		setModifier(modifier);
		
	}
	
	//Constructor for multiple number of modifiers
	public BasicModifier(Declaration parent,int ... modifiers){
		super();
		for(int i=0;i<modifiers.length;i++)
			setModifier(modifiers[i]);
	}
	
	public void setModifier(int modifier){
		mod = mod | modifier;
	}
	
	public void removeModifier(int modifier){
		mod = mod & (~modifier);
	}
	
	public boolean isConst(){
		return isFinal(mod);
	}
	
	 public boolean isPublic()
	 {
	     return super.isPublic(mod);
	 }
	 public boolean isPrivate()
	 {
		 return super.isPrivate(mod);
	 }
	 public boolean isProtected()
	 {
	      return super.isProtected(mod);
	 }
	  
	 public boolean isStatic()
	 {
	      return super.isStatic(mod);
	 }
	  
	 public boolean isFinal(){
		 return super.isFinal(mod);
	 }
	 
	 public boolean isSynchronized(){
		 return super.isSynchronized(mod);
	 }
	 
	 public boolean isVolatile(){
		 return super.isVolatile(mod);
	 }
	 
	 public boolean isTransient(){
		 return super.isTransient(mod);
	 }
	 
	 public boolean isNative(){
		 return super.isNative(mod);
	 }
	 
	 public boolean isInterface(){
		 return super.isInterface(mod);
	 }
	 
	 public boolean isAbstract(){
		 return super.isAbstract(mod);
	 }
	 
	 public boolean isStrict(){
		 return super.isStatic(mod);
	 }
	 
	@Override
	public String toString(){
		String s=super.toString(mod);
		s=(s.equals(""))? "" : s+" ";
		return s;//Just for indentation
	}

	@Override
	public Object clone() {
		// TODO Super class clone has not been called BasicModifier
		
		
		BasicModifier bm=new BasicModifier(parent);
		
		bm.mod=this.mod;
		
		return (Object)bm;
	}

	@Override
	public void transformSelf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object transformDependents() {
		// TODO: Checks at runtime if the class of parent is declaration or not
		if(parent.getClass()==Declaration.class && ((Declaration)parent).dataType.getClass() == BasicDataType.class ){
			BasicDataType p=(BasicDataType)((Declaration)parent).dataType; //TODO BasicModifier: Should be generic //TODO: Should be Type | DataType not hardcoded to BasicDataType
			if(isFinal() && p.getDataType()==null)
				p.setDataType(NativeType.INT);
			else
				return null;
			
			return p;
		}
		else{
			return null;
		}
	}
	
	
	
}
