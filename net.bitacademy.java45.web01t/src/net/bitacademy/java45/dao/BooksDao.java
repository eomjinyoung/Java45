package net.bitacademy.java45.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java45.vo.Book;

public class BooksDao {

	public List<Book> selectList(String[] keywords) throws Exception {
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
	        
	        while(rset.next()) {
	            list.add(new Book()
	    			.setId(rset.getInt("id"))
	    			.setTitle(rset.getString("title"))
	    			.setAuthor(rset.getString("author"))
	    			.setPrice(rset.getFloat("price")));
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
	        
	        if (rset.next()) {
	            return new Book()
	            			.setId(rset.getInt("id"))
	            			.setTitle(rset.getString("title"))
	            			.setAuthor(rset.getString("author"))
	            			.setPrice(rset.getFloat("price"))
	    	    			.setQty(rset.getInt("qty"));
	        }
	        return null;
	        
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if (rset != null) rset.close();} catch(Exception e) {}
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
	        try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}

	/*
	 * PreparedStatement 이점
	 * 1) 반복 실행 시 SQL문을 한번만 컴파일 하면 되기 때문에 속도 빠르다.
	 * 2) 코드 관리가 쉽다.
	 * 3) 바이너리 데이터 입력 가능!
	 */
	public void insert(Book book) throws Exception {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost/ebookshop", "root", "1234");  
	        stmt = conn.prepareStatement(
	        		"INSERT INTO books(title,author,price,qty)"
	        		+ " VALUES(?,?,?,?)");
	        stmt.setString(1, book.getTitle());
	        stmt.setString(2, book.getAuthor());
	        stmt.setFloat(3, book.getPrice());
	        stmt.setInt(4, book.getQty());
	        stmt.executeUpdate();
	        
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
	        try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		
	}
}







