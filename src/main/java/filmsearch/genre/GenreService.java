package filmsearch.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
@Component
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public void deleteAllGenres(){
        genreRepository.deleteAll();
    }
}
