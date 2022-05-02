package com.why.plant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
public class indexController {

    @RequestMapping("/index")
    public ModelAndView indexHtml(HashMap<String, Object> map) {
        ModelAndView mv =  new ModelAndView("/index");
        return mv;
    }


}
