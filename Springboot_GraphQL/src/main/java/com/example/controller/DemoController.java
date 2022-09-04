package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
@RequestMapping("/graphql")
public class DemoController {

    @Resource
    private UserService userService;

    @PostMapping()
    public ModelAndView demo1() {
        ModelAndView modelAndView = new ModelAndView();
        User userById = userService.getUserById(1);
        modelAndView.addObject("demo", userById);
        return modelAndView;
    }


}
