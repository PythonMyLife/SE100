package WordLadder_Auth;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class WordLadder_Auth {

    @RequestMapping("/auth")
    public boolean auth(@RequestParam String name, @RequestParam String password) {
        if(name.equals("user")&&password.equals("pass"))
            return true;
        else return false;
    }
}
