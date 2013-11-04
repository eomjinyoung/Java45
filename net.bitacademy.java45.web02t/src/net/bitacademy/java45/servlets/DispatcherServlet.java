package net.bitacademy.java45.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java45.controls.Action;
import net.bitacademy.java45.controls.BookAddControl;
import net.bitacademy.java45.controls.BookDeleteControl;
import net.bitacademy.java45.controls.BookDetailControl;
import net.bitacademy.java45.controls.BookListControl;

@SuppressWarnings("serial")
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.한글 입출력 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//1. 데이터를 담을 빈 바구니를 준비한다.
		HashMap<String,Object> model = new HashMap<String,Object>();
		
		//2. 요청 파라미터 값을 바구니에 담는다.
		model.putAll(request.getParameterMap());
		
		//3. 요청을 처리할 페이지 컨트롤러를 찾아서 호출한다.
		//URL: http://localhost:9999/web02/book/list
		//1) /web02 ==> request.getContextPath()
		//2) /book/list ==> request.getServletPath()
		//3) /web02/book/list ==> request.getRequestURI();
		String requestUrl = request.getServletPath();
		String viewUrl = null;
		try {
			Action control = null;
			if (requestUrl.equals("/book/list.do")) {
				control = new BookListControl();
			} else if (requestUrl.equals("/book/detail.do")) {
				control = new BookDetailControl();
			} else if (requestUrl.equals("/book/add.do")) {
				control = new BookAddControl();
			} else if (requestUrl.equals("/book/delete.do")) {
				control = new BookDeleteControl();
			}
			
			viewUrl = control.execute(model);
			
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			}
			
			//4. 바구니에 담긴 값을 꺼내서 ServletRequest에 옮겨 싣는다.
			// - JSP는 request에서 값을 꺼내어 출력할 때 사용한다.
			for(String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
		
			//5. 컨트롤러가 리턴한 JSP로 인클루드 시킨다.
			RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
			rd.include(request, response);
			
		} catch (Exception e) {
			request.setAttribute("error", e);
			RequestDispatcher rd = 
					request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}










































