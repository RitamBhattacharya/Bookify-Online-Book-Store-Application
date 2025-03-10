package com.ritam.service;

import java.util.List;

import com.ritam.entity.Book;

public interface IBookService {
	
	public void saveBook(Book b);
	
	public List<Book> getAllBooks();
	
	public Book getBookById(Integer id);
	
	public void deleteById(Integer id);
}
