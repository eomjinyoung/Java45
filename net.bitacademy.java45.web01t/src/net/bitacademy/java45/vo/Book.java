package net.bitacademy.java45.vo;

import java.io.Serializable;

public class Book implements Serializable {
	// Serialize된 데이터의 버전 명시
	private static final long serialVersionUID = 1L;
	
	protected int 		id;
	protected String 	title;
	protected String 	author;
	protected float 	price;
	protected int 		qty;
	
	public int getId() {
		return id;
	}
	public Book setId(int id) {
		this.id = id;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Book setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getAuthor() {
		return author;
	}
	public Book setAuthor(String author) {
		this.author = author;
		return this;
	}
	public float getPrice() {
		return price;
	}
	public Book setPrice(float price) {
		this.price = price;
		return this;
	}
	public int getQty() {
		return qty;
	}
	public Book setQty(int qty) {
		this.qty = qty;
		return this;
	}
}





