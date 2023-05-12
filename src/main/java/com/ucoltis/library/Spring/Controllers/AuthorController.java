
package com.ucoltis.library.Spring.Controllers;

import com.ucoltis.library.Spring.Models.Author;
import com.ucoltis.library.Spring.Models.Book;
import com.ucoltis.library.Spring.Services.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alex Delgado
 */
@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Author> saveAuthor(@RequestBody  Author author) {
        Author authorSave = authorServiceImpl.save(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorSave);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Author>> getAuthors() {
        List<Author> authors = authorServiceImpl.getAuthors();
        if (authors.isEmpty()) {
            System.out.println("La lista esta vacia");
        }
        return ResponseEntity.status(HttpStatus.OK).body(authors);
    }
    @PutMapping("/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        Optional<Author> bookFind = authorServiceImpl.getAuthorById(author.getId());
        if (bookFind.isPresent()) {
            authorServiceImpl.save(author);
            return ResponseEntity.status(HttpStatus.CREATED).body(author);
        } else {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        authorServiceImpl.delete(id);
    }

}
