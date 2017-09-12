package com.icona.helper;

/**
 * A wrapper over StringBuilder
 * Its use is to create formated code by allowing to place tabs in subsequent statements and removing
 * the tabs.
 *
 */
public class CodeStringBuilder{

	private StringBuilder sb;
	private static int tabCount=0;
	private static String tabString="";
	
	
	//Class Functions
	
	public static int getTabCount(){
		return tabCount;
	}
	
	public static void addTab(){
		tabCount++;
		tabString+="\t";
		
	}
	
	public static String getTabString(){
		return tabString;
	}
	
	public static void removeTab(){
		if(tabCount>0)
			tabCount--;
		if(tabString.length()<=1)
			tabString="";
		else
			tabString=tabString.substring(0, tabString.length()-1);
		
		
	}
	
	
	
	
	
	//Object functions
	
	public CodeStringBuilder(){
		sb=new StringBuilder();
	}
	/**
	 * Appends the object with tab in tabCount
	 * @param obj the object to append
	 * @return StringBuilder instance
	 */
	public StringBuilder appendWithTab(Object obj){
		
		sb.append(tabString);
		return sb.append(obj);
	}


	/**
	 * Appends the string with tab in tabCount
	 * @param str the string to be appended
	 * @return StringBuilder instance
	 */
	public StringBuilder appendWithTab(String str){
		
		sb.append(tabString);
		return sb.append(str);
	}
	
	/**
	 * Appends the object with tab in tabCount and newline at end
	 * @param obj the object to append
	 * @return StringBuilder instance
	 */
	public StringBuilder appendWithTabNewLine(Object obj){
		
		sb.append(tabString);
		sb.append(obj);
		return sb.append("\n");
	}
	
	/**
	 * Appends the string with tab in tabCount and newline at end
	 * @param str the string to be appended
	 * @return StringBuilder instance
	 */
	public StringBuilder appendWithTabNewLine(String str){
		
		sb.append(tabString);
		sb.append(str);
		return sb.append("\n");
	}
	
	/**
	 * Appends the object with newline at end
	 * @param obj the object to append
	 * @return StringBuilder instance
	 */
	public StringBuilder appendWithNewLine(Object obj){

		sb.append(obj);
		return sb.append("\n");
	}
	
	/**
	 * Appends the string with newline at end
	 * @param str the string to be appended
	 * @return StringBuilder instance
	 */
	public StringBuilder appendWithNewLine(String str){
		

		sb.append(str);
		return sb.append("\n");
	}
	
	
	// Wrapper for all StringBuilder Functions
	public StringBuilder append(Object obj)
	{
		return sb.append(obj);
	}

	public StringBuilder append(String str) {
		return sb.append(str);
	}

	public StringBuilder append(StringBuilder sb)
	{
		return sb.append(sb);
	}

	public StringBuilder append(StringBuffer sb)
	{
		this.sb.append(sb);
		return this.sb;
	}

	public StringBuilder append(CharSequence s)
	{
		return sb.append(s);
	}

	public StringBuilder append(CharSequence s, int start, int end)
	{
		return sb.append(s,start,end);
	}

	public StringBuilder append(char[] str) {
		return sb.append(str);
	}

	public StringBuilder append(char[] str, int offset, int len) {
		return sb.append(str,offset,len);
	}

	public StringBuilder append(boolean b)
	{
		return sb.append(b);
	}

	public StringBuilder append(char c) {
		return sb.append(c);
	}

	public StringBuilder append(int i)
	{
		return sb.append(i);
	}

	public StringBuilder append(long lng)
	{
		return sb.append(lng);
	}

	public StringBuilder append(float f)
	{
		return sb.append(f);
	}

	public StringBuilder append(double d)
	{
		return sb.append(d);
	}

	public StringBuilder appendCodePoint(int codePoint)
	{
		return sb.appendCodePoint(codePoint);
	}

	public StringBuilder delete(int start, int end)
	{
		return sb.delete(start, end);
	}

	public StringBuilder deleteCharAt(int index)
	{
		return sb.deleteCharAt(index);
	}

	public StringBuilder replace(int start, int end, String str)
	{
		return sb.replace(start, end, str);
	}

	public StringBuilder insert(int index, char[] str, int offset, int len)
	{
		return sb.insert(index, str, offset, len);
	}

	public StringBuilder insert(int offset, Object obj)
	{
		return sb.insert(offset,obj);
	}

	public StringBuilder insert(int offset, String str)
	{
		return sb.insert(offset, str);
	}

	public StringBuilder insert(int offset, char[] str)
	{
		return sb.insert(offset, str);
	}

	public StringBuilder insert(int dstOffset, CharSequence s)
	{
		return sb.insert(dstOffset, s);
	}

	public StringBuilder insert(int dstOffset, CharSequence s, int start, int end)
	{
		return sb.insert(dstOffset, s, start, end);
	}

	public StringBuilder insert(int offset, boolean b)
	{
		return sb.insert(offset, b);
	}

	public StringBuilder insert(int offset, char c)
	{
		return sb.insert(offset, c);
	}

	public StringBuilder insert(int offset, int i)
	{
		return sb.insert(offset, i);
	}

	public StringBuilder insert(int offset, long l)
	{
		return sb.insert(offset, l);
	}

	public StringBuilder insert(int offset, float f)
	{
		return sb.insert(offset, f);
	}

	public StringBuilder insert(int offset, double d)
	{
		return sb.insert(offset, d);
	}

	public int indexOf(String str)
	{
		return sb.indexOf(str);
	}

	public int indexOf(String str, int fromIndex)
	{
		return sb.indexOf(str, fromIndex);
	}

	public int lastIndexOf(String str)
	{
		return sb.lastIndexOf(str);
	}

	public int lastIndexOf(String str, int fromIndex)
	{
		return sb.lastIndexOf(str, fromIndex);
	}

	public StringBuilder reverse()
	{
		return sb.reverse();
	}

	public String toString()
	{
		return sb.toString();
	}


}
