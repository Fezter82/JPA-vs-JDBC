package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connect to Database
 */

public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://192.168.99.100:5432/jee";    
    public static final String USER = "jee_user";
    public static final String PASS = "jee_password";
    

    public static Connection getConnection() {
    	
    	try {
    		Class.forName("org.postgresql.Driver"); //register driver
    		}
    		catch(ClassNotFoundException ex) {
    		   System.out.println("Error: unable to load driver class!");
    		   System.exit(1);
    		}
    	 	
      try {
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
}