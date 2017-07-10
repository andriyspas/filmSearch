package filmsearch.externalsearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmSearchDTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("release_date")
    private String released;

    @JsonProperty("runtime")
    private int runtime;

    @JsonProperty("overview")
    private String plot;

    @JsonProperty("genre_ids")
    private int[] genreIds;

    @JsonProperty("original_language")
    private String language;

    @JsonProperty("backdrop_path")
    private String poster;

    @JsonProperty("vote_average")
    private double imdbRating;

    @JsonProperty("vote_count")
    private int imdbVotes;

    @JsonProperty("imdb_id")
    private String imdbID;
}
