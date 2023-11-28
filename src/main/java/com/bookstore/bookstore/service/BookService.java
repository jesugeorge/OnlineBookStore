package com.bookstore.bookstore.service;

import java.util.List;

import com.bookstore.bookstore.entity.Book;

public interface BookService {

	public List<Book> findAll();
	
	public Book findById(long theId);
	
	public void save(Book theBook);
	
	public void deleteById(long theId);
	
	
}
