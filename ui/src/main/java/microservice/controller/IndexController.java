package microservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/info")
    public String info() {
        return "info";
    }
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }
}
