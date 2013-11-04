package net.bitacademy.java45.servlets.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java45.dao.BooksDao;
import net.bitacademy.java45.vo.Book;

@WebServlet("/book/add")
@SuppressWarnings("serial")
public class BookAddServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = 
				request.getRequestDispatcher("/book/BookForm.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트에서 보내는 파라미터의 문자 인코딩 형식을 지정한다.
		request.setCharacterEncoding("UTF-8");
		Book book = new Book()
			.setTitle(request.getParameter("title"))
			.setAuthor(request.getParameter("author"))
			.setPrice(Float.parseFloat(request.getParameter("price")))
			.setQty(Integer.parseInt(request.getParameter("qty")));
		
		BooksDao booksDao = new BooksDao();
		try {
			booksDao.insert(book);
			
			// Redirect 처리
			/*
			 * Redirect는 클라이언트에게 본문을 보내지 않습니다.
			 */
			// test 출력
			PrintWriter out = response.getWriter();
			out.println("a");
			out.println("b");
			
			response.sendRedirect("list");
			
			
			
			// Refresh 처리 
			/*
			RequestDispatcher rd = 
					request.getRequestDispatcher("/book/BookAdd.jsp");
			rd.forward(request, response);
			*/
		} catch (Exception e) {
			request.setAttribute("error", e);
			RequestDispatcher rd = 
					request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}















