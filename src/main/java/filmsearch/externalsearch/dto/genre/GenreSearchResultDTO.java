package filmsearch.externalsearch.dto.genre;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreSearchResultDTO {

    @JsonProperty("genres")
    private List<GenreSearchDTO> genres;
}
