package com.why.plant.controller;


import com.why.plant.common.model.Result;
import com.why.plant.dao.model.EnvironmentalchangeTable;
import com.why.plant.service.EnvironmentalchangeTableService;
import com.why.plant.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/monitor")
@Controller
public class TempatureAndHumidityController {

    @Autowired
    private EnvironmentalchangeTableService environmentalchangeTableService;

    @Autowired
    private UserTableService userTableService;

    @PostMapping("/temperature")
    public Result monitorOnTempature(@RequestBody Map<String, String> params)
    {
        Result ret = null;

        EnvironmentalchangeTable environmentalchangeTable;
        // 根据前端返回的环境id，搜索
        // 返回最近一段时间的温度和湿度信息
        

        return ret;
    }

}
