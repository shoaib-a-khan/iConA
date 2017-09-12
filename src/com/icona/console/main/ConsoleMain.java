package com.icona.console.main;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.icona.antlr.main.ObjectiveCLexer;
import com.icona.antlr.main.ObjectiveCParser;
import com.icona.gui.ConverterApp;
import com.icona.helper.APIMappingTable;
import com.icona.helper.FileModel;
import com.icona.helper.SymbolTable;
import com.icona.tree.nodes.BasicModifier;
import com.icona.tree.nodes.ClassInterface;
import com.icona.tree.nodes.Expression.PrimaryExpression;
import com.icona.tree.nodes.Function;
import com.icona.tree.nodes.GenericRef.RefType;
import com.icona.tree.nodes.Identifier;
import com.icona.tree.nodes.IdentifierType;
import com.icona.tree.nodes.PackageDef;
import com.icona.tree.nodes.Statement.CompoundStatement;
import com.icona.tree.nodes.Statement.JumpStatement;
import com.icona.tree.nodes.Statement.JumpStatement.JumpType;
import com.icona.tree.nodes.Statement.StatementList;
import com.icona.tree.nodes.Type.DataType;

public class ConsoleMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static class ConversionObjects{
		public static final HashMap mapping = new HashMap();
		static PackageDef packageDef = null;
		static String packagePaths = "";
		public static Multimap fileIndex = HashMultimap.create();
		
		public static void resetFileIndex(){
			fileIndex = HashMultimap.create();
		}

		public static void createFileIndex(File f,
				boolean doRecurse) throws Exception {
			// If this is a directory, walk each file/dir in that directory
			String fileExtension = f.getName().substring(f.getName().lastIndexOf('.') + 1, f.getName().length());
			
			if (f.isDirectory()) {

				String files[] = f.list();
				for (int i = 0; i < files.length; i++) {

					File next = new File(f, files[i]);

					if (doRecurse || !next.isDirectory())
						createFileIndex(next, doRecurse);
				}
			}

			// otherwise, if this is a c file, parse it!
			else if ( fileExtension.equals("h") || fileExtension.equals("mm") || fileExtension.equals("m")){ 
	
				fileIndex.put(fileExtension, new FileModel(f, packageDef));
			}
		}
  
      // Here's where we do the real work...
       public static void parseFile(Collection files, File src)
                               throws Exception {
      	//  System.out.println("in folder:"+file.getParent());

   		for (int i=0; i<files.toArray().length;i++){
   			
	   				File file = ((FileModel)files.toArray()[i]).getFile();
			   		//PackageDef package_= ((FileModel)files.toArray()[i]).getPackage();

	   				String tempName = (file.getParent().replace(src.getAbsolutePath(), "").trim().replaceFirst("\\W", "").replaceAll( "\\W", ".")).trim();
			   		System.out.println("src:" + src.getAbsolutePath() +
			   				" parent:"+file.getParent() + " tempName:" +tempName +";"
			   				);
			   		
			   		PackageDef package_ = (PackageDef) SymbolTable.getInstance().getObject(tempName, IdentifierType.PACKAGE);
			   		
			   		if(package_!=null){
			   			SymbolTable.getInstance().setCurrentPackage(package_);	
			   		}
			   		else{
			   			package_ = new PackageDef(null, IdentifierType.PACKAGE, -1);  
			   			package_.setFile(file);
			   			package_.addPackageName(tempName);
			   			SymbolTable.getInstance().addObject(tempName, package_);
			   			SymbolTable.getInstance().setCurrentPackage(package_);	
			   		}
			 
			   		
			   		SymbolTable.getInstance().setCurrentFile(file);
	   				//SymbolTable.getInstance().setCurrentPackage(package_);
			    	
	   				CharStream input = new ANTLRFileStream(file.getAbsolutePath());
			   		ObjectiveCLexer lex= new ObjectiveCLexer(input);
			   		CommonTokenStream tokens = new CommonTokenStream(lex);
			   		ObjectiveCParser parser = new ObjectiveCParser(tokens);
			   		
			   		parser.translation_unit();             
       }
	}
 }
	
	private static void test_something(){
		ClassInterface classInterface=new ClassInterface(null, -1);
		classInterface.setClassName(new Identifier("HelloWorld"));
		Function f=new Function(null,-1);
		f.setIdentifier(new Identifier("alloc"));
		CompoundStatement statement=new CompoundStatement(null, -1);
		StatementList list=new StatementList(null, -1);
		statement.setStatement(list);
		JumpStatement js=new JumpStatement(null, -1, JumpType.RETURN);
		PrimaryExpression pe=new PrimaryExpression(null, -1, "new HelloWorld()", RefType.IDENTIFIER);
		js.setExpression(pe);
		list.addStatement(js);
		DataType dt=new DataType.ClassType(new Identifier("HelloWorld"));
		js.setParent(f);
		
		f.setCompoundStatement(statement);
		f.setDataType(dt);
		BasicModifier bm=new BasicModifier(null, BasicModifier.STATIC);
		f.setModifier(bm);
		
		classInterface.addFunction(f);
		
		
		System.err.println(classInterface.toString());
		
	}
	
	
	public static void main(String[] args){
		

		com.icona.gui.ConverterApp.launch(ConverterApp.class, args); //Launch GUI - have it commented if you don't need conversion via gui
		
		//ApiMap map = new ApiMap();
		//map.fillMap();
		//map.createDb(); //run if the manual DB creation via mapping.sql aint working
 	
		if(APIMappingTable.populateFromDatabase()==false)
			System.err.println("Error populating database");
		else
			System.out.println("Mappings populated from database");
		
		File file = new File("/Users/zohaibrauf/Desktop/FYPDemo Input/In2 copy");  //source folder path
			
	  /*try {
			ConsoleMain.ConversionObjects.createFileIndex(file, true);
		
			Collection headerFiles= (Collection)ConsoleMain.ConversionObjects.fileIndex.get("h");
		
			ConsoleMain.ConversionObjects.parseFile(headerFiles, file);
	
			Collection mFiles= (Collection)ConsoleMain.ConversionObjects.fileIndex.get("m");
			
			ConsoleMain.ConversionObjects.parseFile(mFiles, file);
			
			Collection mmFiles= (Collection)ConsoleMain.ConversionObjects.fileIndex.get("mm");
			
			ConsoleMain.ConversionObjects.parseFile(mmFiles, file);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
				
		System.out.println("************Raw Symbol Table**************************************\n");
	//	symbolTable.printRaw();
		System.out.println("************Formulated Symbol Table******************************\n");
		SymbolTable.getInstance().printFormulated();
		System.out.println("***************************************************************\n");
	
  }
}
