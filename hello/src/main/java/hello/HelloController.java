package hello;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @CrossOrigin
    @RequestMapping("/")
    public String getIndex() {
        return JSONObject.quote("Hello Voxxed Microservices");
    }
}
