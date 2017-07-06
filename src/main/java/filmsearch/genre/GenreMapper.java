package filmsearch.genre;

import org.springframework.stereotype.Component;

/**
 * Created by Stas on 25.11.2015.
 */
@Component
public class GenreMapper {

    public GenreDTO mapToDTO(Genre genre){
        GenreDTO genreDTO = GenreDTO.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
        return genreDTO;
    }
}
