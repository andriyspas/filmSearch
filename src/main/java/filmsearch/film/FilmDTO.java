package filmsearch.film;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private int year;

    @Getter
    @Setter
    private boolean rated;

    @Getter
    @Setter
    private String released;

    @Getter
    @Setter
    private String runtime;

    @Getter
    @Setter
    private List<String> directors;

    @Getter
    @Setter
    private List<String> actors;

    @Getter
    @Setter
    private String plot;

    @Getter
    @Setter
    private String language;

    @Getter
    @Setter
    private String country;

    @Getter
    @Setter
    private List<String> genres;

    @Getter
    @Setter
    private String poster;

    @Getter
    @Setter
    private double imdbRating;

    @Getter
    @Setter
    private int imdbVotes;

    @Getter
    @Setter
    private String imdbID;

    @Getter
    @Setter
    private String type;
}
