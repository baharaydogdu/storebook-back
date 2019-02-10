package com.pluralsight.storebook.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pluralsight.storebook.model.Book;
import com.pluralsight.storebook.repository.BookRepository;

@Path("/books")
public class BookEndpoint {
	
	@Inject
	private BookRepository bookRepository;
	
	public Book getBook(long id) {
		return bookRepository.find(id);
	}
	
	public Book create(Book book) {
		return bookRepository.create(book);
	}
	
	public void deleteBook(long id) {
		bookRepository.delete(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks() {
		List<Book> books = bookRepository.findAll();
		if(books.size() == 0)
			return Response.noContent().build();
		return Response.ok(books).build();
	}
	
	public long countBooks() {
		return bookRepository.countAll();
	}
	
	

}
