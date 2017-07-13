package filmsearch.externalsearch.dto.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import filmsearch.externalsearch.dto.film.FilmSearchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonSearchDTO {

    @JsonProperty("popularity")
    private double popularity;

    @JsonProperty("id")
    private int theMovieDbId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("profile_path")
    private String photo;

    @JsonProperty("known_for")
    private List<FilmSearchDTO> filmList;
}
