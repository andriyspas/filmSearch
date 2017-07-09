package filmsearch.film;

import filmsearch.externalsearch.ExternalSearchService;
import filmsearch.genre.Genre;
import filmsearch.genre.GenreRepository;
import filmsearch.person.Person;
import filmsearch.person.PersonRepository;
import filmsearch.person.PersonService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
@Component
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ExternalSearchService searchService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private PersonService personService;

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public List<Film> getFilmByTitle(String title) throws Exception{
        List<Film> films = filmRepository.findByTitleContaining(title);
        if(films.isEmpty()) {
            films = addNewFilms(title);
        }
        return films;
    }

    public List<Film> gettvShowByTitle(String title) throws Exception{
        List<Film> films = filmRepository.findByTitleContaining(title);
        if(films.isEmpty()) {
            films = addNewTvShows(title);
        }
        return films;
    }

    public void deleteById(String id){
        filmRepository.delete(id);
    }

    private List<Film> addNewFilms(String title) throws Exception{
        List<Film> films = searchService.getFilmsByTitle(title);
        filmRepository.save(films);
        return films;
    }

    private List<Film> addNewTvShows(String title) throws Exception{
        List<Film> films = searchService.getTvShowByTitle(title);
        filmRepository.save(films);
        return films;
    }

    private List<Person> addPeople(String who){
        String[] actors = who.split(",");
        List<Person> actorsToAdd = new ArrayList<>();
        for (int i = 0; i < actors.length; i++) {

            actors[i] = actors[i].replaceAll("[^a-zA-Z\\s]", "").trim();
            if(actors[i].equals("NA") || actors[i].equals("N/A")){
                continue;
            }

            Person person = personRepository.findByName(actors[i]);
            if (person == null) {
                person = personService.addNewPerson(actors[i]);
            }
            actorsToAdd.add(person);
        }
        return actorsToAdd;
    }

    private List<Genre> getGenresFromJSONObject(JSONObject jsonObject){
        String[] genres = jsonObject.get("Genre").toString().split(",");
        List<Genre> genresToAdd = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            genres[i] = genres[i].replaceAll("[^a-zA-Z]", "");
            Genre genre = genreRepository.findByName(genres[i]);
            if (genre == null) {
                genre = new Genre(genres[i]);
                genreRepository.save(genre);
            }
            genresToAdd.add(genre);
        }
        return genresToAdd;
    }

    private double getCorrectImdbRating(JSONObject jsonObject){
        return (jsonObject.get("imdbRating").toString().matches(".*[0-9].*")) ? Double.parseDouble(jsonObject.get("imdbRating").toString()) : 0.0D;
    }
}
