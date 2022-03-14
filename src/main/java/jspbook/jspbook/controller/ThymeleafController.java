package jspbook.jspbook.controller;

import jspbook.jspbook.dto.Product;
import jspbook.jspbook.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping("/thymeleaf")
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class ThymeleafController {

    private LocaleResolver localeResolver;
    ProductRepository productRepository = new ProductRepository();


    @Value("${file.dir}")
    String fileDir;

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
    public String addProductView(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);
        return "thymeleaf/addProduct";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam("productImage") MultipartFile file, Model model, @Valid Product product, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "thymeleaf/addProduct";
        }
        System.out.println("product = " + product);
        saveFile(product, file);
        ArrayList<Product> productList = productRepository.getAllProducts();
        model.addAttribute("productList", productList);
        return "thymeleaf/products";
    }

    private void saveFile(Product product,MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String originalFileName = file.getOriginalFilename();
            String fullPath = fileDir + originalFileName;
            product.setFilename(originalFileName);
            productRepository.addProduct(product);
            file.transferTo(new File(fullPath));
        }
    }
}
