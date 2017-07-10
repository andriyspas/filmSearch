package filmsearch.externalsearch;

import filmsearch.film.Film;
import filmsearch.genre.Genre;
import filmsearch.mapper.ProjectModelMapper;
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

    public List<Film> getFilmsByTitle(String title){
        ResponseEntity<FilmSearchResultDTO> responseEntity = restTemplate.getForEntity(filmSearchUrl + title, FilmSearchResultDTO.class);
        return mapper.mapFilmList(responseEntity.getBody().getResults());
    }

    public List<Film> getTvShowByTitle(String title){
        ResponseEntity<FilmSearchResultDTO> responseEntity = restTemplate.getForEntity(tvSearchUrl + title, FilmSearchResultDTO.class);
        return mapper.mapFilmList(responseEntity.getBody().getResults());
    }

    public List<Genre> getGenres(){
        ResponseEntity<GenreSearchResultDto> responseEntity = restTemplate.getForEntity(genresSearchUrl, GenreSearchResultDto.class);
        return mapper.mapList(responseEntity.getBody().getGenres(), Genre.class);
    }
}
