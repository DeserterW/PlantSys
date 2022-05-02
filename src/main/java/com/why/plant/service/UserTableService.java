package com.why.plant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.why.plant.dao.model.UserTable;

public interface UserTableService extends IService<UserTable> {

    PageInfo selectAll(UserTable userTable);
}
