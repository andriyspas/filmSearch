package filmsearch.film;

import com.wordnik.swagger.annotations.Api;
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
    FilmService filmService;

    @Autowired
    FilmMapper filmMapper;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FilmDTO> getAllFilms(){
        return filmMapper.mapListToDTO(filmService.getAllFilms());
    }

    @RequestMapping(value = "/add-sample", method = RequestMethod.GET)
    public List<FilmDTO> addSampleFilms() throws Exception{
        return filmMapper.mapListToDTO(filmService.addNewFilms());
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteAll(){
        filmService.deleteAll();
    }

    @RequestMapping(value = "/get/id/{imdbID}", method = RequestMethod.GET)
    public FilmDTO addOrGetByIMDBId(@PathVariable(value = "imdbID") String imdbID)throws Exception{
        return filmMapper.mapToDTO(filmService.addByIMDBId(imdbID));
    }

    @RequestMapping(value = "/get/title/{title}", method = RequestMethod.GET)
    public FilmDTO addOrGetByTitle(@PathVariable(value = "title") String title) throws Exception{
        return filmMapper.mapToDTO(filmService.addByTitle(title));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(value = "id") String id){
        filmService.deleteById(id);
    }
}
