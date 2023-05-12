package com.ucoltis.library.Spring.Services;

import com.ucoltis.library.Spring.Models.Author;
import com.ucoltis.library.Spring.Models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book save(Book book) throws Exception;
    Page<Book> getBooks(Pageable pageable);
    void delete(int id) throws Exception;
    Optional<Book> getBookById(int id) throws Exception;

    List<Book> findByTitleContaining(String title) throws Exception;
    List<Book> searchTitleBook(String title) throws Exception;
}
