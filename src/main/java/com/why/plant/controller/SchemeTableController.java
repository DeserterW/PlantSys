package com.why.plant.controller;
import com.why.plant.common.model.Result;
import com.why.plant.dao.mapper.SchemeTableMapper;
import com.why.plant.dao.model.SchemeTable;
import com.why.plant.service.PersonalSchemeTableService;
import com.why.plant.service.SchemeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/scheme")
@RestController
public class SchemeTableController {

    @Autowired
    private SchemeTableService schemeTableService;

    @Autowired
    private PersonalSchemeTableService personalSchemeTableService;

    @PostMapping("/detail")
    @CrossOrigin
    public Result selectScheme(@RequestBody Map<String,Long> param)
    {
        Long personalSchemeId = param.get("personalSchemeId");

        Long schemeId = personalSchemeTableService.selectSchemeId(personalSchemeId);

        SchemeTable schemeTable = schemeTableService.selectSchemeDetail(schemeId);

        Map<String,Object> detail =new HashMap<>();
        if(schemeTable != null)
        {
            detail.put("schemeName",schemeTable.getSchemeName());
            detail.put("temperature",schemeTable.getTemperature());
            detail.put("lightTime",schemeTable.getLightTime());
            detail.put("moisture",schemeTable.getMoisture());
            detail.put("fertilizer",schemeTable.getFertilizer());
            detail.put("growPeriod",schemeTable.getGrowPeriod());
            detail.put("likesNums",schemeTable.getLikesNums());
        }

        return schemeTable != null ? Result.ok(detail) : Result.error();

    }


}
