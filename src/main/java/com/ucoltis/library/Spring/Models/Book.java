package com.ucoltis.library.Spring.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Alex Delgado
 */
@Entity
@Data
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @NotNull
    @NotBlank
    private String title;
    private String description;
    private String category;
    private Double price;
    private String isbn;
    private int pages;
    private LocalDate publication_date;

    //Create object for relation with class Author.
    @ManyToOne
    @JoinColumn(name = "id_author")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Author author;
}
