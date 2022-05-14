package com.why.plant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.why.plant.dao.model.UserTable;

import java.util.Map;

public interface UserTableService extends IService<UserTable> {

    PageInfo selectAll(UserTable userTable);

    UserTable checkAccount(Map<String,String>params);

    Boolean submitUserInfo(UserTable userTable);


}
