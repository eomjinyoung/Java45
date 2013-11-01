package net.bitacademy.java45.servlets.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java45.dao.BooksDao;

@WebServlet("/book/delete")
@SuppressWarnings("serial")
public class BookDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BooksDao booksDao = new BooksDao();
		
		try {
			booksDao.delete(id);
			
			response.sendRedirect("list");
		} catch (Exception e) {
			request.setAttribute("error", e);
			RequestDispatcher rd = 
					request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}
}
















