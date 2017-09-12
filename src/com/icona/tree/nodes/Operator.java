package com.icona.tree.nodes;

public abstract class Operator {
	private Expression parent=null;
	
	public abstract boolean isNull();
	
	
	
	public static class UnaryOperator extends Operator{
		private UnarySymbol symbol=null;
		
		
		/**
		 * Enumeration for all Unary symbols such as ++,--,- etc
		 * 
		 *
		 */
		public enum UnarySymbol {
			POST_INC("++"),POST_DEC("--"),PRE_INC("++"),PRE_DEC("--"),DEREFERENCE("*"),SIGN_MINUS("-"),LOGICAL_NOT("!"),REFERENCE("&"),BITWISE_NOT("~")
			;
			String operator_str="";
			private UnarySymbol(String str){
				operator_str=str;
			}
			
			public String toString(){
				return operator_str;
			}
		}
		
		
		public UnaryOperator(UnarySymbol symbol){
			this.symbol=symbol;
		}
		
		
		public UnarySymbol getSymbol() {
			return symbol;
		}


		public void setSymbol(UnarySymbol symbol) {
			this.symbol = symbol;
		}
		
		/**
		 * Checks if symbol is NULL or NOT
		 * 
		 * @return returns whether symbol is null or not
		 */
		public boolean isNull(){
			return symbol==null;
		}
		
		public String toString(){
			return symbol.toString();
		}
	}
	
	public static class AssignmentOperator extends Operator{
		private AssignmentSymbol symbol=null;
		public enum AssignmentSymbol{
			EQUAL("="),MUL_EQUAL("*="),DIV_EQUAL("/="),MOD_EQUAL("%="),ADD_EQUAL("+="),
			SUB_EQUAL("-="),SHL_EQUAL("<<="),SHR_EQUAL(">>="),BITWISE_AND_EQUAL("&="),
			BITWISE_XOR_EQUAL("^="),BITWISE_OR_EQUAL("|=")
			;
			String operator_str="";
			private AssignmentSymbol(String str){
				operator_str=str;
			}
			
			public String toString(){
				return operator_str;
			}
		}
		
		public AssignmentOperator(AssignmentSymbol symbol){
			this.symbol=symbol;
		}
		
		public AssignmentSymbol getSymbol(){
			return symbol;
		}
		public void setSymbol(AssignmentSymbol sym){
			symbol=sym;
		}
		
		public boolean isNull(){
			return symbol==null;
		}
		
		public String toString(){
			return  symbol.toString();
		}
	}
	
	
	public static class BinaryOperator extends Operator{
		
		private BinarySymbol symbol;
		
		
		public BinaryOperator(BinarySymbol sym){
			symbol=sym;
		}
		
		public BinarySymbol getSymbol(){
			return symbol;
		}
		public void setSymbol(BinarySymbol sym){
			symbol=sym;
		}
		public boolean isNull(){
			return symbol==null;
		}
		public String toString(){
			return symbol.toString();
		}
		
		public boolean isBoolean(){
			return symbol.isBoolean();
		}
		
		public interface BinarySymbol{
			public String toString();
			public boolean isBoolean();
		}
		public enum LogicalOperator implements BinarySymbol{
			OR("||"),AND("&&"),
			;
			String operator_str="";
			private LogicalOperator(String str){
				operator_str=str;
			}
			
			public String toString(){
				return operator_str;
			}

			@Override
			public boolean isBoolean() {
				// TODO Auto-generated method stub
				return true;
			}
		}
		
	
		public enum BitwiseOperator implements BinarySymbol{
			OR("|"),AND("&"),XOR("^")
			;
			String operator_str="";
			private BitwiseOperator(String str){
				operator_str=str;
			}
			
			public String toString(){
				return operator_str;
			}

			@Override
			public boolean isBoolean() {
				// TODO Auto-generated method stub
				return false;
			}
		}

		public enum ArithOperator implements BinarySymbol{
			ADD("+"),SUB("-"),MUL("*"),DIV("/"),MOD("%")
			;
			String operator_str="";
			private ArithOperator(String str){
				operator_str=str;
			}
			
			public String toString(){
				return operator_str;
			}

			@Override
			public boolean isBoolean() {
				// TODO Auto-generated method stub
				return false;
			}
		}
		
		public enum RelationalOperator implements BinarySymbol{
			LESS("<"),GREATER(">"),LESS_EQUAL("<="),GREATER_EQUAL(">="),EQUAL("=="),NOT_EQUAL("!=")
			;
			String operator_str="";
			private RelationalOperator(String str){
				operator_str=str;
			}
			
			public String toString(){
				return operator_str;
			}

			@Override
			public boolean isBoolean() {
				// TODO Auto-generated method stub
				return true;
			}
		}
		
		public enum ShiftOperator implements BinarySymbol{
			SHL("<<"),SHR(">>")
			;
			String operator_str="";
			private ShiftOperator(String str){
				operator_str=str;
			}
			
			public String toString(){
				return operator_str;
			}

			@Override
			public boolean isBoolean() {
				// TODO Auto-generated method stub
				return false;
			}
		}
		
	}
	
	public enum TertiaryOperator{
		TERTIARY_CONDITION("?"),TERTIARY_ELSE(":");
		String operator_str="";
		private TertiaryOperator(String str){
			operator_str=str;
		}
		
		public String toString(){
			return operator_str;
		}
	}
}
