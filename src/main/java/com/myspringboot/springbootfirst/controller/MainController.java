package com.myspringboot.springbootfirst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is the main controller for the Spring Boot project.
 */
@Controller
public class MainController {

    /**
     * Handles the home page request and returns a welcome message as the response
     * body.
     *
     * @return Welcome message for the home page
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ResponseBody
    public String homePageHandler() {
        return "Welcome to Spring Boot Project";
    }

}
