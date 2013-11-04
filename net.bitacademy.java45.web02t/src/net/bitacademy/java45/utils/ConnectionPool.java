package net.bitacademy.java45.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ConnectionPool {
	ArrayList<Connection> conlist = new ArrayList<Connection>();
	String drvier;
	String url;
	String username;
	String password;
	
	public ConnectionPool(
			String driver, String url, String username, String password) {
		this.drvier = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	
	public Connection getConnection() throws Exception {
		if (conlist.size() > 0) {
			return conlist.remove(0);
		} else {
			Class.forName(this.drvier);
	        return DriverManager.getConnection(
	            this.url, this.username, this.password);  
		}
	}
	
	public void returnConnection(Connection con) {
		conlist.add(con);
	}


	public void closeAll() {
		for(Connection con : conlist) {
			try {con.close();} catch (Exception e){}
		}
		
	}
}















