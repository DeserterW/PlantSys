package com.why.plant.controller;

import com.github.pagehelper.PageInfo;
import com.why.plant.common.model.PageResult;
import com.why.plant.common.model.Result;
import com.why.plant.dao.model.EnvTable;
import com.why.plant.service.EnvTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class TestController {

    @Autowired
    private EnvTableService envTableService;

    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("/dsa");
        return mv;
    }

    @PostMapping("/getEnv")
    @ResponseBody
    public Result getAll(@RequestBody EnvTable envTable){
        envTable.getPage();
        envTable.getSize();
        PageInfo pageInfo = envTableService.selectAll(envTable);
        PageResult pageResult = new PageResult(pageInfo);
        return Result.ok(pageResult);
    }

}
