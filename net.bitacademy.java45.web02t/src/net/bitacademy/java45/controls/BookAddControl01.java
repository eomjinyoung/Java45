package net.bitacademy.java45.controls;

import java.util.Map;

import net.bitacademy.java45.dao.BooksDao;
import net.bitacademy.java45.vo.Book;

public class BookAddControl01 implements Action {

	@Override
	public String execute(Map<String,Object> model) throws Exception {
		if (model.get("title") == null) {
			return "/book/BookForm.jsp";
			
		} else {
			Book book = new Book()
				.setTitle( ((String[])model.get("title"))[0] )
				.setAuthor( ((String[])model.get("author"))[0] )
				.setPrice(Float.parseFloat( 
						((String[])model.get("price"))[0] ))
				.setQty(Integer.parseInt(((
						String[])model.get("qty"))[0] ));
			
			new BooksDao().insert(book);
			
			return "redirect:list.do";
		}
	}
}















