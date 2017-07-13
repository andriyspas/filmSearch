package filmsearch.genre;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByName(String name);

    @Override
    List<Genre> findAll();
}
