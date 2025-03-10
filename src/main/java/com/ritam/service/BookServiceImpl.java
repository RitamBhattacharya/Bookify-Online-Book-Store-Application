package com.ritam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritam.entity.Book;
import com.ritam.repository.BookRepository;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private BookRepository repo;
	
	@Override
	public void saveBook(Book b) {
		repo.save(b);
		
	}
	
	@Override
	public Book getBookById(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public List<Book> getAllBooks() {
		return repo.findAll();
	}
	
	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
