package filmsearch.search;

import filmsearch.film.FilmDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Stanislav on 12/01/2016.
 */
public class YearSearchDTO {
    @Getter
    @Setter
    private int year;

    @Getter
    @Setter
    private List<FilmDTO> filmDTOs;

    @Getter
    @Setter
    private double averageRating;


}
