package net.bitacademy.java45.controls;

import java.util.Map;

import net.bitacademy.java45.dao.BooksDao;
import net.bitacademy.java45.vo.Book;

public class BookDetailControl implements Action {
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		Book book = new BooksDao().selectOne(
				Integer.parseInt(((String[])model.get("id"))[0]) );
		
		model.put("book", book);
		
		return "/book/BookDetail.jsp";
	}
}















