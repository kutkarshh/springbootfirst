package com.myspringboot.springbootfirst.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspringboot.springbootfirst.dao.UserRepository;

/**
 * This class is the main controller for the Spring Boot project.
 */
@Controller
public class MainController {

    UserRepository userRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePageHandler(Model model) {
        // return "Hello World";
        model.addAttribute("isActive", true);
        model.addAttribute("membership", "P");
        List<Integer> myList = List.of(1, 2, 3, 4, 5);
        model.addAttribute("myList", myList);
        model.addAttribute("title", "Utkarsh Kumar");
        model.addAttribute("date", "Dated:" + LocalDateTime.now().toString());
        return "home";
    }

    @GetMapping("/about")
    public String aboutPageHandler(Model model) {
        model.addAttribute("name", "Utkarsh Kumar");
        List<String> friends = List.of("Utkarsh", "Ankit", "Devish", "Abhishek", "Bhupendra");
        model.addAttribute("friends", friends);
        model.addAttribute("title", "Utkarsh Kumar");
        model.addAttribute("date", "Dated:" + LocalDateTime.now().toString());
        return "about";
    }

    // Will use insert/include/replace Fragments concept of Thymeleaf
    @GetMapping("/contact")
    public String contactPageHandler(Model model) {
        model.addAttribute("title", "Utkarsh Kumar");
        model.addAttribute("subtitle", "Dated:" + LocalDateTime.now().toString());
        return "contact";
    }

    @GetMapping("/aboutNew")
    public String aboutNewPageHandler(Model model) {
        model.addAttribute("title", "Utkarsh Kumar");
        model.addAttribute("date", "Dated:" + LocalDateTime.now().toString());
        return "about_new";
    }

    // Login Handler
    // @GetMapping("/login")
    // public String loginHandler(Model model) {
    // model.addAttribute("loginData", new LoginDetails());
    // return "login";
    // }

    // SignUp Handler
    // @GetMapping("/signup")
    // public String signupHandler(Model model) {
    // // model.addAttribute("signupData", new LoginDetails());
    // return "signup";
    // }
}
