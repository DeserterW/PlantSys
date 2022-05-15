package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.why.plant.dao.mapper.CommentsTableMapper;
import com.why.plant.dao.model.CommentsTable;
import com.why.plant.service.CommentsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【CommentsTable】的数据库操作Service实现
* @createDate 2022-05-02 20:59:59
*/
@Service
public class CommentsTableServiceImpl extends ServiceImpl<CommentsTableMapper, CommentsTable> implements CommentsTableService {

    @Autowired
    private CommentsTableMapper commentsTableMapper;


    @Override
    public List<CommentsTable> getAllComment(CommentsTable commentsTable) {

        List<CommentsTable> commentsTables = commentsTableMapper.selectList(new LambdaQueryWrapper<CommentsTable>()
                .eq(CommentsTable::getPassed,true));


        return commentsTables;
    }
}




