package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.why.plant.dao.mapper.UserTableMapper;
import com.why.plant.dao.model.UserTable;
import com.why.plant.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTable> implements UserTableService {

    @Autowired
    private UserTableMapper userTableMapper;

    @Override
    public PageInfo selectAll(UserTable userTable) {
        if(userTable.getPage()!=null && userTable.getSize()!=null){
            PageHelper.startPage(userTable.getPage(), userTable.getSize());
        }
        List<UserTable> userTables = userTableMapper.selectList(new LambdaQueryWrapper<UserTable>());
        userTableMapper.update(new UserTable(),new LambdaUpdateWrapper<UserTable>().set(UserTable::getName,"why").eq(UserTable::getName,"why"));
        PageInfo<UserTable> pageInfo =new PageInfo<>(userTables);
        return pageInfo;
    }
}
