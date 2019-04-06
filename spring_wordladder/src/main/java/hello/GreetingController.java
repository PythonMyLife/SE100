package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="str1") String str1,
            @RequestParam(value="str2") String str2)
    {
        return new Greeting(counter.incrementAndGet(),
                str1,str2);
    }
}