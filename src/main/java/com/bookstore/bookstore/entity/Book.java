package com.bookstore.bookstore.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "book_title")
    private String title;
	
	@Column(name="book_author")
    private String author;
	
	@Column(name="book_isbn")
    private String ISBN;
	
	@Column(name="published_date")
    private LocalDate publishedDate;
	
	@Column(name="book_genre")
    private String genre;

}
