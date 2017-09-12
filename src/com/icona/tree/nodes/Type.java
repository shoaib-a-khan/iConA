package com.icona.tree.nodes;

import java.util.ArrayList;

public abstract class Type{

	public static abstract class DataType{
		
		public abstract Object clone();
		public abstract String toStringUnformatted();
		
		public static class BasicDataType extends DataType{
			
			public enum NativeType{
				INT,CHAR,VOID,SHORT,LONG,DOUBLE,FLOAT,BOOLEAN,UNICHAR
			}
			
			
			
			private NativeType dataType=null;
			
			public BasicDataType(){
				
			}
			
			public BasicDataType(NativeType type){
				setDataType(type);
			}
			
			public void setDataType(NativeType type){
				dataType=type;
			}
			
			public NativeType getDataType(){
				return dataType;
			}
			
			
			@Override
			public String toString(){
	
				if(dataType==NativeType.BOOLEAN)return "boolean ";
				if(dataType==NativeType.CHAR) 	return "char ";
				if(dataType==NativeType.DOUBLE) return "double ";
				if(dataType==NativeType.FLOAT) return "float ";
				if(dataType==NativeType.INT) 	return "int ";
				if(dataType==NativeType.SHORT)	return "short ";
				if(dataType==NativeType.LONG) 	return "long ";
				if(dataType==NativeType.UNICHAR)return "char ";
				if(dataType==NativeType.VOID)	return "void "; //OTHER: changes void conversion to void instead of object
				
				return null;
			}
			
			@Override
			public Object clone(){
				//TODO BasiDataType: super.clone() has not been called
				return (Object)(new BasicDataType(dataType));
			}

			@Override
			public String toStringUnformatted() {
				if(dataType==NativeType.BOOLEAN)return "boolean";
				if(dataType==NativeType.CHAR) 	return "byte";
				if(dataType==NativeType.DOUBLE) return "double";
				if(dataType==NativeType.FLOAT) return "float";
				if(dataType==NativeType.INT) 	return "int";
				if(dataType==NativeType.SHORT)	return "short";
				if(dataType==NativeType.LONG) 	return "long";
				if(dataType==NativeType.UNICHAR)return "char";
				if(dataType==NativeType.VOID)	return "void"; //OTHER: changes void conversion to void instead of object
				
				return null;
			}
	
			
		}
		
		public static class ClassType extends DataType{
			Identifier className;
	
			public ClassType(Identifier className){
				this.className=className;
				className.setType(IdentifierType.CLASS);
			}
			public Identifier getClassName() {
				return className;
			}
	
			public void setClassName(Identifier className) {
				this.className = className;
			}
			
			public String toString(){
				return (className.getName()=="id")?"Object ":className.toString();
			}
			
			public Object clone(){
				return (Object)(new ClassType(new Identifier(className.getName()) ) );
			}
			@Override
			public String toStringUnformatted() {
				return (className.getName()=="id")?"Object":className.toStringWithNoFormatting();
			}
			
			
		}
	
	
	}
	
	public static class PointerType extends Type{
		private int numPointer=0;
		
		public PointerType(){
			
		}
		
		public void incrementPointer(){
			numPointer+=1;
		}
		
		public void decrementPointer(){
			if(numPointer<=0)
				return;
			numPointer-=1;
		}

		public int getNumPointers() {
			return numPointer;
		}

		public void setNumPointers(int numPointers) {
			this.numPointer = numPointers;
		}
		
		
		
		
		
		
	}

	public static class ArrayType extends Type{
		
		private static final int NO_DIM=-1;
		private static final Expression NO_DIM_EXPR=null;
		
		private ArrayList<Integer> dimensions=new ArrayList<Integer>();
		private ArrayList<Expression> expressions=new ArrayList<Expression>();
		
		private int emptyDimensions=0;
		
		
		public ArrayType(){
			
		}
		
		
		public void addDimension(int dim){
			if(dim<0)
				return ; //TODO Should give exception as dimension can not be negative
			dimensions.add(new Integer(dim));
		}
		
		public void addDimensionExpression(Expression exp){
			if(exp==NO_DIM_EXPR)
				emptyDimensions++;
			expressions.add(exp);
		}
		
		public void addDimension(){

			dimensions.add(new Integer(NO_DIM));
			emptyDimensions++;
		}
		
		public void increaseDimensionBy(int val){
			for(int i=0;i<val;i++)
				addDimension();
		}
		public boolean replacePrevDimension(int dim){
			int len=dimensions.size();
			if(len<=0)
				return false;
			//Actually removing the previous and adding  instead of actually replacing
			dimensions.remove(len-1);
			dimensions.add(new Integer(dim));
			
			return true;
		}
		
		public int numOfDimensions(){
			return dimensions.size();
		}
		
		public int numOfEmptyDimensions(){
			return emptyDimensions;
		}
		
		public int numOfNonEmptyDimensions(){
			return numOfDimensions()-numOfEmptyDimensions();
		}
		
		public String toStringEmptyBraces(){
			//TODO: ARRAY_TYPE toStringEmptyBraces need to implement  for Expression
			StringBuilder sb=new StringBuilder();
			int len=dimensions.size();
			
			for(int i=0;i<len;i++){
				sb.append("[]");
			}
			sb.append(" ");
			
			return sb.toString();
		}
		
		@Override
		public String toString(){
			//TODO: ARRAY_TYPE toString need to implement  for Expression
			
			StringBuilder sb=new StringBuilder();
			int len=dimensions.size();
			
			for(int i=0;i<len;i++){
				int val=dimensions.get(i).intValue();
				sb.append("["+((val==NO_DIM) ? "":val)+"]");//If val is NO_DIM then empty string else value itself e.g [3][2][][] 
			}
			sb.append(" ");
			
			return sb.toString();
		}
		
		@Override
		public Object clone(){
			//TODO ArrayType: super.clone() has not been called
			ArrayType at=new ArrayType();
			at.dimensions=(ArrayList<Integer>)dimensions.clone();
			at.emptyDimensions=emptyDimensions;
			
			return (Object)at;
		}
		
	}
	
	
	
	

}



