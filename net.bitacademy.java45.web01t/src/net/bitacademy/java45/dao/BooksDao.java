package net.bitacademy.java45.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java45.vo.Book;

public class BooksDao {

	public List<Book> select(String[] keywords) throws Exception {
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rset = null;
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost/ebookshop", "root", "1234");  
	        stmt = conn.createStatement();
	         
	        String sqlStr = "SELECT * FROM books WHERE";
	        if (keywords != null && keywords.length > 0) {
	        	sqlStr += " author IN (";
	        	for(int i = 0; i < keywords.length; i++) {
	        		if (i > 0) {
	        			sqlStr += ",";
	        		}
	        		sqlStr += "'" + keywords[i] + "'";
	        	}
	        	sqlStr += ") AND";
	        }
	        sqlStr += " qty > 0 ORDER BY author ASC, title ASC";
	        
	        rset = stmt.executeQuery(sqlStr);
	        
	        ArrayList<Book> list = new ArrayList<Book>();
	        Book book = null;
	        
	        while(rset.next()) {
	            book = new Book();
	            book.setId(rset.getInt("id"));
	            book.setTitle(rset.getString("title"));
	            book.setAuthor(rset.getString("author"));
	            book.setPrice(rset.getFloat("price"));
	            
	            list.add(book);
	        }
	        
	        return list;
	        
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if (rset != null) rset.close();} catch(Exception e) {}
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
	        try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}

	public Book selectOne(int id) throws Exception {
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rset = null;
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost/ebookshop", "root", "1234");  
	        stmt = conn.createStatement();
	         
	        String sqlStr = "SELECT * FROM books WHERE id=" + id;
	        
	        rset = stmt.executeQuery(sqlStr);
	        
	        Book book = null;
	        
	        if (rset.next()) {
	            book = new Book();
	            book.setId(rset.getInt("id"));
	            book.setTitle(rset.getString("title"));
	            book.setAuthor(rset.getString("author"));
	            book.setPrice(rset.getFloat("price"));
	        }
	        return book;
	        
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if (rset != null) rset.close();} catch(Exception e) {}
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
	        try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
}







