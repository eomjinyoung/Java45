package net.bitacademy.java45.controls;

import java.util.List;
import java.util.Map;

import net.bitacademy.java45.dao.BooksDao;
import net.bitacademy.java45.vo.Book;

public class BookListControl implements Action {

	@Override
	public String execute(Map<String,Object> model) throws Exception {
		BooksDao booksDao = new BooksDao();
		List<Book> list = booksDao.selectList(
				(String[])model.get("author"));
		
		model.put("list", list);
		
		return "/book/BookList.jsp";
	}
}







