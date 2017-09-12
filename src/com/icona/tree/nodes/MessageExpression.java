package com.icona.tree.nodes;

import java.util.ArrayList;

import com.icona.helper.CodeStringBuilder;

/**
 * Stores the data related to the Message calling or the Objective-C function call
 *
 */
public class MessageExpression extends Expression {
	
	private Expression receiver=null;
	
	private ArrayList<Parameter> parameters=null;
	private Identifier messageName=null;
	private String mappedMessageName=null;
	private String mappedReceiverName=null;
	private Integer totalMappedParameterLength=null;
	
	
	
	
	public Integer getTotalMappedParameterLength() {
		return totalMappedParameterLength;
	}

	public void setTotalMappedParameterLength(Integer totalMappedParameterLength) {
		this.totalMappedParameterLength = totalMappedParameterLength;
	}

	public String getMappedReceiverName() {
		return mappedReceiverName;
	}

	public void setMappedReceiverName(String mappedReceiverName) {
		this.mappedReceiverName = mappedReceiverName;
	}

	public MessageExpression(Node parent, int line_no) {
		super(parent, line_no);
		// TODO Auto-generated constructor stub
		parameters=new ArrayList<Parameter>();
	}
	
	public void addParameter(Parameter param){
		parameters.add(param);
	}

	public Identifier getMessageName() {
		return messageName;
	}
	
	

	public String getMappedMessageName() {
		return mappedMessageName;
	}

	public void setMappedMessageName(String mappedMessageName) {
		this.mappedMessageName = mappedMessageName;
	}

	public Expression getReceiver() {
		return receiver;
	}

	public void setReceiver(Expression receiver) {
		this.receiver = receiver;
	}

	public void setMessageName(Identifier messageName) {
		this.messageName = messageName;
	}

	@Override
	public boolean isNonBoolean() {
		return false;
	}
	
	/**
	 * Creates function name by appending the selector of each parameter separated with underscore
	 * @return The created function name
	 */
	private String createFunctionName(){
		String s="";
		for(int i=0;i<parameters.size();i++){
			if(parameters.get(i).getSelector()!=null) //If there is no selector for a parameter
				s+=((i==0)?"":"_")+parameters.get(i).getSelector().unIndentatedString();
		}
		return s;
	}
	
	public String getFunctionName(){
		if(messageName!=null)
			return messageName.getName();
		return createFunctionName();
	}
	
	public String getReceiverName(){
		//TODO: Check that the receiver class can be of what other types
		if (receiver.getClass() == ListExpression.class)
			return ((ListExpression)receiver).getExpressionStringForParameter() ;
		else if(receiver.getClass() == PrimaryExpression.class)
			return ((PrimaryExpression)receiver).toStringWithNoFormatting() ;
		
		return "";
	}
	
	public String toString(){
		CodeStringBuilder sb=new CodeStringBuilder();
		
		if(mappedReceiverName!=null){
			sb.append(mappedReceiverName);
		}
		else{
			if (receiver.getClass() == ListExpression.class)
				sb.append( ((ListExpression)receiver).getExpressionStringForParameter() );
			else if(receiver.getClass() == PrimaryExpression.class)
				sb.append( ((PrimaryExpression)receiver).toStringWithNoFormatting() );
		}
		
		
		sb.append(".");
		if(messageName!=null){
			sb.append(messageName.unIndentatedString());
			sb.append("()");
		}
		else{
			
			if(mappedMessageName!=null)
				sb.append(mappedMessageName);
			else
				sb.append(createFunctionName());
			
			
			sb.append("(");
			
			int size=parameters.size()-1;
			//TODO It doesn't work if number of parameters is zero 0
			if(totalMappedParameterLength!=null && totalMappedParameterLength-1<size){
				size=totalMappedParameterLength-1;
			}
			for(int i=0;i<=size;i++){
				Parameter p=parameters.get(i);
				sb.append(p.getMessageCallingExpresisonString());
				sb.append((i==size)?"":",");
			}
			
			sb.append(")");
		}
		
		return sb.toString();
	}

	@Override
	public String toStringWithNoFormatting() {
		// TODO toStringWithNoFormatting of MessageExpression
		return toString();
	}

}
