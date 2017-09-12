package com.icona.helper;

/**
 * Contains the XML Tag of the AndroidManifest used in AndroidManifest generation
 *
 */
public class ManifestGeneratorMetaData {
	private ManifestGeneratorMetaData(){}
	
	public static final int MIN_SDK_VERSION=8;
	public static final String PACKAGE_NAME="nu.fast.project";
	
	
	public static final String XML_TAG="<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	public static final String MANIFEST_TAG_START="<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"	package=\""+PACKAGE_NAME+"\" android:versionCode=\"1\" android:versionName=\"1.0\">";
	public static final String MANIFEST_TAG_END="</manifest>";
	public static final String USES_SDK_TAG="<uses-sdk android:minSdkVersion=\""+MIN_SDK_VERSION+"\" />";
	public static final String APPLICATION_TAG_START="<application android:icon=\"@drawable/icon\" android:label=\"@string/app_name\">";
	public static final String APPLICATION_TAG_END="</application>";
	public static final String PERMISSION_TAGS="<uses-permission android:name=\"android.permission.WRITE_EXTERNAL_STORAGE\" /><uses-permission android:name=\"android.permission.INTERNET\"/>";
	
	public static final String ACTIVITY_TAG_START_TEMPLATE="<activity android:name=\"%s\">";
	public static final String ACTIVITY_TAG_END="</activity>";
	

}
