package filmsearch.externalsearch.dto.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonSearchResultDTO {

    @JsonProperty("results")
    private List<PersonSearchDTO> results;
}
