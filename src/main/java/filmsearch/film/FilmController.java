package filmsearch.film;

import com.wordnik.swagger.annotations.Api;
import filmsearch.mapper.ProjectModelMapper;
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

    @RequestMapping(value = "/get/id/{imdbID}", method = RequestMethod.GET)
    public FilmDTO addOrGetByIMDBId(@PathVariable(value = "imdbID") String imdbID)throws Exception{
        return mapper.map(filmService.addByIMDBId(imdbID), FilmDTO.class);
    }

    @RequestMapping(value = "/get/title/{title}", method = RequestMethod.GET)
    public FilmDTO addOrGetByTitle(@PathVariable(value = "title") String title) throws Exception{
        return mapper.map(filmService.getByTitle(title), FilmDTO.class);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(value = "id") String id){
        filmService.deleteById(id);
    }
}
