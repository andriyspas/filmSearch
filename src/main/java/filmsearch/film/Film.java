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

    /*@Builder
    private Film(String title, int year, boolean rated, String released, String runtime, List<Genre> genres, List<Person> directors, List<Person> actors, String plot, String language, String country, URL poster, double imdbRating, int imdbVotes, String imdbId, FilmType filmType){

    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter

    private Long id;

    @Getter
    @Setter
    @Column
    private String title;

    @Getter
    @Setter
    @Column
    private int year;

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
    private String runtime;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Genre> genre;

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
    private URL poster;

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
    private FilmType type;


}
