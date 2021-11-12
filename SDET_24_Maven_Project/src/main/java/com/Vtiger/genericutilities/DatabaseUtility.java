package com.Vtiger.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Muniraju
 *
 */

public class DatabaseUtility {
	Driver driver;
    Connection con;
    ResultSet result;
    Statement stat;
    FileUtility fui=new FileUtility();
    
    /**
     * Used to establish connection with DataBase
     */
    public void connectToDB()
    {
    	try{
    	driver=new Driver();
    	DriverManager.registerDriver(driver);
    	con=DriverManager.getConnection(fui.getPropertyKeyValue("dburl"),fui.getPropertyKeyValue("dbusername"),fui.getPropertyKeyValue("dbpassword"));
           }catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Used to close connection with database
     * @throws Exception
     */
    public void closeDB() throws Exception
    {
    	con.close();
    }
    
    /**
     * Used to execute select query
     * @param query
     * @return
     * @throws Exception
     */
    public ResultSet executeQuerry(String query) throws Exception
    {
    	try{
    	    stat = con.createStatement();
        	result=stat.executeQuery(query);
    	   }catch(Exception e){
    		   e.printStackTrace();
    	   }
    	return result;
    }
    
    /**
     * Used to execute Non select query
     * @param query
     * @throws SQLException
     */
    public void executeUpdate(String query) throws SQLException
    {   
    	try{
    	stat=con.createStatement();
    	stat.executeUpdate(query);
    	System.out.println("Query updated");
    	   }catch(Exception e){
    		   e.printStackTrace();
    	   }
    }
}
