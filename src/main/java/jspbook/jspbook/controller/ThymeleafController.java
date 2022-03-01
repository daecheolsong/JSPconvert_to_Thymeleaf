package jspbook.jspbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String welcome(Model model) {
        LocalDateTime localTime = LocalDateTime.now();
        String greeting = "Welcome to Web Shopping Mall";
        String tagline = "Welcome to Web Market!";
        model.addAttribute("greeting", greeting);
        model.addAttribute("tagline", tagline);
        model.addAttribute("localTime", localTime);
        return "thymeleaf/welcome";
    }
}
