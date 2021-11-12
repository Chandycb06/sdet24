package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_nonselect {
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
		int result=stat.executeUpdate("insert into student values(6,'Anand','Karthik','Anandkarthik@gmail.com')");
		if(result==1){
			System.out.println("student is successfully created");
		}
	}catch(Exception e){
		System.err.println("student not created");
	}finally{
		//verify
				//step-5
				con.close();
				System.out.println("=============close connection=========");
	}
}
}
