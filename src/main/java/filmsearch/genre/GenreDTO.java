package filmsearch.genre;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Stas on 25.11.2015.
 */
@Builder
public class GenreDTO {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;


}
