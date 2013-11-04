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

@WebServlet("/book/update")
@SuppressWarnings("serial")
public class BookUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BooksDao booksDao = new BooksDao();
		try {
			Book book = booksDao.selectOne(
					Integer.parseInt(request.getParameter("id")) );
			
			request.setAttribute("book", book);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/book/BookUpdateForm.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Book book = new Book()
			.setId(Integer.parseInt(request.getParameter("id")))
			.setTitle(request.getParameter("title"))
			.setAuthor(request.getParameter("author"))
			.setPrice(Float.parseFloat(request.getParameter("price")))
			.setQty(Integer.parseInt(request.getParameter("qty")));
		
		BooksDao booksDao = new BooksDao();
		try {
			booksDao.update(book);
			
			response.sendRedirect("detail?id=" + book.getId());
		} catch (Exception e) {
			request.setAttribute("error", e);
			RequestDispatcher rd = 
					request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}
}









