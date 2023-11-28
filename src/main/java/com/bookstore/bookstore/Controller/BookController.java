package com.bookstore.bookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.service.BookService;


@RestController
public class BookController {
	
private BookService bookService;
	
	@Autowired
	public BookController(BookService theBookService) {
		bookService = theBookService;
	}
	
	@GetMapping("/hello")
	public String test() {
		return "Hello World!";
	}
	

	
	// expose "/books" and return list of employees
	@GetMapping("/books")
	public List<Book> findAll() {
		return bookService.findAll();
	}

	// add mapping for GET /books/{bookId}
	
	@GetMapping("/books/{bookId}")
	public Book getEmployee(@PathVariable int employeeId) {
		
		Book theEmployee = bookService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found!!!!!! - " + employeeId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /books - add new employee
	
	@PostMapping("/books")
	public Book addEmployee(@RequestBody Book theBook) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theBook.setId(0L);
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book theBook) {
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/books/{bookId}")
	public String deleteEmployee(@PathVariable int bookId) {
		
		Book tempBook = bookService.findById(bookId);
		
		// throw exception if null
		
		if (tempBook == null) {
			throw new RuntimeException("Employee id not found - " + bookId);
		}
		
		bookService.deleteById(bookId);
		
		return "Deleted employee id - " + bookId;
	}

}
