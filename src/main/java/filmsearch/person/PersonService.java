package filmsearch.person;

import filmsearch.externalsearch.ExternalSearchService;
import filmsearch.film.Film;
import filmsearch.film.FilmRepository;
import filmsearch.requests.GetHttpResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stas on 26.11.2015.
 */
@Component
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ExternalSearchService searchService;

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void deleteAllPerson() {
        personRepository.deleteAll();
    }

    public Person getById(String id) {
        return personRepository.findOne(id);
    }

    public List<Person> getByName(String name) {
        List<Person> persons = personRepository.findByNameContaining(name);
        if (persons.isEmpty()) {
            persons = addNewPerson(name);
        }
        return persons;
    }

    public void deleteById(String id) {
        personRepository.delete(id);
    }

    private List<Person> addNewPerson(String name) {
        List<Person> persons = searchService.getPersonByName(name);
        addFilms(persons);
        personRepository.save(persons);
        return persons;
    }

    private void addFilms(List<Person> personList) {
        for (Person person : personList) {
            for (Film film : person.getFilmList()) {
                film.setActors(new ArrayList<Person>(){{add(person);}});
            }
        }
    }
}
