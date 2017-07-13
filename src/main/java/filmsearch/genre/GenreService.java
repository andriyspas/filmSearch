package filmsearch.genre;

import filmsearch.externalsearch.ExternalSearchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Stas on 25.11.2015.
 */
@Component
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ExternalSearchService searchService;

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public void deleteAllGenres(){
        genreRepository.deleteAll();
    }

    public void fillGenres(){
        List<Genre> existingGenres = genreRepository.findAll();
        List<Genre> externalGenres = searchService.getGenres();
        externalGenres.forEach(genre -> {
           if(existingGenres.stream().filter(x-> x.getName().equals(genre.getName())).collect(Collectors.toList()).isEmpty()){
               genreRepository.save(genre);
           }
        });
    }
}
