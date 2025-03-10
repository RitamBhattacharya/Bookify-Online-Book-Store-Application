package com.ritam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritam.entity.MyBookList;
import com.ritam.repository.MyBookListRepository;

@Service
public class MyBookListServiceImpl implements IMyBookListService {
	
	@Autowired
	private MyBookListRepository repo;
	
	@Override
	public void saveMyBooks(MyBookList book) {
		repo.save(book);
	}
	
	@Override
	public List<MyBookList> getAllMyBooks() {
		return repo.findAll();
	}
	
	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
