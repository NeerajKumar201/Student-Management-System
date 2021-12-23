package com.user.details;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class db {
	
	public static Connection getConnection() {
	    String url = "jdbc:mysql://localhost/Java";
		String user = "xxxxx"; // In the place of xxxxx give the user name of mysql 
		String password = "yyyyy"; // In the place of yyyyy give the password of mysql.
		
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void insert(User u){
		
		try {
		Connection con = getConnection();
		PreparedStatement sta = con.prepareStatement("insert into details (name,email,phone)values(?,?,?)");
		sta.setString(1,u.getName());
		sta.setString(2,u.getEmail());
		sta.setLong(3,u.getNumber());
	    sta.executeUpdate(); 
	    sta.close();
	    con.close();	
					
	}catch(Exception e){
		e.printStackTrace();
		
		}
	}
	
	
	public static List<User> show() {
		
		List<User> list = new ArrayList<User>();
		
		try {
		Connection con = getConnection();
		PreparedStatement sta = con.prepareStatement("Select * from details");
		ResultSet res = sta.executeQuery();
		
		while(res.next()) {
			User u = new User();
			u.setId(res.getInt(1));
			u.setName(res.getString(2));
			u.setEmail(res.getString(3));
			u.setNumber(res.getLong(4));
			list.add(u);
		}
		con.close();		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
}
	
	public static String delete(int id) {
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement sta = con.prepareStatement("delete from details where sno = ?");
			sta.setInt(1,id);
			sta.execute();
			return "Success";
		}catch(Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		
	}
}




