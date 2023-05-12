package com.ucoltis.library.Spring.Repositories;

import com.ucoltis.library.Spring.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Alex Delgado
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContaining(String title);
    @Query(value = "SELECT book.* FROM book INNER JOIN author ON author.id=book.id_author WHERE title like %?1%", nativeQuery = true)
    List<Book> searchTitle(String title);

}
