package net.bitacademy.java45.servlets.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java45.dao.BooksDao;
import net.bitacademy.java45.vo.Book;

@WebServlet("/book/detail")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BooksDao booksDao = new BooksDao();
		try {
			Book book = booksDao.selectOne(
					Integer.parseInt(request.getParameter("id")) );
			
			//출력은 JSP에게 맡긴다.
			request.setAttribute("book", book);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/book/BookDetail.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}















