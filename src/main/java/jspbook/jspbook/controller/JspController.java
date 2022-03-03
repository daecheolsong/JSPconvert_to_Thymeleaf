package jspbook.jspbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JspController {

    @GetMapping({"/", "/welcome"})
    public String welcome() {

        return "welcome";
    }


    @GetMapping("/products")
    public String products() {

        return "products";
    }

    @GetMapping("/product")
    public String product() {
        return "product";
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }

    @PostMapping("/processAddProduct")
    public String processAddProduct() {
        return "processAddProduct";
    }
}
