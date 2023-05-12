package com.ucoltis.library.Spring.Services;

import com.ucoltis.library.Spring.Models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);
    List<Author> getAuthors();
    void delete(int id);
    Optional<Author> getAuthorById(int id);
}
