package com.icona.wrapper;

import java.nio.charset.Charset;


//Mapping of NSString
public class String extends ObjectExtended {

	java.lang.String currentString;
	

	public static String alloc(){
		return new String();
	}
	//+ (id)string
	public static String string()
	{
		return new String();
	}

	//- (id)init
	public String init()
	{
		currentString = new java.lang.String();
		return this;
	}
	
	//- (id)initWithBytes:(const void *)bytes length:(NSUInteger)length encoding:(NSStringEncoding)encoding
	public String initWithBytes_length_encoding(byte[] bytes, int length, Charset encoding)
	{
		currentString = new java.lang.String(bytes, length, length+1, encoding);
		return this;
	}
	
	/* initWithBytesNoCopy:length:encoding:freeWhenDone
	 * the above function can not be mapped because it 
	 * frees memory directed towards by a pointer as Java
	 * does not allow access to pointers and freeing memory
	 * this method can not be mapped, and also is not
	 * needed since its primary function is being done
	 * by the preceding function*/
	
	//- (id)initWithString:(NSString *)aString
	public String initWithString(String aString)
	{
		currentString = aString.currentString;
		return this;
	}
	
	public java.lang.String toString(){
		return currentString;
	}
	
	/*- (id)initWithCString:(const char *)nullTerminatedCString encoding:(NSStringEncoding)encoding
	 * Java does not provide a mechanism to parse to string
	 * a CString according to a particular encoding*/
	
	//- (id)initWithUTF8String:(const char *)bytes
	public String initWithUTF8String(char[] bytes)
	{
		currentString = new java.lang.String(bytes);
		return this;
	}
	
	//+ (id)stringWithString:(NSString *)aString
	public static String stringWithString(java.lang.String aString)
	{
		String newString = new String();
		newString.currentString = aString;
		return newString;
	}
	
	//(NSUInteger)length
	public int length()
	{
		return currentString.length();
	}
	
	//- (unichar)characterAtIndex:(NSUInteger)index
	public char charAt(int index)
	{
		return currentString.charAt(index);
	}
	
	//- (void)getCharacters:(unichar *)buffer range:(NSRange)aRange
	public void getCharacters_range(char[] buffer, Range aRange)
	{
		buffer = new char[aRange.length-aRange.location+1];
		for(int i = aRange.location, j = 0; i < aRange.length; ++i, ++j)
		{
			buffer[j] = currentString.charAt(i);
		}
	}
	
	//- (NSString *)stringByAppendingString:(NSString *)aString
	public String concat(String aString)
	{
		currentString.concat(aString.currentString);
		return this;
	}
	
	//- (NSString *)substringFromIndex:(NSUInteger)anIndex
	public String substring(int anIndex)
	{
		String sub = new String();
		sub.currentString = currentString.substring(anIndex);
		return sub;
	}
	
	//- (NSString *)substringWithRange:(NSRange)aRange
	public String substring(Range aRange)
	{
		String sub = new String();
		sub.currentString = currentString.substring(aRange.location, aRange.length);
		return sub;
	}
	
	//- (NSString *)substringToIndex:(NSUInteger)anIndex
	public String substringToIndex(int anIndex)
	{
		String sub = new String();
		sub.currentString = currentString.substring(0, anIndex);
		return sub;
	}
	
	//- (NSRange)rangeOfString:(NSString *)aString
	public Range rangeOfString(String aString)
	{
		Range range = new Range();
		if(currentString.contains(aString.currentString))
		{
			range.location = currentString.indexOf(aString.currentString);
			range.length = range.location + aString.length();
			return range;
		}
		return range;
	}	
}
