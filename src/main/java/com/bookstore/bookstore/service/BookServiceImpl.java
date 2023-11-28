package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.Dao.BookRepository;
import com.bookstore.bookstore.entity.Book;

@Service
public class BookServiceImpl implements BookService {

private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository theBookRepository) {
		bookRepository = theBookRepository;
	}
	
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(long theId) {
		Optional<Book> result = bookRepository.findById(theId);
		
		Book theBook = null;
		
		if (result.isPresent()) {
			theBook = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find book id - " + theId);
		}
		
		return theBook;
	}
	
	@Override
	public void save(Book theBook) {
		bookRepository.save(theBook);
	}

	@Override
	public void deleteById(long theId) {
		bookRepository.deleteById(theId);
	}

	

}
