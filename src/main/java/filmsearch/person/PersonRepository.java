package filmsearch.person;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
public interface PersonRepository extends CrudRepository<Person, String> {
    Person findByName(String name);

    @Override
    List<Person> findAll();
}
