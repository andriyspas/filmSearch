package filmsearch.film;

import filmsearch.externalsearch.ExternalSearchService;
import filmsearch.genre.Genre;
import filmsearch.genre.GenreRepository;
import filmsearch.person.Person;
import filmsearch.person.PersonRepository;
import filmsearch.person.PersonService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public List<Film> getTvShowByTitle(String title) throws Exception{
        List<Film> films = filmRepository.findByTitleContaining(title);
        if(films.isEmpty()) {
            films = addNewTvShows(title);
        }
        return films;
    }

    public List<Film> getPopular(){
        List<Film> popular = searchService.getPopular();
        for(int i = 0; i < popular.size(); i++){
            popular.get(i).setId((long)i);
        }
        return popular;
    }

    public Page<Film> getByGenre(String genreName, int page, int size){
        return filmRepository.findByGenresName(genreName, new PageRequest(page, size));
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
}
