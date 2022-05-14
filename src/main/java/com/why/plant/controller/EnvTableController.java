package com.why.plant.controller;

import com.why.plant.common.model.Result;
import com.why.plant.dao.model.EnvTable;
import com.why.plant.service.EnvTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/env")
@RestController
@CrossOrigin
public class EnvTableController {

    @Autowired
    private EnvTableService envTableService;

    @PostMapping("/all")
    public Result selectAll(@RequestBody Map<String,Long> params)
    {
        Long userId = params.get("userId");

        List<EnvTable> envTables = envTableService.selectEnvDetail(userId);

        if(envTables != null)
        {
            return Result.ok(envTables);
        }

        return Result.error();
    }
}
