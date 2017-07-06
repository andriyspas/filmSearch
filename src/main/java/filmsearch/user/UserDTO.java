package filmsearch.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Stas on 28-Nov-16.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Setter
    @Getter
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String matchingPassword;

    @Getter
    @Setter
    private String email;
}
