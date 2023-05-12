
package com.ucoltis.library.Spring.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.*;
import lombok.*;

/**
 *
 * @author Alex Delgado
 */
@Entity
@Data
@Table(name = "author")
public class Author implements Serializable {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private int id;
   @NotNull
   @NotBlank
   private String name;
   private String lastname;
   private String nationality;
   
   @OneToMany
   @JoinColumn(name = "id_author", referencedColumnName = "id")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private List<Book> books = new ArrayList<Book>();
}
