package com.icona.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.icona.helper.DAO.ClassDAO;
import com.icona.helper.DAO.FunctionDAO;

/**
 * Stores the data in the database
 * It takes one of the DAOs and stores the corresponding data according to the function called
 *
 */
public class DBDataStorer {
	
	static private final String CONNECTION_URI="jdbc:sqlite:/Users/zohaibrauf/Documents/workspace/ObjCFYPA/sqDB";
	
	static private String CLASS_INSERT_QUERY_WITHOUT_SUPERCLASS="INSERT INTO class(class_name,class_init_body,class_end_body,language,import) VALUES(?,?,?,?,?)";
	static private String CLASS_INSERT_QUERY_WITH_SUPERCLASS="INSERT INTO class(class_name,class_init_body,class_end_body,language,import,superclass_id) VALUES(?,?,?,?,?,?)";
	
	static private String FUNCTION_INSERT_QUERY_WITH_CLASS_ID="INSERT INTO function(function_name,return_type,return_type_function,function_init_body,class_id,) VALUE(?,?,?,?,?)";
	static private String FUNCTION_INSERT_QUERY_WITHOUT_CLASS_ID="INSERT INTO function(function_name,return_type,return_type_function,function_init_body) VALUE(?,?,?,?)";
	
	static private String FUNCTION_MAPPING_INSERT_QUERY="INSERT INTO function_mapping VALUES(?,?)";
	static private String CLASS_MAPPING_INSERT_QUERY="INSERT INTO class_mapping VALUES(?,?)";
	
	public boolean insertClass(ClassDAO dao){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}

		Connection connection = null;
		int rowAdded;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			
			PreparedStatement insert=null;
			
			if(dao.superClassId==null){
				insert=connection.prepareStatement(CLASS_INSERT_QUERY_WITHOUT_SUPERCLASS);
			}
			else{
				insert=connection.prepareStatement(CLASS_INSERT_QUERY_WITH_SUPERCLASS);
				insert.setInt(6, dao.superClassId);
			}
			
			insert.setString(1, dao.className.getName());
			insert.setString(2, dao.classInitBody);
			insert.setString(3, dao.classEndBody);
			insert.setString(4, dao.language.toString());
			insert.setString(5, dao.importName);
			
			rowAdded=insert.executeUpdate();
			
			
			
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
		if(rowAdded>=1) // Should be ==1
			return true;
		return false;

	}
	
	public boolean insertFunction(FunctionDAO dao){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}

		Connection connection = null;
		int rowAdded;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			
			PreparedStatement insert=null;
			
			if(dao.classId==null){
				insert=connection.prepareStatement(FUNCTION_INSERT_QUERY_WITHOUT_CLASS_ID);
			}
			else{
				insert=connection.prepareStatement(FUNCTION_INSERT_QUERY_WITH_CLASS_ID);
				insert.setInt(5, dao.classId);
			}
			
			insert.setString(1, dao.functionName.getName());
			insert.setString(2, dao.returnType);
			insert.setString(3, dao.returnTypeFunction);
			insert.setString(4, dao.functionInitBody);
			
			rowAdded=insert.executeUpdate();
			
			
			
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
		if(rowAdded>=1) // Should be ==1
			return true;
		return false;

	}
	
	public boolean insertFunctionMapping(Integer from,Integer to){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}

		Connection connection = null;
		int rowAdded;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			
			PreparedStatement insert=connection.prepareStatement(FUNCTION_MAPPING_INSERT_QUERY);
			
			
			insert.setInt(1, from);
			insert.setInt(2, to);
			
			rowAdded=insert.executeUpdate();
			
			
			
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
		if(rowAdded>=1) // Should be ==1
			return true;
		return false;

	}
	
	public boolean insertFunctionMapping(FunctionDAO from,FunctionDAO to){
		return insertFunctionMapping(from.id, to.id);
	}
	
	public boolean insertClassMapping(Integer from,Integer to){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}

		Connection connection = null;
		int rowAdded;
		try{

			// create a database connection
			connection = DriverManager.getConnection(CONNECTION_URI);
			
			PreparedStatement insert=connection.prepareStatement(CLASS_MAPPING_INSERT_QUERY);
			
			
			insert.setInt(1, from);
			insert.setInt(2, to);
			
			rowAdded=insert.executeUpdate();
			
			
			
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
		if(rowAdded>=1) // Should be ==1
			return true;
		return false;

	}
	
	public boolean insertClassMapping(ClassDAO from,ClassDAO to){
		return insertClassMapping(from.id, to.id);
	}
	
	
}
