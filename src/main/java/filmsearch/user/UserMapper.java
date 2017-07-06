package filmsearch.user;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Stas on 30-Nov-16.
 */
@Component
public class UserMapper {

    public UserDTO mapToDTO(User user){

        UserDTO userDTO = UserDTO.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .id(user.getId())
                .username(user.getUsername())
                .build();
        return userDTO;
    }
}
