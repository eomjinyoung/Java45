package net.bitacademy.java45.controls;

import java.util.Map;

import net.bitacademy.java45.dao.BooksDao;

public class BookDeleteControl implements Action {
	BooksDao booksDao;
	
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		int id = Integer.parseInt( ((String[])model.get("id"))[0] );
		booksDao.delete(id);
			
		return "redirect:list.do";
	}
}
















