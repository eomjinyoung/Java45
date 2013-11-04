package net.bitacademy.java45.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java45.controls.BookAddControl;
import net.bitacademy.java45.controls.BookDeleteControl;
import net.bitacademy.java45.controls.BookDetailControl;
import net.bitacademy.java45.controls.BookListControl;
import net.bitacademy.java45.controls.BookUpdateControl;
import net.bitacademy.java45.dao.BooksDao;
import net.bitacademy.java45.utils.ConnectionPool;

public class ContextLoaderListener implements ServletContextListener {
	ConnectionPool connectionPool;
	
	/*
	 * - 웹 애플리케이션이 종료되기 직적에 호출됨
	 * - 자원 해제와 같은 마무리 작업
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed()...");
		connectionPool.closeAll();
	}

	/*
	 * - 웹 애플리케이션이 시작될 때 호출됨
	 * - 웹 애플리케이션을 수행하는데 필요한 자원 준비
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized()...");
		
		ServletContext ctx = event.getServletContext();
		
		//0. Dao 준비
		connectionPool = new ConnectionPool(
				"com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost/ebookshop",
				"root",
				"1234");
		
		BooksDao booksDao = new BooksDao();
		booksDao.setConnectionPool(connectionPool);
		
		//1. 페이지 컨트롤러 준비
		BookListControl bookListControl = new BookListControl();
		bookListControl.setBooksDao(booksDao);
		
		BookAddControl bookAddControl = new BookAddControl();
		bookAddControl.setBooksDao(booksDao);
		
		BookDetailControl bookDetailControl = new BookDetailControl();
		bookDetailControl.setBooksDao(booksDao);
		
		BookUpdateControl bookUpdateControl = new BookUpdateControl();
		bookUpdateControl.setBooksDao(booksDao);
		
		BookDeleteControl bookDeleteControl = new BookDeleteControl();
		bookDeleteControl.setBooksDao(booksDao);
		
		ctx.setAttribute("/book/list.do", bookListControl);
		ctx.setAttribute("/book/add.do", bookAddControl);
		ctx.setAttribute("/book/detail.do", bookDetailControl);
		ctx.setAttribute("/book/update.do", bookUpdateControl);
		ctx.setAttribute("/book/delete.do", bookDeleteControl);
	}

}













