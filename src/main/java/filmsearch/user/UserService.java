package filmsearch.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Stas on 30-Nov-16.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerNewAccount(UserDTO accountDto){

        User user = new User();
        user.setUsername(accountDto.getUsername());
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        //user.setRoles(Arrays.asList(UserRoles.ROLE_USER));
        return userRepository.save(user);
    }
}
