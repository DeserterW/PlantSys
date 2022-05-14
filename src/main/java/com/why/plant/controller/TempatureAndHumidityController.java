package com.why.plant.controller;


import com.why.plant.common.model.Result;
import com.why.plant.dao.model.EnvironmentalchangeTable;
import com.why.plant.service.EnvTableService;
import com.why.plant.service.EnvironmentalchangeTableService;
import com.why.plant.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/monitor")
@RestController
public class TempatureAndHumidityController {

    @Autowired
    private EnvironmentalchangeTableService environmentalchangeTableService;

    @Autowired
    private EnvTableService envTableService;

    @PostMapping("/temperature")
    @CrossOrigin
    public Result monitorOnTempature(@RequestBody Map<String, Long> params)
    {

        Long id = params.get("user_id");

        // 根据前端返回的环境id，搜索
        // 返回最近一段时间的温度和湿度信息
        List<Long> envs_id = envTableService.selectEnv(id);

        List<EnvironmentalchangeTable> result = environmentalchangeTableService.showRecentTemperature(envs_id);

        return Result.ok(result);
    }

}
