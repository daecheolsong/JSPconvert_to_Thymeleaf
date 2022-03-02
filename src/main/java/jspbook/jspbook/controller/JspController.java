package jspbook.jspbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {

    @GetMapping("/")
    public String welcome() {

        return "welcome";
    }

    @GetMapping("/products")
    public String products() {

        return "products";
    }
}
