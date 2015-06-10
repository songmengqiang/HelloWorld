package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String url="jdbc:mysql://localhost:3306/uml_cs";
	private static String name="root";
	private static String password="smqoeiang";
	private static boolean addDriverFlag=false; 
private static void addDriver(){
	/* 1.¼ÓÔØÇý¶¯ */
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static Connection getConnection(){
	if(!DBUtil.addDriverFlag){
		addDriver();
		addDriverFlag=true;
	}
	try {
		return DriverManager.getConnection(url, name, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
} 
public static void main(String[] args) {
	System.out.println("fdsf");
//	getConnection();
}
}
