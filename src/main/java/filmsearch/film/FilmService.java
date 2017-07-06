package filmsearch.film;

import filmsearch.genre.Genre;
import filmsearch.genre.GenreRepository;
import filmsearch.person.Person;
import filmsearch.person.PersonRepository;
import filmsearch.person.PersonService;
import filmsearch.requests.GetHttpResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
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
    private PersonRepository personRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private PersonService personService;

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public Film addByIMDBId(String id) throws Exception{
        Film film = filmRepository.findByImdbID(id);
        if(film == null) {
            return addNewFilm("http://www.omdbapi.com/?i=" + id + "&plot=short&r=json");
        }
        return film;
    }

    public Film getByTitle(String title) throws Exception{
        Film film = filmRepository.findByTitle(title.toLowerCase());
        if(film == null) {
            return addNewFilm("http://www.omdbapi.com/?t=" + title.replace(" ", "+").toLowerCase() + "&y=&plot=short&r=json");
        }
        return film;
    }

    public void deleteById(String id){
        filmRepository.delete(id);
    }

    private Film addNewFilm(String url) throws Exception{
        JSONObject jsonObject = GetHttpResponse.excuteGet(url);
        Film film = Film.builder()
                .title(jsonObject.get("Title").toString().toLowerCase())
                .imdbID(jsonObject.get("imdbID").toString())
                .country(jsonObject.get("Country").toString())
                .directors(addPeople(jsonObject.get("Director").toString()))
                .genre(getGenresFromJSONObject(jsonObject))
                .imdbRating(getCorrectImdbRating(jsonObject))
                .imdbVotes((getCorrectImdbRating(jsonObject) == 0.0D) ? 0 : Integer.decode(jsonObject.get("imdbVotes").toString().replace(",","")))
                .poster((jsonObject.get("Poster").toString().equals("N/A")) ? new URL("http://larics.rasip.fer.hr/wp-content/uploads/2016/04/default-placeholder-1024x1024.png") : new URL(jsonObject.get("Poster").toString()))
                .plot(jsonObject.get("Plot").toString())
                .year(Integer.decode(jsonObject.get("Year").toString().replaceAll("\\D+","")))
                .runtime(jsonObject.get("Runtime").toString())
                .rated(jsonObject.get("Runtime").toString() == "NOT RATED")
                .language(jsonObject.get("Language").toString())
                .type(FilmType.valueOf(jsonObject.get("Type").toString()))
                .actors(addPeople(jsonObject.get("Actors").toString()))
                .released(jsonObject.get("Released").toString())
                .build();

        filmRepository.save(film);
        return film;
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
