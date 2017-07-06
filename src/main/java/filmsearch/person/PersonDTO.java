package filmsearch.person;

import filmsearch.film.FilmDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Stas on 26.11.2015.
 */
@Builder
public class PersonDTO {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String occupation;
    @Getter
    @Setter
    private String photo;
    @Getter
    @Setter
    private String bio;
    @Getter
    @Setter
    private List<FilmDTO> filmDTOs;
}
