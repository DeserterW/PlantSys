package com.why.plant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("/dsa");
        return mv;
    }


}
