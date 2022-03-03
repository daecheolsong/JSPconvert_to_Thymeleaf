package jspbook.jspbook.controller;

import jspbook.jspbook.dto.Product;
import jspbook.jspbook.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    ProductRepository productRepository = new ProductRepository();


    @GetMapping({"", "/welcome"})
    public String welcome(Model model) {
        LocalDateTime localTime = LocalDateTime.now();
        String greeting = "Welcome to Web Shopping Mall";
        String tagline = "Welcome to Web Market!";
        model.addAttribute("greeting", greeting);
        model.addAttribute("tagline", tagline);
        model.addAttribute("localTime", localTime);
        return "thymeleaf/welcome";
    }

    @GetMapping("/products")
    public String products(Model model) {
        ArrayList<Product> productList = productRepository.getAllProducts();
        model.addAttribute("productList", productList);
        return "thymeleaf/products";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable("id")String id, Model model) {
        Product productById = productRepository.getProductById(id);
        model.addAttribute("product", productById);
        return "thymeleaf/product";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "thymeleaf/addProduct";
    }

    @PostMapping("/products")
    public String productsResult(Product product, Model model) {
        productRepository.addProduct(product);
        ArrayList<Product> productList = productRepository.getAllProducts();
        model.addAttribute("productList", productList);
        return "thymeleaf/products";
    }
}
