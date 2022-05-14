package com.why.plant.controller;


import com.why.plant.common.model.Result;
import com.why.plant.dao.model.UserTable;
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
    public Result loginCheck(@RequestBody Map<String, String> params)
    {
        UserTable userTable = userTableService.checkAccount(params);

        if(userTable != null)
        {
            return Result.ok(userTable);
        }
        return Result.error("failed");
    }

}
