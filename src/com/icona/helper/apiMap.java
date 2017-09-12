package com.icona.helper;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.icona.console.main.ConsoleMain.ConversionObjects;

/*Class to create and initialize Mapping database via code and fill in the global "mapping" hashtable */


	public class apiMap {
		
		
		
		public void fillMap(){                 //fill the hashtable "mapping" with all db entries                    
			
			
		    try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		    Connection connection = null;
		    try
		    {

		      // create a database connection
		      connection = DriverManager.getConnection("jdbc:sqlite:sqDB");
		      Statement statement = connection.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 sec.

		      ResultSet rs = statement.executeQuery("select * from map");
		      while(rs.next())
		      {
		        // read the result set
		    	//System.out.println(rs.getInt("Id"));
		    	ConversionObjects.mapping.put(rs.getString("CValue"), new DbEntry(rs.getInt("Id"),rs.getString(1),rs.getString(2),rs.getString(3)));
		      }
		    }
		    catch(SQLException e)
		    {
		      // if the error message is "out of memory", 
		      // it probably means no database file is found
		      System.err.println(e.getMessage());
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
		      }
		    }
		    
		}
	
	
      public void createDb(){
	    // load the sqlite-JDBC driver using the current class loader
	    try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:sqDB");
	    
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      
	    //  statement.executeUpdate("drop table if exists map");

	     // statement.executeUpdate("create table map (Id INTEGER PRIMARY KEY,CValue TEXT,JavaValue TEXT,Type TEXT) ");
	    //  statement.executeUpdate("insert into map (CValue,JavaValue,Type) values( 'NSArray', 'ArrayList', 'class' )" );
	    //  statement.executeUpdate("insert into person values(2, 'yui')");
	      ResultSet rs = statement.executeQuery("select * from map");
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("name = " + rs.getString(1));
	        System.out.println("id = " + rs.getString(2));
	      }
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
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
	      }
	    }
	  }
	  }