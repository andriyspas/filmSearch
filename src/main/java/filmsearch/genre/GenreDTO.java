package filmsearch.genre;

import lombok.*;

/**
 * Created by Stas on 25.11.2015.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;


}
