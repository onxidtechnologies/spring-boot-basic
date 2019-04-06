package com.onxidtechnologies.springbootbasic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/")
public class WelcomeController {
    @RequestMapping(method = GET)
    public String sayHello() {
        return "Hello World";
    }
}
