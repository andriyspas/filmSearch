package filmsearch.user;

import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by Stas on 28-Nov-16.
 */
@RestController
@RequestMapping("/api/authentication/")
@Api(basePath = "/api/authentication/", value = "Users", description = "Users endpoints")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody UserDTO accountDto){
        return userService.registerNewAccount(accountDto);

    }

    @RequestMapping(path = {"/logout"})
    public void logout(HttpServletRequest request) throws ServletException {
        request.logout();
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String returnSuccess(){
        return "login successful";
    }
}
