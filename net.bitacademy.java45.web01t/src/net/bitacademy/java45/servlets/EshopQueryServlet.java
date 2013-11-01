package net.bitacademy.java45.servlets;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import net.bitacademy.java45.dao.BooksDao;
import net.bitacademy.java45.vo.Book;

public class EshopQueryServlet extends HttpServlet {  // JDK 6 and above only
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String[] authors = request.getParameterValues("author");
		if (authors == null) {
			out.println("<h2>Please go back and select an author</h2>");
			return;
		}         

		out.println("<html><head><title>Query Results</title></head><body>");
		out.println("<h2>Thank you for your query.</h2>");

		out.println("<form method='get' action='eshoporder'>");

		BooksDao booksDao = new BooksDao();
		try {
			List<Book> list = booksDao.selectList(authors);
	
			for(Book book : list) {
				out.println("<p><input type='checkbox' name='id' value="
						+ "'" + book.getId() + "' />"
						+ book.getAuthor() + ", "
						+ book.getTitle() + ", $"
						+ book.getPrice() + "</p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.println("<p><input type='submit' value='ORDER' />");
		out.println("</form>");

		out.println("</body></html>");

	}
}