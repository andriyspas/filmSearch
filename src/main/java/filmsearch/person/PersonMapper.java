package filmsearch.person;

import filmsearch.film.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Stas on 26.11.2015.
 */
@Component
public class PersonMapper {

    @Autowired
    FilmMapper filmMapper;
    public PersonDTO mapToDTO(Person person){
        PersonDTO personDTO = PersonDTO.builder()
                .bio(person.getBio())
                .id(person.getId())
                .name(person.getName())
                .occupation(person.getOccupation())
                .photo((person.getPhoto() == null) ? "null" : person.getPhoto().toExternalForm())
                .filmDTOs(filmMapper.mapListToDTO(person.getFilmList()))
                .build();

        return personDTO;
    }

    public List<PersonDTO> mapListToDTO(List<Person> personList){
        List<PersonDTO> personDTOList = new ArrayList<>();
        personList.forEach(person -> personDTOList.add(mapToDTO(person)));
        return personDTOList;
    }
}
