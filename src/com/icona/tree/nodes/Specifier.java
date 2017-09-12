package com.icona.tree.nodes;

import com.icona.tree.nodes.Type.DataType.BasicDataType;
import com.icona.tree.nodes.Type.DataType.BasicDataType.NativeType;
import com.icona.tree.nodes.interfaces.Conversion;

public class Specifier implements Conversion{

	public enum NativeSpecifier{
		SHORT(SpecifierType.SIZE_SPECIFIER),LONG(SpecifierType.SIZE_SPECIFIER)
		,SIGNED(SpecifierType.SIGN_SPECIFIER),UNSIGNED(SpecifierType.SIGN_SPECIFIER);
		
		SpecifierType type=null;
		private NativeSpecifier(SpecifierType t){
			type=t;
		}
		
		public SpecifierType getType(){
			return type;
		}
		
		public boolean isSameType(SpecifierType t){
			return (type == t);
		}
	}
	
	private enum SpecifierType{
		SIZE_SPECIFIER,SIGN_SPECIFIER
	}
	
	private NativeSpecifier specifierSize=null;
	private NativeSpecifier specifierSign=null;
	private Statement parent=null; //TODO: Check if the parent should be Statement or something else
	
	boolean isDoubleLong=false;
	
	
	public Specifier(Statement parent){
		this.parent=parent;
	}
	public Specifier(Statement parent,NativeSpecifier specifier){
		this.parent=parent;
		setSpecifier(specifier);
		
	}

	public void setSpecifier(NativeSpecifier specifier){
		if(specifier==null)
			throw new NullPointerException("NULL Specifier given");
		
		if(specifier.getType() == SpecifierType.SIGN_SPECIFIER)
			specifierSign=specifier;
		else{
			//If long came more than one time then set idDoubleLong true -> as long long =double
			if(specifier==NativeSpecifier.LONG && !isDoubleLong && specifierSize==NativeSpecifier.LONG)
				isDoubleLong=true;
			
			specifierSize=specifier;
		}
	}
	
	public void setParent(Statement parent) {
		this.parent = parent;
	}
	public void removeAllSpecifier(){
		specifierSign=null;
		specifierSize=null;
		
	}
	public void removeSizeSpecifier(){
		specifierSize=null;
	}
	public void removeSignSpecifier(){
		specifierSign=null;
	}

	@Override
	public void transformSelf() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Object transformDependents() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		if(specifierSize==null)
			return null;
		if(parent.getClass() == Declaration.class){
			BasicDataType p=(BasicDataType)((Declaration)parent).dataType;//TODO Specifier: transformDependents should be genreic
			if(isDoubleLong)
				p.setDataType(NativeType.LONG);
			else if(specifierSize==NativeSpecifier.SHORT)
				p.setDataType(NativeType.SHORT);
			else if(specifierSize==NativeSpecifier.LONG && p.getDataType()!=NativeType.DOUBLE)
				p.setDataType(NativeType.INT);
			
			return (Object)p;
		}
		return null;
	}
	
	@Override
	public Object clone(){
		Specifier s=new Specifier(parent);
		s.isDoubleLong=isDoubleLong;
		s.specifierSign=specifierSign;
		s.specifierSize=specifierSize;
		
		return (Object)s;
	}
	
	@Override
	public String toString(){
		throw new UnsupportedOperationException();
		
	}
}