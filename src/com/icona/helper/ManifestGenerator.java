package com.icona.helper;

import java.util.ArrayList;

import com.icona.tree.nodes.Identifier;

/**
 * AndroidManifest.xml creator
 * 
 * The Activity found during parsing will be added here and at the end the android manifest will
 * be generated
 *
 */
public class ManifestGenerator {

	private static ArrayList<String> activityNames;
	static{
		activityNames=new ArrayList<String>();
	}
	
	public static void addActivity(String packageName,Identifier name){
		activityNames.add(packageName+"."+name.getName());
	}
	
	public static void addActivity(String name){
		activityNames.add(name);
	}
	/**
	 * Generates the Android Manifest using the TAGS in ManifestGeneratorMetaData and the Activity name it has
	 * @return The generated AndroidManifest.xml XML as a String
	 */
	public static String getGeneratedManifestFile(){
		CodeStringBuilder cb=new CodeStringBuilder();
		cb.append(ManifestGeneratorMetaData.XML_TAG);
		cb.append(ManifestGeneratorMetaData.MANIFEST_TAG_START);
			
			cb.append(ManifestGeneratorMetaData.USES_SDK_TAG);
			cb.append(ManifestGeneratorMetaData.APPLICATION_TAG_START);
				
				for(int i=0;i<activityNames.size();i++){
					String activity_tag_start=String.format(ManifestGeneratorMetaData.ACTIVITY_TAG_START_TEMPLATE, activityNames.get(i));
					cb.append(activity_tag_start);
					cb.append(ManifestGeneratorMetaData.ACTIVITY_TAG_END);
				}
				
			cb.append(ManifestGeneratorMetaData.APPLICATION_TAG_END);
			cb.append(ManifestGeneratorMetaData.PERMISSION_TAGS);
		
		cb.append(ManifestGeneratorMetaData.MANIFEST_TAG_END);
		
		return cb.toString();
	}
}
