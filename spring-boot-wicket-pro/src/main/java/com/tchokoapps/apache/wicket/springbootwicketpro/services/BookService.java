package com.tchokoapps.apache.wicket.springbootwicketpro.services;

import com.tchokoapps.apache.wicket.springbootwicketpro.entities.Book;
import com.tchokoapps.apache.wicket.springbootwicketpro.repositories.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Set<Book> getBooks() {
        HashSet<Book> books = new HashSet<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            throw new RuntimeException(String.format("Book with id=%s not found", id));
        }
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
