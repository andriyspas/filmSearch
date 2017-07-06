package filmsearch.search;

import filmsearch.film.Film;
import filmsearch.film.FilmDTO;
import filmsearch.film.FilmMapper;
import filmsearch.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanislav on 12/01/2016.
 */
@Component
public class YearSearchService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    FilmMapper filmMapper;

    public YearSearchDTO getByYear(int year){
        List<Film> filmList = filmRepository.findByYear(year);
        if(!filmList.isEmpty()) {
            YearSearchDTO yearSearchDTO = new YearSearchDTO();
            yearSearchDTO.setYear(year);
            yearSearchDTO.setFilmDTOs(filmMapper.mapListToDTO(filmList));
            yearSearchDTO.setAverageRating(calculateAverageRating(yearSearchDTO.getFilmDTOs()));
            return yearSearchDTO;
        }
        return new YearSearchDTO();
    }

    public List<YearSearchDTO> getForYearRange(int yearFrom, int yearTo){
        List<YearSearchDTO> yearSearchDTOList = new ArrayList<>();
        for(int i = yearFrom; i <= yearTo; i++){
            YearSearchDTO yearSearchDTO = getByYear(i);
            if(yearSearchDTO != null){
                yearSearchDTOList.add(yearSearchDTO);
            }
        }
        return yearSearchDTOList;
    }

    private double calculateAverageRating(List<FilmDTO> filmDTOList){
        double ratingSum = 0;
        for (FilmDTO filmDTO : filmDTOList) {
            ratingSum += filmDTO.getImdbRating();
        }
        return ratingSum / filmDTOList.size();
    }
}
