package com.icona.tree.nodes;



import java.util.ArrayList;

import com.icona.helper.APIMappingTable;
import com.icona.helper.CodeStringBuilder;
import com.icona.helper.DAO.FunctionDAO;
import com.icona.tree.nodes.Expression.PostfixExpression.PostfixExpressionCollector.PostfixExpressionType;
import com.icona.tree.nodes.GenericRef.RefType;
import com.icona.tree.nodes.Operator.AssignmentOperator;
import com.icona.tree.nodes.Operator.AssignmentOperator.AssignmentSymbol;
import com.icona.tree.nodes.Operator.BinaryOperator;
import com.icona.tree.nodes.Operator.BinaryOperator.BinarySymbol;
import com.icona.tree.nodes.Operator.TertiaryOperator;
import com.icona.tree.nodes.Operator.UnaryOperator;
import com.icona.tree.nodes.Operator.UnaryOperator.UnarySymbol;

public abstract class Expression extends Statement {
	
	public Expression(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
		
	}
	
	public abstract boolean isNonBoolean();
	
	public abstract String toStringWithNoFormatting();
	
	@Override
	public boolean hasMultipleExpressions(){
		return false; 
	}
	public static class AssignmentExpression extends Expression{
		Expression target=null;
		Expression value=null;
		AssignmentOperator operator=null;
		
		
		public AssignmentExpression(Node parent, int line_no,AssignmentSymbol symbol) {
			super(parent, line_no);
			operator=new AssignmentOperator(symbol);
		}
		
		public AssignmentSymbol getOperator() {
			return operator.getSymbol();
		}
		

		public void setOperator(AssignmentSymbol operator) {
			this.operator.setSymbol(operator);
		}

		public Expression getTarget() {
			return target;
		}

		public void setTarget(Expression target) {
			this.target = target;
		}

		public Expression getValue() {
			return value;
		}

		public void setValue(Expression value) {
			this.value = value;
		}
		
		public String toString(){
			StringBuilder sb=new StringBuilder();
			//sb.append("\t");
			sb.append(target.toString());
			//sb.append(" ");
			if(!operator.isNull()){
				sb.append(operator.toString());
				//sb.append(" ");
				sb.append(value.toString());
			}
			
			return sb.toString();
		}

		@Override
		public boolean isNonBoolean() {
			return true;//TODO: Check if simple assignment in java returns anything
		}

		@Override
		public String toStringWithNoFormatting() {
			return toString();
		}
		
		
	}
	
	public static class UnaryExpression extends Expression{
		UnaryOperator operator;
		Expression expression;
		
		public UnaryExpression(Node parent, int line_no,UnarySymbol symbol) {
			super(parent, line_no);
			operator=new UnaryOperator(symbol);
		}
		
		public UnaryExpression(Node parent, int line_no,UnarySymbol symbol,Expression expression) {
			super(parent, line_no);
			operator=new UnaryOperator(symbol);
			this.expression=expression;
		}
		
		
		public UnarySymbol getOperator() {
			return operator.getSymbol();
		}
		

		public void setOperator(UnarySymbol operator) {
			this.operator.setSymbol(operator);
		}


		public Expression getExpression() {
			return expression;
		}


		public void setExpression(Expression expression) {
			this.expression = expression;
		}
		
		public String toString(){
			StringBuilder sb=new StringBuilder();
			if(operator!=null && !operator.isNull())
				sb.append(operator.toString());
			sb.append(expression.toString());
			
			return sb.toString();
		}

		@Override
		public boolean isNonBoolean() {
			
			return true;
		}

		@Override
		public String toStringWithNoFormatting() {
			StringBuilder sb=new StringBuilder();
			if(operator!=null && !operator.isNull())
				sb.append(operator.toString());
			sb.append(expression.toStringWithNoFormatting());
			
			return sb.toString();
		}


		
		
		
	}
	public static class BinaryExpression extends Expression{
		//ArrayList<Expression> expressions=new ArrayList<Expression>();
		Expression lhs=null;
		Expression rhs=null;
		BinaryOperator operator=null;
		
		public BinaryExpression(Node parent, int line_no,BinarySymbol operator) {
			super(parent, line_no);
			this.operator=new BinaryOperator(operator);
			 
		}
		
		
		public Expression getLhs() {
			return lhs;
		}


		public void setLhs(Expression lhs) {
			this.lhs = lhs;
		}


		public Expression getRhs() {
			return rhs;
		}


		public void setRhs(Expression rhs) {
			this.rhs = rhs;
		}


		public BinarySymbol getOperator() {
			return operator.getSymbol();
		}
		

		public void setOperator(BinarySymbol operator) {
			this.operator.setSymbol(operator);
		}
		
		public String toString(){
			StringBuilder sb=new StringBuilder();
			//sb.append(" ");
			sb.append(lhs.toString());
			//sb.append(" ");
			if(!operator.isNull()){
				sb.append(operator.toString());
				//sb.append(" ");
				sb.append(rhs.toString());
			}
			
			return sb.toString();
		}


		@Override
		public boolean isNonBoolean() {
			// TODO Auto-generated method stub
			if(rhs==null) return lhs.isNonBoolean();
			else if(operator.isBoolean() ==false) return true;
			
			return false;
		}


		@Override
		public String toStringWithNoFormatting() {
			StringBuilder sb=new StringBuilder();
			//sb.append(" ");
			sb.append(lhs.toStringWithNoFormatting());
			//sb.append(" ");
			if(!operator.isNull()){
				sb.append(operator.toString());
				//sb.append(" ");
				sb.append(rhs.toStringWithNoFormatting());
			}
			
			return sb.toString();
		}
		
		
		
		/*public ArrayList<Expression> getExpressions(){
			return expressions;
		}

		@Override
		public void addChild(Node node) {
			expressions.add((Expression)node);
		}

		@Override
		public Node getNextChild(Node existing) {
			
			int index=expressions.indexOf((Expression)existing);
			return (index >=0 )? expressions.get(index+1):null;
		}

		@Override
		public Node getPreviousChild(Node existing) {
			int index=expressions.indexOf((Expression)existing);
			return (index >=0 )? expressions.get(index-1):null;
		}

		@Override
		public boolean replaceChild(Node existing, Node by) {
			// TODO Auto-generated method stub
			return super.replaceChild(existing, by);
		}

		@Override
		public Node getNextSibling() {
			
			return super.getNextChild(this);
		}

		@Override
		public Node getPreviousSibling() {
			
			return super.getPreviousChild(this);
		}*/
		
		
	}
	
	public static class TertiaryExpression extends Expression{
		
		private Expression conditionExpression=null;
		private Expression ifExpression=null;
		private Expression elseExpression=null;
		
		public TertiaryExpression(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
		}

		public Expression getConditionExpression() {
			return conditionExpression;
		}

		public void setConditionExpression(Expression conditionExpression) {
			this.conditionExpression = conditionExpression;
		}

		public Expression getIfExpression() {
			return ifExpression;
		}

		public void setIfExpression(Expression ifExpression) {
			this.ifExpression = ifExpression;
		}

		public Expression getElseExpression() {
			return elseExpression;
		}

		public void setElseExpression(Expression elseExpression) {
			this.elseExpression = elseExpression;
		}
		
		public String toString(){
			StringBuilder sb=new StringBuilder();
			sb.append(conditionExpression.toString());
			
			if(ifExpression!=null){
				sb.append(TertiaryOperator.TERTIARY_CONDITION.toString());
				sb.append(ifExpression.toString());
				sb.append(TertiaryOperator.TERTIARY_ELSE.toString());
				sb.append(elseExpression.toString());
			}
			
			return sb.toString();
		}

		@Override
		public boolean isNonBoolean() {
			// TODO Auto-generated method stub
			
			return (ifExpression.isNonBoolean() || elseExpression.isNonBoolean());
		}

		@Override
		public String toStringWithNoFormatting() {
			// TODO Auto-generated method stub
			StringBuilder sb=new StringBuilder();
			sb.append(conditionExpression.toString());
			
			if(ifExpression!=null){
				sb.append(TertiaryOperator.TERTIARY_CONDITION.toString());
				sb.append(ifExpression.toStringWithNoFormatting());
				sb.append(TertiaryOperator.TERTIARY_ELSE.toString());
				sb.append(elseExpression.toStringWithNoFormatting());
			}
			
			return sb.toString();
		}
		
		
		
	}
	
	public static class PrimaryExpression extends Expression{
		GenericRef ref=null;
		Expression expression=null;
		boolean hasParanthesis=false;
		
		public RefType getRefernceType()
		{
			return ref.type;
			
		}
		
		public void setGlobalReference(String class_name)
		{
			ref.str=class_name+"."+ref.str;
			
		}
		
		public PrimaryExpression(Node parent, int line_no,String str,RefType type) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
			
			ref=new GenericRef(str, type);
		}
		public PrimaryExpression(Node parent, int line_no,Expression expression) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
			
			this.expression=expression;
		}
		public boolean isHasParanthesis() {
			return hasParanthesis;
		}
		public void setHasParanthesis(boolean hasParanthesis) {
			this.hasParanthesis = hasParanthesis;
		}
		
		public String toString(){
			
			if(ref!=null)
				return ref.toString();
			
			
			StringBuilder sb=new StringBuilder();
			if(hasParanthesis)
				sb.append("(");
			sb.append(expression.toStringWithNoFormatting());
			if(hasParanthesis)
				sb.append(")");
			
			return sb.toString();
		}
		@Override
		public boolean isNonBoolean() {
			// TODO Auto-generated method stub
			if(ref!=null) return true;
			else if(expression!=null) return expression.isNonBoolean();
			
			return false;
		}
		@Override
		public String toStringWithNoFormatting() {
			if(ref!=null)
				return ref.toString();
			
			
			StringBuilder sb=new StringBuilder();
			if(hasParanthesis)
				sb.append("(");
			sb.append(expression.toStringWithNoFormatting());
			if(hasParanthesis)
				sb.append(")");
			
			return sb.toString();
		}	
		
	}
	
	public static class PostfixExpression extends Expression{
		PrimaryExpression primaryExpression=null;
		/*ArrayList<Expression> expressions=null;
		ArrayList<UnaryOperator> operators=null;*/
		
		ArrayList<PostfixExpressionCollector> allPostfix=new ArrayList<PostfixExpressionCollector>();
		boolean isArr=false; //TODO hardcoded should be changed
		
		public static class PostfixExpressionCollector{
			Expression expression=null;
			ListExpression expressions=null;
			
			UnaryOperator operator=null;
			Identifier identifier=null;
			
			PostfixExpressionType type=null;
			
			public PostfixExpressionType getType(){
				return this.type;
			}
			public static enum PostfixExpressionType{
				ARRAY,POST_INC,POST_DEC,DEREFER,POINTER_DEREFER,FUNCTION_CALL
			}
			
			public PostfixExpressionCollector(PostfixExpressionType type,Expression expression){
				this.type=type;
				this.expression=expression;
			}
			
			public PostfixExpressionCollector(PostfixExpressionType type,ListExpression expressions){
				this.type=type;
				this.expressions=expressions;
			}
			
			public PostfixExpressionCollector(PostfixExpressionType type,UnaryOperator operator){
				this.type=type;
				this.operator=operator;
			}
			
			public PostfixExpressionCollector(PostfixExpressionType type,Identifier identifier){
				this.type=type;
				this.identifier=identifier;
			}
			
			public String toString(){
				StringBuilder sb=new StringBuilder();
				if(type==PostfixExpressionType.ARRAY){
					sb.append("[");
					sb.append(expression.toStringWithNoFormatting());
					sb.append("]");
					return sb.toString();
				}
				else if(type==PostfixExpressionType.FUNCTION_CALL){
					sb.append("(");
					if(expressions!=null)
						sb.append(expressions.getAllExpressionStringCommaSeperated());
					sb.append(")");
					return sb.toString();
				}
				else if(type==PostfixExpressionType.POST_DEC || type==PostfixExpressionType.POST_INC){
					return operator.toString();
				}
				else if(type==PostfixExpressionType.DEREFER || type==PostfixExpressionType.POINTER_DEREFER){
					
					sb.append(".");
					sb.append(identifier.toStringWithNoFormatting());
					return sb.toString();
					
				}
				
				return sb.toString();
			}
		}
		
		
		public PostfixExpression(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
		}
		
		
		
		public boolean isArr() {
			return isArr;
		}



		public void setArr(boolean isArr) {
			this.isArr = isArr;
		}



		public PrimaryExpression getPrimaryExpression() {
			return primaryExpression;
		}



		public void setPrimaryExpression(PrimaryExpression primaryExpression) {
			this.primaryExpression = primaryExpression;
		}


		public void addPostfix(PostfixExpressionCollector postfix){
			allPostfix.add(postfix);
		}
		/*public void setExpression(Expression expression) {
			if(this.expressions==null)
				this.expressions=new ArrayList<Expression>();
			this.expressions.add(expression);
		}
		

		public void setOperator(UnarySymbol operator) {
			if(this.operators==null)
				this.operators=new ArrayList<UnaryOperator>();
			this.operators.add(new UnaryOperator(operator));
		}*/
		
		public String toString(){
			StringBuilder sb=new StringBuilder();
			
			
			int size=allPostfix.size();
			if(size>=1){
				if(allPostfix.get(0).getType()==PostfixExpressionType.FUNCTION_CALL){
					FunctionDAO dao=APIMappingTable.getFunctionMapping("", primaryExpression.toStringWithNoFormatting());
					if(dao!=null){
						sb.append(dao.functionName.toStringWithNoFormatting());
					}
					else{
						sb.append(primaryExpression.toString());
					}
				}
				else{
					sb.append(primaryExpression.toString());
				}
			}
			else{
				sb.append(primaryExpression.toString());
			}
			
			
			for(int i=0;i<size;i++)
				sb.append(allPostfix.get(i).toString());
			
			/*if(expressions!=null){
				int size=expressions.size();
				for(int i=0;i<size;i++){
					sb.append("[");
					sb.append(expressions.get(i).toStringWithNoFormatting());
					sb.append("]");
				}
			}
			
			if(operators!=null){
				int size=operators.size();
				for(int i=0;i<size;i++){
					sb.append(operators.get(i));
				}
			}*/
			
			return sb.toString();
		}



		@Override
		public boolean isNonBoolean() {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public String toStringWithNoFormatting() {
			
			StringBuilder sb=new StringBuilder();

			
			
			int size=allPostfix.size();
			if(size>=1){
				if(allPostfix.get(0).getType()==PostfixExpressionType.FUNCTION_CALL){
					FunctionDAO dao=APIMappingTable.getFunctionMapping("", primaryExpression.toStringWithNoFormatting());
					if(dao!=null){
						sb.append(dao.functionName.toStringWithNoFormatting());
					}
					else{
						sb.append(primaryExpression.toStringWithNoFormatting());
					}
				}
				else{
					sb.append(primaryExpression.toString());
				}
			}
			else{
				sb.append(primaryExpression.toStringWithNoFormatting());
			}
			for(int i=0;i<size;i++)
				sb.append(allPostfix.get(i).toString());
			sb.append(";");
			/*sb.append(primaryExpression.toStringWithNoFormatting());
			if(expressions!=null){
				int size=expressions.size();
				for(int i=0;i<size;i++){
					sb.append("[");
					sb.append(expressions.get(i).toStringWithNoFormatting());
					sb.append("]");
				}
			}
			
			if(operators!=null){
				int size=operators.size();
				for(int i=0;i<size;i++){
					sb.append(operators.get(i));
				}
			}*/
			
			return sb.toString();
		}
		
	}
	
	/**
	 * It handles the explicit type casting in an expression
	 *
	 */
	public static class CastExpression extends Expression{

		private Expression unaryExpression=null;
		private MethodType castedType=null;
		private Expression childCastExpression=null;
		
		public CastExpression(Node parent, int line_no) {
			super(parent, line_no);
			
		}
		
		public Expression getUnaryExpression() {
			return unaryExpression;
		}

		public void setUnaryExpression(Expression unaryExpression) {
			this.unaryExpression = unaryExpression;
		}

		public MethodType getCastedType() {
			return castedType;
		}

		public void setCastedType(MethodType castedType) {
			this.castedType = castedType;
		}

		public Expression getChildCastExpression() {
			return childCastExpression;
		}

		public void setChildCastExpression(Expression childCastExpression) {
			this.childCastExpression = childCastExpression;
		}

		@Override
		public boolean isNonBoolean() {
			
			return false;
		}

		@Override
		public String toStringWithNoFormatting() {
			return toString();
		}
		
		@Override
		public String toString(){
			if(unaryExpression!=null)
				return unaryExpression.toString();
			CodeStringBuilder cb=new CodeStringBuilder();
			if(castedType!=null){
				cb.append("(");
				cb.append(castedType.toString());
				cb.append(")");
			}
			if(childCastExpression!=null)
				cb.append(childCastExpression.toStringWithNoFormatting());
			return cb.toString();
		}
		
	}
	
	static public class ListExpression extends Expression{
		ArrayList<Expression> expressions;
		
		public ListExpression(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
			expressions=new ArrayList<Expression>();
		}
		
		public void addExpression(Expression e){
			expressions.add(e);
		}
		
		public ArrayList<Expression> getExpressions() {
			return expressions;
		}

		public void setExpressions(ArrayList<Expression> expressions) {
			this.expressions = expressions;
		}

		private Expression getLastExpression(){
			if(expressions.size()<=0)
				return null;
			return expressions.get(expressions.size()-1);
		}
		private ArrayList<Expression> getAllExceptLastExpression(){
			ArrayList<Expression> le=(ArrayList<Expression>)expressions.clone();
			le.remove(le.size()-1);
			return le;
			
		}
		public String getLastExpressionString(){
			Expression e=getLastExpression();
			return (e!=null)? e.toString() : "";
		}
		public String getAllExceptLastExpressionString(){
			ArrayList<Expression> le=getAllExceptLastExpression();
			CodeStringBuilder sb=new CodeStringBuilder();
			for(int i=0;i<le.size();i++){
				sb.appendWithTabNewLine(le.get(i).toString()+";");
				
			}
			
			return sb.toString();
		}
		
		public String getExpressionStringForParameter(){
			CodeStringBuilder sb=new CodeStringBuilder();
			
			int size=expressions.size()-1;
			for(int i=0;i<=size;i++){
				Expression p=expressions.get(i);
				sb.append(p.toString());
				sb.append((i==size)?"":",");
			}
			
			
			return sb.toString();
			
		}
		

		public String getAllExpressionStringCommaSeperated(){
			
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<expressions.size()-1;i++){
				sb.append(expressions.get(i).toString());
				sb.append(",");
			}
			sb.append(expressions.get(expressions.size()-1));
			
			return sb.toString();
		}
		public String toString(){
			//TODO: Implement toString of ListExpression
			CodeStringBuilder sb=new CodeStringBuilder();
			for(int i=0;i<expressions.size();i++){
				sb.appendWithTabNewLine(expressions.get(i).toString()+";");// TODO  Creating Problems
			
			}
			
			return sb.toString();
		}
		
		
		public boolean isMultipleExpression(){
			
			return (expressions.size()>1); //TODO: Method isMultipleExpression needs to be deleted
		}
		
		@Override
		public boolean hasMultipleExpressions(){
			return (expressions.size()>1);
		}

		@Override
		public boolean isNonBoolean() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String toStringWithNoFormatting() {
			//TODO: Implement toString of ListExpression
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<expressions.size();i++){
				sb.append(expressions.get(i).toStringWithNoFormatting());// TODO  Creating Problems
			
			}
			
			return sb.toString();
		}
		
		
		
		
	}

}
