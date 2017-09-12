package com.icona.tree.nodes;

import java.util.ArrayList;

import com.icona.helper.CodeStringBuilder;
import com.icona.tree.nodes.Expression.ListExpression;

public class Parameter extends Node {

	Identifier selector=null;
	ArrayList<MethodType> type=null;
	Identifier parameterName=null;
	Expression messageCallingExpression=null;
	
	public Parameter(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
		type=new ArrayList<MethodType>();
	}

	
	public Identifier getSelector() {
		return selector;
	}


	public void setSelector(Identifier selector) {
		this.selector = selector;
	}

	public ArrayList<MethodType> getType() {
		return type;
	}

	public void addType(MethodType type) {
		this.type.add(type);
	}

	public Identifier getParameterName() {
		return parameterName;
	}

	public void setParameterName(Identifier parameterName) {
		this.parameterName = parameterName;
	}

	
	public Expression getMessageCallingExpression() {
		return messageCallingExpression;
	}


	public void setMessageCallingExpression(Expression messageCallingExpression) {
		this.messageCallingExpression = messageCallingExpression;
	}
	
	public String messageCallingToString(){
		//TODO: Implement message calling
		return null;
	}


	public String getMessageCallingExpresisonString(){
		return ((ListExpression)messageCallingExpression).getExpressionStringForParameter();
	}
	public String toString(){
		CodeStringBuilder sb=new CodeStringBuilder();
		
		for(int i=0;i<type.size();i++){
			sb.append(type.get(i).toString());
		}
		sb.append(parameterName.unIndentatedString());
		
		return sb.toString();
	}
	
	



	@Override
	public void addChild(Node node) {
		// TODO Auto-generated method stub

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
