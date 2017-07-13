package filmsearch.film;

import com.wordnik.swagger.annotations.Api;
import filmsearch.mapper.ProjectModelMapper;
import filmsearch.mapper.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
@Api(basePath = "/api/film", value = "Films", description = "Films endpoints")
@RestController
@RequestMapping("api/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ProjectModelMapper mapper;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FilmDTO> getAllFilms(){
        return mapper.mapList(filmService.getAllFilms(), FilmDTO.class);
    }

    @RequestMapping(value = "/get/show/{title}", method = RequestMethod.GET)
    public List<FilmDTO> addOrGetTvShowByTitle(@PathVariable(value = "title") String title)throws Exception{
        return mapper.mapList(filmService.getTvShowByTitle(title), FilmDTO.class);
    }

    @RequestMapping(value = "/get/film/title/{title}", method = RequestMethod.GET)
    public List<FilmDTO> addOrGetFilmByTitle(@PathVariable(value = "title") String title) throws Exception{
        return mapper.mapList(filmService.getFilmByTitle(title), FilmDTO.class);
    }

    @RequestMapping(value = "/get/film/genre", method = RequestMethod.POST)
    public PageDto<FilmDTO> getByGenre(@RequestBody FilmGenreSearchDTO filmGenreSearchDTO) throws Exception{
        return mapper.mapPage(filmService.getByGenre(filmGenreSearchDTO.getGenreName(),
                filmGenreSearchDTO.getPage(), filmGenreSearchDTO.getSize()), FilmDTO.class);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(value = "id") String id){
        filmService.deleteById(id);
    }
}
