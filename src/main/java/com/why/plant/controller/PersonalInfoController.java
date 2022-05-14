package com.why.plant.controller;
import com.why.plant.common.model.Result;
import com.why.plant.dao.model.EnvTable;
import com.why.plant.dao.model.PersonalPlantTable;
import com.why.plant.dao.model.PersonalSchemeTable;
import com.why.plant.dao.model.SchemeTable;
import com.why.plant.service.EnvTableService;
import com.why.plant.service.PersonalPlantTableService;
import com.why.plant.service.PersonalSchemeTableService;
import com.why.plant.service.SchemeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/personal")
@RestController
@CrossOrigin
public class PersonalInfoController {

    @Autowired
    private PersonalPlantTableService personalPlantTableService;

    @Autowired
    private PersonalSchemeTableService personalSchemeTableService;

    @Autowired
    private SchemeTableService schemeTableService;

    @Autowired
    private EnvTableService envTableService;

    @PostMapping("/plant")
    public Result selectAllPersonalPlantInfo(@RequestBody Map<String, Long> params)
    {
        Long user_id = params.get("userId");

        List<PersonalPlantTable> personalPlantTables =personalPlantTableService.selectPersonalPlantInfo(user_id);

        if(personalPlantTables != null)
        {
            return Result.ok(personalPlantTables);
        }

        return Result.error("failed");
    }


    @PostMapping("/addPlant")
    public Result addPlant(@RequestBody PersonalPlantTable personalPlantTable)
    {

        if(personalPlantTableService.addPersonalPlant(personalPlantTable))
        {
            return Result.ok();
        }else
        {
            return Result.error("failed");
        }
    }

    @PostMapping("/editInfo")
    public Result editInfo(@RequestBody PersonalPlantTable personalPlantTable)
    {

        if(personalPlantTableService.editPersonalPlant(personalPlantTable))
        {
            return Result.ok();
        }else {
            return Result.error("failed");
        }
    }

    @PostMapping("/removePlant")
    public Result removePlant(@RequestBody PersonalPlantTable personalPlantTable)
    {
        if(personalPlantTableService.removePersonalPlant(personalPlantTable))
        {
            return Result.ok();
        }else
        {
            return Result.error("failed");
        }
    }

    @PostMapping("/scheme")
    public Result selectAllPersonalScheme(@RequestBody PersonalSchemeTable personalSchemeTable)
    {
        Long id = personalSchemeTable.getUserId();

        List<PersonalSchemeTable>personalSchemeTables = personalSchemeTableService.selectAllPersonalTable(id);
        List<SchemeTable> schemeTables = null;
        if(personalSchemeTables != null)
        {
            schemeTables =  schemeTableService.selectScheme(personalSchemeTables);
        }

        List<Map<String,Object>> res = new ArrayList<>();

        Map<Long,List<Object>> schemeMap = new HashMap<>();
        if(schemeTables != null)
        {
            for (SchemeTable schemeTable : schemeTables) {
                List<Object> temp =  new ArrayList<>();
                /**
                 * 0 = 方案名
                 * 1 = 生长期
                 * 2 = 点赞数
                 */
                temp.add(schemeTable.getSchemeName());
                temp.add(schemeTable.getGrowPeriod());
                temp.add(schemeTable.getLikesNums());
                schemeMap.put(schemeTable.getId(),temp);
            }

            for (PersonalSchemeTable table : personalSchemeTables) {
                Map<String,Object> resJson = new HashMap<>();
                Long schemeId = table.getSchemeId();
                resJson.put("id",table.getId());
                resJson.put("name",schemeMap.get(schemeId).get(0));
                resJson.put("date",table.getDate());
                resJson.put("exceuteTime",table.getExceuteTime());
                resJson.put("envrionment",table.getEnvId());
                resJson.put("growPeriod",schemeMap.get(schemeId).get(1));
                resJson.put("likeNums",schemeMap.get(schemeId).get(2));
                res.add(resJson);
            }
        }

        if(res != null)
        {
            return Result.ok(res);
        }

        return  Result.error();
    }

    @PostMapping("/addScheme")
    public Result addScheme(@RequestBody SchemeTable schemeTable)
    {
        Long schemeId = schemeTableService.addScheme(schemeTable);

        if(personalSchemeTableService.addPersonalScheme(schemeTable.getUserId(),schemeId))
        {
            return Result.ok();
        }

        return Result.error();
    }

    @PostMapping("/env")
    public Result addPersonalEnv(@RequestBody EnvTable envTable)
    {
//        envTableService

        return Result.ok();
    }
}
