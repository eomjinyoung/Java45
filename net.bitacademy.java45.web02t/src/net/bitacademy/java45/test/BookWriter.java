package net.bitacademy.java45.test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import net.bitacademy.java45.vo.Book;

public class BookWriter {

	public static void main(String[] args) throws Exception {
		Book b = new Book();
		b.setId(1);
		b.setTitle("test..");
		b.setAuthor("홍길동");
		b.setPrice(200.3f);
		b.setQty(50);
		
		FileOutputStream out1 = new FileOutputStream("pool.dat");
		BufferedOutputStream out2 = new BufferedOutputStream(out1);
		ObjectOutputStream out = new ObjectOutputStream(out2);
		
		out.writeObject(b);
		
		out.close();
		out2.close();
		out1.close();
		

	}

}








