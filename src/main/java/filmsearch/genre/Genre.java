package filmsearch.genre;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Stas on 25.11.2015.
 */
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Genre {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    @Getter
    @Setter
    @Column
    private String name;

}
