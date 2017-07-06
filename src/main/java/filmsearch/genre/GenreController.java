package filmsearch.genre;

import com.wordnik.swagger.annotations.Api;
import filmsearch.mapper.ProjectModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 25.11.2015.
 */
@Api(basePath = "/api/genre", value = "Genres", description = "Genre endpoints")
@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private ProjectModelMapper mapper;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<GenreDTO> getAllGenres(){
        List<GenreDTO> genreDTOList = new ArrayList<>();
        genreService.getAllGenres().forEach(genre -> genreDTOList.add(mapper.map(genre, GenreDTO.class)));
        return genreDTOList;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAllGenres(){
        genreService.deleteAllGenres();
    }
}
