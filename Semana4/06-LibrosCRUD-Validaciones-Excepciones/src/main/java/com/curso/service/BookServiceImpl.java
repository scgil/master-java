package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Book;
import com.curso.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository repository;
	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Book createBook(Book book) {
		return repository.save(book);
	}

	@Override
	public Book updateBook(Long id, Book book) {
		return repository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);			
	}
}
