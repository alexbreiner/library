package com.ucoltis.library.Spring.Repositories;

import com.ucoltis.library.Spring.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex Delgado
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {}
