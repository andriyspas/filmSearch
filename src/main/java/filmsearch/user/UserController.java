package filmsearch.user;

import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by Stas on 28-Nov-16.
 */
@RestController
@RequestMapping("/api/user")
@Api(basePath = "/api/user", value = "Users", description = "Users endpoints")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDTO register(@RequestBody UserDTO accountDto){
        return userMapper.mapToDTO(userService.registerNewAccount(accountDto));

    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String returnSuccess(){
        return "login successful";
    }
}
