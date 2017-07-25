package filmsearch.externalsearch.dto.genre;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreSearchDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
}
