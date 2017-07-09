package filmsearch.externalsearch;

import filmsearch.film.Film;
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

    public List<Film> getFilmsByTitle(String title){
        ResponseEntity<SearchResultDTO> responseEntity = restTemplate.getForEntity(filmSearchUrl + title, SearchResultDTO.class);
        return mapper.mapFilmList(responseEntity.getBody().getResults());
    }

    public List<Film> getTvShowByTitle(String title){
        ResponseEntity<SearchResultDTO> responseEntity = restTemplate.getForEntity(tvSearchUrl + title, SearchResultDTO.class);
        return mapper.mapFilmList(responseEntity.getBody().getResults());
    }
}
