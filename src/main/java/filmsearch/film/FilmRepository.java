package filmsearch.film;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
@Component
public interface FilmRepository extends CrudRepository<Film, String> {
    Film findByTitle(String title);
    Film findByImdbID(String imdbId);
    //List<Film> findByActors(String name);
    List<Film> findByYear(int year);

    @Override
    List<Film> findAll();
}
