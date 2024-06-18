package domain;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns =  @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    public Book() {
    }

    public Book(String title, String lastName, Set<Author> authors) {
        this.title = title;
        this.lastName = lastName;
        this.authors = authors;
    }

}
