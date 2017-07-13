package filmsearch.externalsearch;

import filmsearch.externalsearch.dto.actor.PersonSearchResultDTO;
import filmsearch.externalsearch.dto.film.FilmSearchResultDTO;
import filmsearch.externalsearch.dto.genre.GenreSearchResultDTO;
import filmsearch.film.Film;
import filmsearch.genre.Genre;
import filmsearch.mapper.ProjectModelMapper;
import filmsearch.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ExternalSearchService {

    @Autowired private RestTemplate restTemplate;
    @Autowired private ProjectModelMapper mapper;

    @Value("${themoviedb.search.film.endpoint}")
    private String filmSearchUrl;

    @Value("${themoviedb.search.tvShow.endpoint}")
    private String tvSearchUrl;

    @Value("${themoviedb.get.genres.endpoint}")
    private String genresSearchUrl;

    @Value("${themoviedb.search.person.endpoint}")
    private String personSearchEndpoint;

    public List<Film> getFilmsByTitle(String title){
        ResponseEntity<FilmSearchResultDTO> responseEntity = restTemplate.getForEntity(filmSearchUrl + title, FilmSearchResultDTO.class);
        return mapper.mapFilmList(responseEntity.getBody().getResults());
    }

    public List<Film> getTvShowByTitle(String title){
        ResponseEntity<FilmSearchResultDTO> responseEntity = restTemplate.getForEntity(tvSearchUrl + title, FilmSearchResultDTO.class);
        return mapper.mapFilmList(responseEntity.getBody().getResults());
    }

    public List<Genre> getGenres(){
        ResponseEntity<GenreSearchResultDTO> responseEntity = restTemplate.getForEntity(genresSearchUrl, GenreSearchResultDTO.class);
        return mapper.mapList(responseEntity.getBody().getGenres(), Genre.class);
    }

    public List<Person> getPersonByName(String name){
        ResponseEntity<PersonSearchResultDTO> responseEntity = restTemplate.getForEntity(personSearchEndpoint + name, PersonSearchResultDTO.class);
        return mapper.mapPersonList(responseEntity.getBody());
    }
}
