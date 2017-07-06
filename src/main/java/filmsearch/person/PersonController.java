package filmsearch.person;

import com.wordnik.swagger.annotations.Api;
import filmsearch.mapper.ProjectModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Stas on 26.11.2015.
 */
@Api(basePath = "/api/person", value = "People", description = "Actors and directors endpoints")
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    ProjectModelMapper mapper;

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<PersonDTO> getAllPerson(){
        return mapper.mapList(personService.getAllPerson(), PersonDTO.class);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(value = "id")String id){
        personService.deleteById(id);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public PersonDTO getById(@PathVariable("id") String id){
        return mapper.map(personService.getById(id), PersonDTO.class);
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    public PersonDTO getByName(@PathVariable(value = "name") String name){
        return mapper.map(personService.getByName(name), PersonDTO.class);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteAllPerson(){
        personService.deleteAllPerson();
    }
}
