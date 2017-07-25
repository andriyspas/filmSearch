package filmsearch.film;

import filmsearch.genre.Genre;
import filmsearch.person.Person;
import lombok.*;

import javax.persistence.*;
import java.net.URL;
import java.util.List;


/**
 * Created by Stas on 25.11.2015.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column
    private String title;

    @Getter
    @Setter
    @Column
    private boolean rated;

    @Getter
    @Setter
    @Column
    private String released;

    @Getter
    @Setter
    @Column
    private int runtime;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Genre> genres;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Person> directors;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Person> actors;

    @Getter
    @Setter
    @Column(length = 5000)
    private String plot;

    @Getter
    @Setter
    @Column
    private String language;

    @Getter
    @Setter
    @Column
    private String country;

    @Getter
    @Setter
    @Column(length = 2000)
    private String poster;

    @Getter
    @Setter
    @Column
    private double imdbRating;

    @Getter
    @Setter
    @Column
    private int imdbVotes;

    @Getter
    @Setter
    @Column
    private String imdbID;
    
    @Getter
    @Setter
    @Column
    private int year;
}
