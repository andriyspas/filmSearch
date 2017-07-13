package filmsearch.film;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
@Component
public interface FilmRepository extends CrudRepository<Film, String> {
    List<Film> findByTitleContaining(String title);
    List<Film> findByYear(int year);

    Page<Film> findByGenresName(String name, Pageable pageable);

    @Override
    List<Film> findAll();
}
