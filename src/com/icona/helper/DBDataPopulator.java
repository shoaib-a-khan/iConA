package com.icona.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.icona.helper.DAO.ClassDAO;
import com.icona.helper.DAO.FunctionDAO;
import com.icona.helper.DAO.FunctionParamDAO;
import com.icona.helper.DAO.Language;

/**
 * Its used to get data from the database in the form of DAOs
 *
 */
public class DBDataPopulator {
	static private final String CONNECTION_URI="jdbc:sqlite:/Users/zohaibrauf/Documents/workspace/ObjCFYPA/sqDB";
	
	static private final String QUERY_GET_ALL_CLASSES="SELECT * FROM class";
	static private final String QUERY_GET_ALL_FUNCTIONS="SELECT * FROM function";
	static private final String QUERY_GET_ALL_CLASS_MAPPINGS="SELECT * FROM class_mapping";
	static private final String QUERY_GET_ALL_FUNCTION_MAPPINGS="SELECT * FROM function_mapping";
	static private final String QUERY_GET_FUNCTION_PARAMETER_FOR_FUNCTION="SELECT * FROM function_parameters_mappings WHERE function_id=? ORDER BY position ASC";
	static private final String QUERY_GET_ALL_OBJC_CLASSES="SELECT * FROM class where language='objc'";
	static private final String QUERY_GET_ALL_JAVA_CLASSES="SELECT * FROM class where language='java'";
	
	public ArrayList<ClassDAO> getAllClasses(Language a){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}

		Connection connection = null;
		ArrayList<ClassDAO> classes=null;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			String query;
			
			if(a==Language.JAVA)
				query=QUERY_GET_ALL_OBJC_CLASSES;
			else
				query=QUERY_GET_ALL_JAVA_CLASSES;
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setQueryTimeout(30);
			
			

			ResultSet rs = statement.executeQuery();
			
			classes=new ArrayList<ClassDAO>();
			
			boolean hasRows=false;
			while(rs.next())
			{
				ClassDAO dao=new ClassDAO(rs.getInt("id"), rs.getString("class_name"),rs.getInt("superclass_id"), rs.getString("class_init_body"),
						rs.getString("class_end_body"), Language.getLanguageEnum(rs.getString("language")),rs.getString("import"));
				classes.add(dao);
				hasRows=true;
			}
			
			if(!hasRows)
				classes=null;
		
		}
		catch(SQLException e){
			// if the error message is "out of memory", 
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return null;
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				// connection close failed.
				System.err.println(e);
				return null;
			}
		}
		return classes;
		
	}
	public ArrayList<FunctionParamDAO> getFunctionParameters(FunctionDAO dao){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}

		Connection connection = null;
		ArrayList<FunctionParamDAO> parameters=null;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			PreparedStatement statement=connection.prepareStatement(QUERY_GET_FUNCTION_PARAMETER_FOR_FUNCTION);
			statement.setQueryTimeout(30);
			
			statement.setInt(1, dao.id);

			ResultSet rs = statement.executeQuery();
			
			parameters=new ArrayList<FunctionParamDAO>();
			
			boolean hasRows=false;
			while(rs.next())
			{
				FunctionParamDAO paramDao=new FunctionParamDAO(dao.id, rs.getString("type"), rs.getString("name"), rs.getInt("position"));
				parameters.add(paramDao);
				hasRows=true;
			}
			
			if(!hasRows)
				parameters=null;
		
		}
		catch(SQLException e){
			// if the error message is "out of memory", 
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return null;
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				// connection close failed.
				System.err.println(e);
				return null;
			}
		}
		return parameters;
	}
	public boolean populateAllDB(){
		if(populateAllClasses()==false){
			System.err.println("Error populating the classes from Database");
			return false;
		}
		if(populateAllFunctions()==false){
			System.err.println("Error populating the functions from Database");
			return false;
		}
		if(populateAllClassMappings()==false){
			System.err.println("Error populating the class mappings from Database");
			return false;
		}
		if(populateAllFunctionMappings()==false){
			System.err.println("Error populating the function mappings from Database");
			return false;
		}
		
		return true;
	}
	
	private boolean populateAllClasses(){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}

		Connection connection = null;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			ResultSet rs = statement.executeQuery(QUERY_GET_ALL_CLASSES);
			while(rs.next())
			{
				ClassDAO dao=new ClassDAO(rs.getInt("id"), rs.getString("class_name"),rs.getInt("superclass_id"), rs.getString("class_init_body"),
						rs.getString("class_end_body"), Language.getLanguageEnum(rs.getString("language")),rs.getString("import"));
				
				
				APIMappingTable.addClassData(dao);
				
			}
			APIMappingTable.resolveSuperclassLinks();
		}
		catch(SQLException e){
			// if the error message is "out of memory", 
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				// connection close failed.
				System.err.println(e);
				return false;
			}
		}
		return true;
	}
	
	private boolean populateAllFunctions(){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
			return false;
		}

		Connection connection = null;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			ResultSet rs = statement.executeQuery(QUERY_GET_ALL_FUNCTIONS);
			while(rs.next())
			{
				FunctionDAO dao=new FunctionDAO(rs.getInt("id"), rs.getInt("class_id"), rs.getString("function_name"), rs.getInt("class_id"), 
						rs.getString("return_type"), rs.getString("return_type_function"), rs.getString("function_init_body"),rs.getString("comment"));
				dao.parameters=getFunctionParameters(dao);
				
				
				APIMappingTable.addFunctionData(dao);
				
			}
			
		}
		catch(SQLException e){
			// if the error message is "out of memory", 
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				// connection close failed.
				System.err.println(e);
				return false;
			}
		}
		return true;
	}
	
	private boolean populateAllClassMappings(){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}

		Connection connection = null;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			ResultSet rs = statement.executeQuery(QUERY_GET_ALL_CLASS_MAPPINGS);
			while(rs.next())
			{
				APIMappingTable.addClassMapping(rs.getInt("class_id_from"), rs.getInt("class_id_to"));
				
			}
			
		}
		catch(SQLException e){
			// if the error message is "out of memory", 
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				// connection close failed.
				System.err.println(e);
				return false;
			}
		}
		return true;
	}
	
	private boolean populateAllFunctionMappings(){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}

		Connection connection = null;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			ResultSet rs = statement.executeQuery(QUERY_GET_ALL_FUNCTION_MAPPINGS);
			while(rs.next())
			{
				APIMappingTable.addFunctionMapping(rs.getInt("function_id_from"), rs.getInt("function_id_to"));
				
			}
			
		}
		catch(SQLException e){
			// if the error message is "out of memory", 
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				// connection close failed.
				System.err.println(e);
				return false;
			}
		}
		return true;
	}
	
	
}
