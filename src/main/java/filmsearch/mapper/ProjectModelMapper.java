package filmsearch.mapper;

import filmsearch.externalsearch.FilmSearchDTO;
import filmsearch.film.Film;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectModelMapper extends ModelMapper {


    public <DTO> List<DTO> mapList(List<?> sourceList, Class<DTO> itemClass) {
        return sourceList.stream()
                .map(e -> map(e, itemClass))
                .collect(Collectors.toList());
    }

    public List<Film> mapFilmList(List<FilmSearchDTO> filmSearchDTO){
        List<Film> films = mapList(filmSearchDTO, Film.class);
        films.forEach(film -> {
            film.setYear(Integer.parseInt(film.getReleased().length() > 0 ? film.getReleased().substring(0,4) : "0"));
            film.setPoster(film.getPoster() != null ?
                    "https://image.tmdb.org/t/p/w500" + film.getPoster() :
                    "https://vignette1.wikia.nocookie.net/theannoyingroleplayers/images/4/47/Placeholder.png/revision/latest?cb=20140715205720");
        });
        return films;
    }

}
