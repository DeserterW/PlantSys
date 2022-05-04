package com.why.plant.controller;


import com.why.plant.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserTableService userTableService;

    @GetMapping("/login")
    public String loginHtml(HashMap<String, Object> map) {
        return "/login";
    }

    @PostMapping("/login/check")
    @ResponseBody
    @CrossOrigin
    public String loginCheck(@RequestBody Map<String, String> params)
    {
        String ret = "failed";

        if(userTableService.checkAccount(params))
        {
            ret = "success";
        }

        return ret;
    }

}
