package com.ucoltis.library.Spring.Controllers;


import com.ucoltis.library.Spring.Models.Book;
import com.ucoltis.library.Spring.Services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) throws Exception {
        Book bookSave = bookServiceImpl.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookSave);
    }
    @GetMapping("/list/{page}")
    public ResponseEntity<Page<Book>> listBooks(Pageable pageable) {
        Page<Book> listBooks = bookServiceImpl.getBooks(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listBooks);
    }
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) throws Exception {
        Optional<Book> bookFind = bookServiceImpl.getBookById(book.getId());
        if (bookFind.isPresent()) {
            bookServiceImpl.save(book);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        bookServiceImpl.delete(id);
    }

    @GetMapping("/listBook/{title}")
    public ResponseEntity<?> searchTitle(@PathVariable String title) throws Exception {
        try {
            List<?> listSearchBooks = bookServiceImpl.findByTitleContaining(title);
            return ResponseEntity.status(HttpStatus.OK).body(listSearchBooks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(( "{'error':" + e.getMessage() + "'}"));
        }
    }

}
