package filmsearch.mapper;

import filmsearch.externalsearch.dto.actor.PersonSearchResultDTO;
import filmsearch.externalsearch.dto.film.FilmSearchDTO;
import filmsearch.film.Film;
import filmsearch.genre.Genre;
import filmsearch.genre.GenreRepository;
import filmsearch.mapper.dto.PageDto;
import filmsearch.person.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectModelMapper extends ModelMapper {

    @Autowired private GenreRepository genreRepository;

    public <DTO> List<DTO> mapList(List<?> sourceList, Class<DTO> itemClass) {
        return sourceList.stream()
                .map(e -> map(e, itemClass))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public <DTO> PageDto<DTO> mapPage(Page<?> page, Class<DTO> itemClass) {
        PageDto pageDto = map(page, PageDto.class);
        pageDto.setContent(mapList(page.getContent(), itemClass));
        return pageDto;
    }

    public List<Film> mapFilmList(List<FilmSearchDTO> filmSearchDTOs){
        List<Film> films = mapList(filmSearchDTOs, Film.class);
        int index = 0;
        for(Film film : films) {
            film.setYear(Integer.parseInt(film.getReleased().length() > 0 ? film.getReleased().substring(0,4) : "0"));
            film.setPoster(film.getPoster() != null ?
                    "https://image.tmdb.org/t/p/w500" + film.getPoster() :
                    "https://vignette1.wikia.nocookie.net/theannoyingroleplayers/images/4/47/Placeholder.png/revision/latest?cb=20140715205720");
            setGenres(film, filmSearchDTOs.get(index));
            index++;
        }
        return films;
    }

    public List<Person> mapPersonList(PersonSearchResultDTO personSearchResultDTO){
        List<Person> personList = new ArrayList<>();
        personSearchResultDTO.getResults().forEach(personSearchDTO -> {
            Person person = map(personSearchDTO, Person.class);
            person.setFilmList(mapFilmList(personSearchDTO.getFilmList()));
            personList.add(person);
        });
        return personList;
    }

    private void setGenres(Film film, FilmSearchDTO filmSearchDTO){
        List<Genre> genres = new ArrayList<>();
        for(int id : filmSearchDTO.getGenreIds()){
            genres.add(genreRepository.findOne((long) id));
        }
        film.setGenres(genres);
    }

}
