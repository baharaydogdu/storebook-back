package com.pluralsight.storebook.repository;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.*;

import com.pluralsight.storebook.model.Book;
import com.pluralsight.storebook.util.NumberGenerator;
import com.pluralsight.storebook.util.TextUtil;

@Transactional(Transactional.TxType.SUPPORTS)
public class BookRepository {
	
	@PersistenceContext(unitName = "storebookPU") //unitName comes from persistence xml
	private EntityManager em;
	
	@Inject
	private TextUtil textUtil;
	@Inject
	private NumberGenerator generator;
	
	public Book find(@NotNull long id) {
		return em.find(Book.class, id);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public Book create(@NotNull Book book) {
		book.setTitle(textUtil.sanitize(book.getTitle()));
		book.setIsbn(generator.generateNumber());
		em.persist(book);
		return book;
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void delete(@NotNull long id) {
		em.remove(em.getReference(Book.class, id));
	}
	
	public List<Book> findAll() {
		TypedQuery<Book> query = em.createQuery("select b from book b order by b.title", Book.class);
		return query.getResultList();
	}
	
	public Long countAll() {
		TypedQuery<Long> query = em.createQuery("select count(b) from book b", Long.class);
		return query.getSingleResult();
	}
	

}
