package com.ritam.service;

import java.util.List;

import com.ritam.entity.MyBookList;

public interface IMyBookListService {
	
	public void saveMyBooks(MyBookList book);
	
	public List<MyBookList> getAllMyBooks();
	
	public void deleteById(int id);
}
