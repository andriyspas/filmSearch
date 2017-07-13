package filmsearch.person;

import filmsearch.film.Film;
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
public class Person {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    @Column
    private String name;
    @Getter
    @Setter
    @Column
    private double popularity;
    @Getter
    @Setter
    @Column
    private int theMovieDbId;
    @Getter
    @Setter
    @Column(length = 3000)
    private String photo;
    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Film> filmList;
}
