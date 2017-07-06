package filmsearch.film;

import filmsearch.genre.Genre;
import filmsearch.person.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
@Component
public class FilmMapper {



    public FilmDTO mapToDTO(Film film){
        FilmDTO filmDTO = FilmDTO.builder()
                .id(film.getId())
                .title(film.getTitle())
                .country(film.getCountry())
                .type(film.getType().name())
                .imdbID(film.getImdbID())
                .imdbRating(film.getImdbRating())
                .imdbVotes(film.getImdbVotes())
                .runtime(film.getRuntime())
                .language(film.getLanguage())
                .year(film.getYear())
                .rated(film.isRated())
                .plot(film.getPlot())
                .poster(film.getPoster().toExternalForm())
                .actors(getAllPeopleNames(film.getActors()))
                .directors(getAllPeopleNames(film.getDirectors()))
                .genres(getAllGenreNames(film.getGenre()))
                .build();


        return filmDTO;
    }

    private List<String> getAllPeopleNames(List<Person> personList){
        List<String> actorNames = new ArrayList<>();
        personList.forEach(actor->actorNames.add(actor.getName()));
        return actorNames;
    }

    private List<String> getAllGenreNames(List<Genre> genreList){
        List<String> genreNames = new ArrayList<>();
        genreList.forEach(genre->genreNames.add(genre.getName()));
        return genreNames;
    }

    public List<FilmDTO> mapListToDTO(List<Film> filmList){
        List<FilmDTO> filmDTOList = new ArrayList<>();
        filmList.forEach(film -> filmDTOList.add(mapToDTO(film)));
        return filmDTOList;
    }
}
