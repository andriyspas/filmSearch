package filmsearch.film;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmGenreSearchDTO {

    private String genreName;
    private int page;
    private int size;
}
