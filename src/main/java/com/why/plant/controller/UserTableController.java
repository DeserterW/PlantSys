package com.why.plant.controller;

import com.github.pagehelper.PageInfo;
import com.why.plant.common.model.PageResult;
import com.why.plant.common.model.Result;
import com.why.plant.dao.model.UserTable;
import com.why.plant.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserTableController {

    @Autowired
    private UserTableService userTableService;

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping("/getAll")
    @ResponseBody
    public Result getAll(@RequestBody UserTable userTable){
        PageInfo pageInfo = userTableService.selectAll(userTable);
        PageResult pageResult = new PageResult(pageInfo);
        return Result.ok(pageResult);
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody UserTable userTable){
        boolean save = userTableService.save(userTable);
        return Result.ok();
    }

    @PostMapping("/info_change")
    @ResponseBody
    @CrossOrigin
    public Result submitInfo(@RequestBody UserTable userTable)
    {
        if(userTableService.submitUserInfo(userTable))
        {
            return Result.ok();
        }
        else
        {
            return Result.error("failed");
        }
    }

    @PostMapping("/getName")
    @CrossOrigin
    public Result getAllUserName(@RequestBody Map<String,Long>params)
    {
        List<UserTable> userTables = userTableService.selectAllName(null);

        if(userTables != null)
        {
            return Result.ok(userTables);
        }else
        {
            return Result.error();
        }
    }

}
