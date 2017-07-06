package filmsearch.person;

import filmsearch.requests.GetHttpResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

/**
 * Created by Stas on 26.11.2015.
 */
@Component
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public void deleteAllPerson(){
        personRepository.deleteAll();
    }

    public Person getById(String id){
        return personRepository.findOne(id);
    }

    public Person getByName(String name){
        Person person = personRepository.findByName(name);
        if(person == null){
            addNewPerson(name);
        }
        return person;
    }

    public void deleteById(String id){
        personRepository.delete(id);
    }

    public Person updatePersonBio(Person person){
        person = getPersonFromFromApi(person.getName());
        personRepository.save(person);
        return person;
    }

    public Person addNewPerson(String name){
        Person person = getPersonFromFromApi(name);
        personRepository.save(person);
        return person;
    }

    private Person getPersonFromFromApi(String name){

        try {
            JSONObject personJSON = getPersonJSON(name);
            Person person = Person.builder()
                    .name(personJSON.get("title").toString())
                    .bio(personJSON.get("description").toString())
                    .photo((personJSON.get("image").toString().equals("N/A")) ? new URL("http://larics.rasip.fer.hr/wp-content/uploads/2016/04/default-placeholder-1024x1024.png") : new URL(personJSON.get("image").toString()))
                    .occupation(personJSON.get("occupation").toString())
                    .build();

            return person;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }


    }

    private JSONObject getPersonJSON(String name)throws Exception{
        JSONObject temp = getPersonJSONFromApiByName(name);
        return getPersonJSONFromApiById((String) temp.get("id"));
    }

    private JSONObject getPersonJSONFromApiByName(String name)throws Exception{
        JSONObject object = GetHttpResponse.excuteGetProxy("http://www.imdb.com/xml/find?json=1&nr=1&nm=on&q=" + name.replace(" ", "+").toLowerCase());
        JSONArray jsonArray = (JSONArray) object.get("name_popular");
        object = (JSONObject) jsonArray.get(0);

        return object;
    }

    private JSONObject getPersonJSONFromApiById(String id)throws Exception{
        JSONObject jsonObject = GetHttpResponse.excuteGet("http://imdb.wemakesites.net/api/" + id);
        JSONParser parser = new JSONParser();
        if (jsonObject.get("status").toString().equals("success")) {
            return (JSONObject) parser.parse(jsonObject.get("data").toString());
        }
        return new JSONObject();
    }
}
