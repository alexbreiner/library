package com.ucoltis.library.Spring.Services;

import com.ucoltis.library.Spring.Models.Book;
import com.ucoltis.library.Spring.Repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public Book save(Book book) throws Exception {
        try {
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
    @Override
    @Transactional
    public void delete(int id) throws Exception {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Optional<Book> getBookById(int id) throws Exception {
        try {
            return bookRepository.findById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Book> findByTitleContaining(String title) throws Exception {
        try {
            return bookRepository.findByTitleContaining(title);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Book> searchTitleBook(String title) throws Exception {
        try {
            return bookRepository.searchTitle(title);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
