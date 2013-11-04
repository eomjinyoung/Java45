package net.bitacademy.java45.controls;

import java.util.Map;

import net.bitacademy.java45.dao.BooksDao;
import net.bitacademy.java45.vo.Book;

public class BookUpdateControl01 implements Action {
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		BooksDao booksDao = new BooksDao();
		
		if (model.get("title") == null) {
			Book book = booksDao.selectOne(
					Integer.parseInt( 
							((String[])model.get("id"))[0] ) );
			
			model.put("book", book);
			
			return "/book/BookUpdateForm.jsp";
		} else {
			Book book = new Book()
				.setId(Integer.parseInt(
						((String[])model.get("id"))[0] ))
				.setTitle(((String[])model.get("title"))[0])
				.setAuthor(((String[])model.get("author"))[0])
				.setPrice(Float.parseFloat(
						((String[])model.get("price"))[0]))
				.setQty(Integer.parseInt(
						((String[])model.get("qty"))[0]));
			booksDao.update(book);
			return "redirect:detail.do?id=" + book.getId();
		}
	}
}









