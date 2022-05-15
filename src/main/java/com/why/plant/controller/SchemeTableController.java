package com.why.plant.controller;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.why.plant.common.model.Result;
import com.why.plant.dao.mapper.SchemeTableMapper;
import com.why.plant.dao.model.EnvTable;
import com.why.plant.dao.model.SchemeTable;
import com.why.plant.service.EnvTableService;
import com.why.plant.service.PersonalSchemeTableService;
import com.why.plant.service.SchemeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/scheme")
@RestController
@CrossOrigin
public class SchemeTableController {

    @Autowired
    private SchemeTableService schemeTableService;

    @Autowired
    private PersonalSchemeTableService personalSchemeTableService;

    @Autowired
    private EnvTableService envTableService;

    @PostMapping("/detail")
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

    @PostMapping("/all")
    public Result seletAll(@RequestBody Map<String,Boolean> params)
    {
        Boolean passed = params.get("passed");

        List<SchemeTable> schemeTables =  schemeTableService.selectScheme(passed);

        if(schemeTables.isEmpty())
        {
            return Result.error();
        }

        return Result.ok(schemeTables);
    }


    @PostMapping("/recommandation")
    public Result recommandation(@RequestBody Map<String,Long> params)
    {
        if(params == null)
        {
            return Result.error();
        }
        Long plantId = params.get("plantId");
        Long envId = params.get("envId");

        EnvTable envTable = envTableService.selectEnvById(envId);
        List<SchemeTable> schemeTables = schemeTableService.selectAllScheme(plantId);

        List<SchemeTable>recommdationScheme = schemeTableService.recommdation(envTable,schemeTables);

        if(recommdationScheme != null)
        {
            return Result.ok(recommdationScheme);
        }else
        {
            return Result.error();
        }
    }

    @PostMapping("/like")
    public Result putALike(@RequestBody SchemeTable schemeTable)
    {
        if(schemeTableService.putALike(schemeTable))
        {
            return Result.ok();
        }

        return Result.error();
    }

    @PostMapping("/checkScheme")
    public Result checkScheme(@RequestBody Map<String,String> params)
    {
        Boolean passed = Boolean.parseBoolean(params.get("passed"));
        if(passed == false) {
            return Result.error("not passed");
        }else
        {
            Long shcemeId = Long.parseLong(params.get("id"));
            schemeTableService.passScheme(shcemeId);
        }

        return Result.ok();
    }

    @PostMapping("/removeScheme")
    public Result removeScheme(@RequestBody SchemeTable schemeTable)
    {

        if(schemeTableService.deleteScheme(schemeTable))
        {
            return Result.ok();
        }else {
            return Result.error();
        }
    }

}
