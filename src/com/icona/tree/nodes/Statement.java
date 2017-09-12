package com.icona.tree.nodes;

import java.util.ArrayList;
import java.util.Iterator;

import com.icona.helper.CodeStringBuilder;
import com.icona.helper.DAO.FunctionDAO;
import com.icona.tree.nodes.Declaration.AccessType;
import com.icona.tree.nodes.Expression.ListExpression;
import com.icona.tree.nodes.Type.DataType;

/**
 * An abstract class of statement
 * 
 * All statements inherit from this class. Its main purpose is polymorphism
 *
 */
public abstract class Statement extends Node {

	public abstract boolean hasMultipleExpressions();

	/**
	 * Stores the information regarding 'case' in 'switch' statement
	 * 
	 *
	 */
	public static class CaseDefaultStatement extends Statement {
		/**
		 * Stores the all statement in 'case' or 'default' 
		 */
		Statement statement;
		
		/**
		 * Stores the number or other constant value after 'case'
		 */
		Expression constExpression;
	    
		public CaseDefaultStatement(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @return Generated code
		 */
		@Override
		public String toString()
		{
			CodeStringBuilder sb=new CodeStringBuilder();
		    	if(constExpression==null){
		    		sb.appendWithTab("default");
		    	}
		    	else{
				    sb.appendWithTab("case ");
			    	sb.append(constExpression);	
		    	}
		    	
		    	sb.appendWithNewLine(":");
		    	CodeStringBuilder.addTab();
		    	sb.appendWithNewLine(statement);		
		    	CodeStringBuilder.removeTab();
		    	
			return sb.toString();
		}

		public Statement getStatement() {
			return statement;
		}

		public void setStatement(Statement statement) {
			this.statement = statement;
		}
		public Expression getConstExpression() {
			return constExpression;
		}

		public void setConstExpression(Expression constExpression) {
			this.constExpression = constExpression;
		}


		/**
		 * Tells whether the statement supports multiple expression
		 * 
		 * @return true if statement supports multiple expression
		 */
		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	/**
	 * Stores the information regarding jump statements such as 'break','continue','return' etc
	 * 
	 * 'goto' is not supported in java so its code will not be generated
	 *
	 */
	public static class JumpStatement extends Statement{

		/**
		 * Enumeration for different type of jump statements
		 *
		 */
		public enum JumpType{
			GOTO(""),
			CONTINUE("continue"),
			BREAK("break"),
			RETURN("return");
			
			private String code;
			private JumpType(String str){
				code=str;
			}
			
			public String toString(){
				return code;
			}
		}
		
		private Expression expression=null;
		private JumpType jumpType;
		private DataType castingTypeInReturn=null;
		
		public DataType getCastingTypeInReturn() {
			return castingTypeInReturn;
		}


		public void setCastingTypeInReturn(DataType castingTypeInReturn) {
			this.castingTypeInReturn = castingTypeInReturn;
		}


		public JumpStatement(Node parent, int line_no,JumpType jumpType) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
			
			this.jumpType=jumpType;
		}

		
		public Expression getExpression() {
			return expression;
		}

		public void setExpression(Expression expression) {
			this.expression = expression;
		}

		/**
		 * Generates the code
		 * 
		 * @return Generated code
		 */
		public String toString(){

			CodeStringBuilder sb=new CodeStringBuilder();
			
			if(jumpType == JumpType.GOTO)
				return "";
			
			Function fParent=(Function)parent;
			FunctionDAO dao=fParent.getFunctionMappingDAOOrFunctionDAO();
			
			
			sb.appendWithTab(jumpType.toString());
			boolean isCasted=false;
			if(castingTypeInReturn != null && castingTypeInReturn.toString().length() > 0 && !castingTypeInReturn.toString().equals("void ")){
				isCasted=true;
				sb.append(" (");
				sb.append(castingTypeInReturn.toString());
				sb.append(")");
				sb.append("(");
			}
			if(dao!=null && dao.returnTypeFunction.length()>0) 
				sb.append(" "+dao.returnTypeFunction+"(");
			else 
				sb.append(" ");
			
			if(expression != null)
				sb.append(expression.toStringWithNoFormatting());
			
			if(dao!=null && dao.returnTypeFunction.length()>0){
				sb.append(")");
			}
			if(isCasted){
				sb.append(")");
			}
			sb.appendWithNewLine(";");
			
			return sb.toString();
		}
		
		
		
		
		/**
		 * Tells whether the statement supports multiple expression
		 * 
		 * @return false as jump statement doesn't support multiple expression
		 */
		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	public static class LabelStatement extends Statement {
		Statement statement;
		Identifier identifier;
		
		public LabelStatement(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * Generates the code
		 * 
		 * @return Generated code
		 */
		@Override
		public String toString()
		{
			CodeStringBuilder sb=new CodeStringBuilder();
		    	
			    sb.append(identifier);
		    	sb.append(":");
		    	sb.append(statement);
		    	
			return sb.toString();
		}

		public Statement getStatement() {
			return statement;
		}
			
		public void setStatement(Statement statement) {
			this.statement = statement;
		}

		public Identifier getIdentifier() {
			return identifier;
		}

		public void setIdentifier(Identifier identifier) {
			this.identifier = identifier;
		}

		/**
		 * Tells whether the statement supports multiple expression
		 * 
		 * @return false as label statement doesn't support multiple expression
		 */
		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

	/**
	 * Compound statement refers to a block of code with parenthesis
	 *
	 */
	public static class CompoundStatement extends Statement{
		
		ArrayList<Declaration> declaration=null;
		Statement statement=null;
		
		public CompoundStatement(Node parent, int line_no) {
			super(parent, line_no);
			declaration= new ArrayList<Declaration>();
			// TODO Auto-generated constructor stub
		}
		public void addDeclaration(ArrayList<Declaration> d)
		{
			declaration.addAll(d);
			
		}
		
		public ArrayList<Declaration> getDeclaration() {
			return declaration;
		}
		public void setDeclaration(ArrayList<Declaration> declaration) {
			this.declaration = declaration;
		}
		public Statement getStatement() {
			return statement;
		}
		public boolean setStatement(Statement statement) {
			this.statement = statement;
			return true;
		}
		
		/**
		 * Generates the code
		 * 
		 * @return Generated code
		 */
		public String toString(){
			
			/*
			 * The code for putting the function initialization from database
			 * is also being handled here
			 */
			//The extra code for mapping only if function has initbody initialized
			String functionInitBody=null;
			if(parent!=null && parent instanceof Function){
				Function f=(Function)parent;
				//Getting the api FunctionDAO of the mapping of parent function
				FunctionDAO dao=f.getFunctionMappingDAOOrFunctionDAO();
				
				//Getting the functionInitBody from the mapped class
				if(dao !=null )
					functionInitBody=dao.getFunctionInitBodyUnescaped();
				
			}
			CodeStringBuilder sb=new CodeStringBuilder();
			sb.appendWithTabNewLine("{");
			CodeStringBuilder.addTab();
			
			//Appending the function initialization code if there exists any
			if(functionInitBody!=null)
				sb.appendWithNewLine(functionInitBody);
			
			
			
			if(statement!=null)
				sb.append(statement.toString()); //TODO: To be done
			
			CodeStringBuilder.removeTab();
			sb.appendWithTab("}");
			
			return sb.toString();
			
		}
		/**
		 * Tells whether the statement supports multiple expression
		 * 
		 * @return false as compund statement doesn't support multiple expression directly
		 */
		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return false;
		}
		
		
	}
	
	/**
	 * Stores reference to one or more statements
	 * 
	 *
	 */
	public static class StatementList extends Statement{
		
		ArrayList<Statement> statements;
		
		public StatementList(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
			statements=new ArrayList<Statement>();
		}

		public ArrayList<Statement> getStatements() {
			return statements;
		}

		public void setStatements(ArrayList<Statement> statements) {
			this.statements = statements;
		}
		public void addStatement(Statement s)
		{
			if(statements==null)
				statements=new ArrayList<Statement>();
			statements.add(s);

		}
		
		/**
		 * Generates the code
		 * 
		 * @return Generated code
		 */
		public String toString()
		{
			CodeStringBuilder sb=new CodeStringBuilder();
			for(int i=0; i<statements.size(); i++)
			{
				
				sb.append(statements.get(i).toString());
				//System.err.println(statements.get(i).line_no);
				
			}
			
			return sb.toString();
		}

		/**
		 * Tells whether the statement supports multiple expression
		 * 
		 * @return false as StatementList statement doesn't support multiple expression directly
		 */
		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	/**
	 * Stores information of an 'if' - 'else' statement
	 * 
	 * Stores the condition of 'if' statement and code blocks after 'if' and after 'else' (if any)
	 */
	public static class If extends Statement{
		
		Expression expression=null;
		Statement ifStatement=null;
		Statement elseStatement=null;
		
		public If(Node parent, int line_no) {
			super(parent, line_no);
		
		}

		public Expression getExpression() {
			return expression;
		}

		public void setExpression(Expression expression) {
			this.expression = expression;
		}

		public Statement getIfStatement() {
			return ifStatement;
		}

		public void setIfStatement(Statement ifStatement) {
			this.ifStatement = ifStatement;
		}

		public Statement getElseStatement() {
			return elseStatement;
		}

		public void setElseStatement(Statement elseStatement) {
			this.elseStatement = elseStatement;
		}
		
		/**
		 * Generates the code
		 * 
		 * @return Generated code
		 */
		@Override
		public String toString()
		{
			ListExpression le=null;
			if(expression.getClass()==ListExpression.class)
				le=(ListExpression)expression;
			
			CodeStringBuilder sb=new CodeStringBuilder();
			
			
			if(le!=null) sb.appendWithNewLine(le.getAllExceptLastExpressionString());
			sb.appendWithTab("if (");
			sb.append((le!=null)?le.getLastExpressionString():expression.toString());
			sb.appendWithNewLine(")");
			
			//CodeStringBuilder.addTab();
			
			if(ifStatement.hasMultipleExpressions()){
				sb.appendWithTabNewLine("{");
				CodeStringBuilder.addTab();
			}
			 
			
			sb.appendWithNewLine(ifStatement.toString());
			
			if(ifStatement.hasMultipleExpressions()){
				CodeStringBuilder.removeTab();
				sb.append("}");
			}
			
			
			//CodeStringBuilder.removeTab();
			
			//sb.append("\n");
			if(elseStatement!=null)
			{
				sb.appendWithTab("else ");
				//CodeStringBuilder.addTab();
				
				boolean includeParanthesis=elseStatement.hasMultipleExpressions();//((elseStatement.getClass()==If.class && ((ListExpression)((If)elseStatement).getExpression()).isMultipleExpression()) || (elseStatement.getClass()==While.class && ((ListExpression)((While)elseStatement).getExpression()).isMultipleExpression()) || (elseStatement.getClass()==ListExpression.class && ((ListExpression)elseStatement).isMultipleExpression()));//TODO Add for loop in it;
				
				if(includeParanthesis){
					sb.appendWithTabNewLine("{");
					CodeStringBuilder.addTab();
				}
				
				
				sb.appendWithNewLine(elseStatement.toString());
				
				if(includeParanthesis){
					CodeStringBuilder.removeTab();
					sb.appendWithTabNewLine("}");
				}
				
				//CodeStringBuilder.removeTab();
			}
			return sb.toString();
			
		}

		/**
		 * Tells whether the statement supports multiple expression
		 * 
		 * @return false as StatementList statement doesn't support multiple expression directly
		 */
		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return expression.hasMultipleExpressions();
		}
		
		
	}
	
	/**
	 * Stores information regarding 'for' loop.
	 * 
	 * It contains the declaration part of for, the condition expression and the change expression in
	 * the for loop 
	 *
	 */
	static public class ForLoop extends Statement{

		Expression exprInit;
		ListDeclaration declInit;
		Expression exprCondition;
		Expression exprLast;
		Statement statement;
		/**
		 * Generates the code
		 * 
		 * @return Generated code
		 */
		public String toString(){
			CodeStringBuilder sb=new CodeStringBuilder();
			
			ListExpression le=null;
			if(exprCondition!=null && exprCondition.getClass()==ListExpression.class)
				le=(ListExpression)exprCondition;
			
			
			if(declInit!=null){
				sb.appendWithTabNewLine("{");
				CodeStringBuilder.addTab();
				sb.appendWithNewLine(declInit.toString());
			}
			if(le!=null)
				sb.appendWithNewLine(le.getAllExceptLastExpressionString());
			sb.appendWithTab("for (");

			if(exprInit!=null)
				sb.append(((ListExpression)exprInit).getAllExpressionStringCommaSeperated());
			sb.append(";");

			if(le!=null)
				sb.append(le.getLastExpressionString());
			sb.append(";");

			if(exprLast!=null)
				sb.append(((ListExpression)exprLast).getAllExpressionStringCommaSeperated());
			sb.appendWithNewLine(")");
			if(le!=null && le.isMultipleExpression()){
				sb.appendWithTabNewLine("{");
				CodeStringBuilder.addTab();
			}

			if(statement!=null && statement.hasMultipleExpressions()){
				sb.appendWithTabNewLine("{");
				CodeStringBuilder.addTab();
			}
			if(statement!=null)
				sb.appendWithNewLine(statement);
			if(statement!=null && statement.hasMultipleExpressions()){
				CodeStringBuilder.removeTab();
				sb.appendWithTabNewLine("}");
			}
			sb.append("\n");
			if(le!=null)
				sb.appendWithNewLine(le.getAllExceptLastExpressionString());
			if(le!=null && le.isMultipleExpression()){
				CodeStringBuilder.removeTab();
				sb.appendWithTabNewLine("}");
			}

			if(declInit!=null){
				CodeStringBuilder.removeTab();
				sb.appendWithTabNewLine("}");
			}
			return sb.toString();

		}
		
		public ForLoop(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
			exprInit=exprLast=exprCondition=null;
			declInit=null;
		}


		public Statement getStatement() {
			return statement;
		}

		public void setStatement(Statement statement) {
			this.statement = statement;
		}

		

		public Expression getExprInit() {
			return exprInit;
		}

		public void setExprInit(Expression exprInit) {
			this.exprInit = exprInit;
		}

		public ListDeclaration getDeclInit() {
			return declInit;
		}

		public void setDeclInit(ListDeclaration declInit) {
			this.declInit = declInit;
		}

		public Expression getExprCondition() {
			return exprCondition;
		}

		public void setExprCondition(Expression exprCondition) {
			this.exprCondition = exprCondition;
		}

		public Expression getExprLast() {
			return exprLast;
		}

		public void setExprLast(Expression exprLast) {
			this.exprLast = exprLast;
		}

		/**
		 * Tells whether the statement supports multiple expression
		 * 
		 * @return true if the condition expression has multiple expression
		 */
		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return exprCondition.hasMultipleExpressions();
		}
		
		
		
		
	}
	
	static public class doWhile extends Statement{
		
		public doWhile(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
		}

		Expression expression;
		Statement statement;
		
		@Override
		public String toString(){
			
			
			ListExpression le=null;
			if(expression.getClass()==ListExpression.class)
				le=(ListExpression)expression;
			
			CodeStringBuilder sb=new CodeStringBuilder();
			sb.appendWithTabNewLine("do");
			boolean insertParenthesis=statement.hasMultipleExpressions() || le!=null && le.isMultipleExpression();
			
			if(insertParenthesis) sb.appendWithTabNewLine("{");
			
			//CodeStringBuilder.addTab();
			sb.appendWithNewLine(statement.toString());
			//sb.append("\n");
			if(le!=null) sb.appendWithNewLine(le.getAllExceptLastExpressionString());
			if(insertParenthesis) sb.appendWithTabNewLine("}");
			//sb.append("\n");
			
			//CodeStringBuilder.removeTab();
			
			sb.appendWithTab("while (");
			sb.append((le!=null)?le.getLastExpressionString():expression.toString());
			sb.appendWithNewLine(");");
			
			
			
			return sb.toString();
		}

		public Expression getExpression() {
			return expression;
		}

		public void setExpression(Expression expression) {
			this.expression = expression;
		}

		public Statement getStatement() {
			return statement;
		}

		public void setStatement(Statement statement) {
			this.statement = statement;
		}

		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return expression.hasMultipleExpressions();
		}
		
		
	}
	
public static class Switch extends Statement{
		
		Expression expression=null;
		Statement switchStatement=null;
		
		
		public Switch(Node parent, int line_no) {
			super(parent, line_no);
		
		}

		public Expression getExpression() {
			return expression;
		}

		public void setExpression(Expression expression) {
			this.expression = expression;
		}

		public Statement getIfStatement() {
			return switchStatement;
		}

		public void setSwitchStatement(Statement switchStatement) {
			this.switchStatement = switchStatement;
		}

	
		public String toString()
		{
			CodeStringBuilder sb=new CodeStringBuilder();
			sb.appendWithTab("switch (");
			sb.append(expression.toStringWithNoFormatting());
			sb.appendWithNewLine(")");
			sb.appendWithNewLine(switchStatement.toString());
			
			return sb.toString();
		}

		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return false;
		}
		
		
	}
static public class While extends Statement{
		
		Expression expression;
		Statement statement;
		
		@Override
		public String toString(){
			ListExpression le=null;
			if(expression.getClass()==ListExpression.class)
				le=(ListExpression)expression;
			boolean insertParenthesis=statement.hasMultipleExpressions() || le!=null && le.isMultipleExpression() ;
			CodeStringBuilder sb=new CodeStringBuilder();

			if(le!=null) sb.appendWithNewLine(le.getAllExceptLastExpressionString());
			sb.appendWithTab("while(");
			sb.append((le!=null)?le.getLastExpressionString():expression.toString());
			sb.appendWithNewLine(")");
			
			if(insertParenthesis) sb.appendWithTabNewLine("{");
			
			sb.appendWithNewLine(statement.toString());
			//sb.append("\n");
			if(le.isMultipleExpression()) sb.appendWithNewLine(le.getAllExceptLastExpressionString());
			
			
			if(insertParenthesis) sb.appendWithTabNewLine("}");
			return sb.toString();
		}

		public Expression getExpression() {
			return expression;
		}



		public void setExpression(Expression expression) {
			this.expression = expression;
		}



		public Statement getStatement() {
			return statement;
		}



		public void setStatement(Statement statement) {
			this.statement = statement;
		}



		public While(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return expression.hasMultipleExpressions();
		}
		
	}

	static public class ListDeclaration extends Statement{
		
		public ListDeclaration(Node parent, int line_no) {
			super(parent, line_no);
			// TODO Auto-generated constructor stub
		}

		ArrayList<Declaration> declarations=new ArrayList<Declaration>();
		
		public void setAllDeclarationParent(Node parent){ //to set global declaration parents
			for(int i=0;i<declarations.size();i++){
				declarations.get(i).setParent(parent);
			}
		}
		public Iterator<Declaration> getIterator(){
			return declarations.iterator();
		}
		public int size(){
			return declarations.size();
		}
		
		public Declaration get(int index){
			return declarations.get(index);
		}
		
		public void setAllDeclarationsAccessType(AccessType accessType){
			for(int i=0;i<declarations.size();i++){
				Declaration decl=declarations.get(i);
				decl.setAccessType(accessType);
				declarations.set(i, decl);	
			}
		}
		
		public void add(Declaration decl){
			declarations.add(decl);
			
		}
		
		public void addAll(ListDeclaration decl){
			declarations.addAll(decl.declarations);
		}
		
		public void remove(Declaration decl){
			declarations.remove(decl);
		}
		
		public String toString(){
			CodeStringBuilder sb=new CodeStringBuilder();
			for(int i=0;i<declarations.size();i++){
				if(declarations.get(i)!=null)
				sb.appendWithTabNewLine(declarations.get(i).toString()+";");//TODO the indentation is hard coded
			}
			return sb.toString();
		}
		
		public String toStringCommaSeperated(){
			StringBuilder sb=new StringBuilder();
			int size=declarations.size();
			for(int i=0;i<size;i++){
				if(declarations.get(i) !=null){
					sb.append(declarations.get(i).toString()+((i<size-1)?",":""));
				}
			}
			return sb.toString();
		}

		@Override
		public boolean hasMultipleExpressions() {
			// TODO Auto-generated method stub
			return false;
		}
		
		
	}
	

	
	
	public Statement(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
	} 

	@Override
	public void addChild(Node node){
		
		
	}
	@Override
	public Node getNextChild(Node existing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getPreviousChild(Node existing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean replaceChild(Node existing, Node by) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node getNextSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getPreviousSibling() {
		// TODO Auto-generated method stub
		return null;
	}

}
