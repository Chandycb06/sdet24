package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Demo_selectQuery {
public static void main(String[] args)throws Throwable {
	Connection con=null;
	try{
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
	Statement stat = con.createStatement();
	ResultSet set = stat.executeQuery("select * from student");
	while(set.next()){
		System.out.println(set.getInt(1) +" \t "+ set.getString(2) +" \t "+ set.getString(3) +" \t "+ set.getString(4));
	}
	}catch(Exception e){
		System.out.println("table/student doesn't exist");
	}finally{
		con.close();
	}
}
}
