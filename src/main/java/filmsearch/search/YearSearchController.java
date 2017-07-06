package filmsearch.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Stanislav on 12/01/2016.
 */
@RestController
@RequestMapping(value = "/api/search/year")
public class YearSearchController {

    @Autowired
    YearSearchService yearSearchService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public YearSearchDTO getForOneYear(@RequestParam int year){
        return yearSearchService.getByYear(year);
    }

    @RequestMapping(value = "/range", method = RequestMethod.GET)
    public List<YearSearchDTO> getForRange(@RequestParam int from, @RequestParam int to){
        return yearSearchService.getForYearRange(from,to);
    }
}
