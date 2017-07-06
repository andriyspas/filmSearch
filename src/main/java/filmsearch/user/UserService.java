package filmsearch.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Stas on 30-Nov-16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity registerNewAccount(UserDTO accountDto){
        if(!userAlreadyExists(accountDto)) {
            User user = User.builder()
                    .username(accountDto.getUsername())
                    .firstName(accountDto.getFirstName())
                    .lastName(accountDto.getLastName())
                    .password(passwordEncoder.encode(accountDto.getPassword()))
                    .email(accountDto.getEmail())
                    .build();
            userRepository.save(user);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    private boolean userAlreadyExists(UserDTO userDTO){
        return userRepository.findByUsername(userDTO.getUsername()) != null;
    }
}
