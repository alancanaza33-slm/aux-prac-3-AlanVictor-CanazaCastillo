package com.universidad.biblioteca.service;

import com.universidad.biblioteca.dto.BookDto;
import com.universidad.biblioteca.model.Book;
import com.universidad.biblioteca.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(BookDto bookDto) {
        Book book = new Book(
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getIsbn(),
                bookDto.getPublicationYear(),
                bookDto.getCategory(),
                bookDto.getAvailable());
        return bookRepository.save(book);
    }

    public Optional<Book> update(Long id, BookDto bookDto) {
        Optional<Book> existingBookOpt = bookRepository.findById(id);
        if (existingBookOpt.isPresent()) {
            Book book = existingBookOpt.get();
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setIsbn(bookDto.getIsbn());
            book.setPublicationYear(bookDto.getPublicationYear());
            book.setCategory(bookDto.getCategory());
            book.setAvailable(bookDto.getAvailable());
            return Optional.of(bookRepository.save(book));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}