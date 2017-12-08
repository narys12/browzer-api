package com.naris.browzerapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(path = "/api/user", method = RequestMethod.GET)
    private UserController getUser() {
        return new UserController();
    }
}
