package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Smapleselect {
public static void main(String[] args)throws Exception {
	Connection con=null;
	try{
		//step-1 : load/register the driver for specific database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step-2: connect to db
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		
		//step-3: create/issue sql statement
		Statement stat = con.createStatement();
		
		//step-4: execute the query
		ResultSet set = stat.executeQuery("select * from student");
		while(set.next()){
			System.out.println(set.getInt(1)+ " \t " +set.getString(2)+ " \t " +set.getString(3)+ " \t " +set.getString(4));
		}
	}catch(Exception e){
		System.err.println("table/student doesn't exist");
	}finally{
		//verify
				//step-5
				con.close();
				System.out.println("=======close connection=========");
	}
}
}
