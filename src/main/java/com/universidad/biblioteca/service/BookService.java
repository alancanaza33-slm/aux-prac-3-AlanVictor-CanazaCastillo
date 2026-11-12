package com.universidad.biblioteca.service;

import com.universidad.biblioteca.dto.BookDto;
import com.universidad.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final List<Book> bookList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Book> findAll() {
        return bookList;
    }

    public Optional<Book> findById(Long id) {
        return bookList.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public Book save(BookDto bookDto) {
        Book book = new Book(
            counter.getAndIncrement(),
            bookDto.getTitle(),
            bookDto.getAuthor(),
            bookDto.getIsbn(),
            bookDto.getPublicationYear(),
            bookDto.getCategory(),
            bookDto.getAvailable()
        );
        bookList.add(book);
        return book;
    }

    public Optional<Book> update(Long id, BookDto bookDto) {
        Optional<Book> existingBookOpt = findById(id);
        if (existingBookOpt.isPresent()) {
            Book book = existingBookOpt.get();
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setIsbn(bookDto.getIsbn());
            book.setPublicationYear(bookDto.getPublicationYear());
            book.setCategory(bookDto.getCategory());
            book.setAvailable(bookDto.getAvailable());
            return Optional.of(book);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        return bookList.removeIf(b -> b.getId().equals(id));
    }
}