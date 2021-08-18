package com.example.fullintel.controller;

import com.example.fullintel.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

   /* @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        System.out.println("Hi");
        return "Hi";
    }*/

    @GetMapping("/api/v1/test")
    public ResponseEntity<?> getUser() throws Exception {
        userDao.selectAllUser("admin@capestart.com","b85e2529d52e65a03acba2d8591b712c");
        System.out.println("Hiii");
        return ResponseEntity.ok("Hello");
    }
}
