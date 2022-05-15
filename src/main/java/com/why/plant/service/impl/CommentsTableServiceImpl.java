package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.why.plant.dao.mapper.CommentsTableMapper;
import com.why.plant.dao.model.CommentsTable;
import com.why.plant.service.CommentsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
* @author Administrator
* @description 针对表【CommentsTable】的数据库操作Service实现
* @createDate 2022-05-02 20:59:59
*/
@Service
public class CommentsTableServiceImpl extends ServiceImpl<CommentsTableMapper, CommentsTable> implements CommentsTableService {

    @Autowired
    private CommentsTableMapper commentsTableMapper;

    class mycompartor<C> implements Comparator<CommentsTable> {


        @Override
        public int compare(CommentsTable o1, CommentsTable o2) {

            return o1.getDate().compareTo(o2.getDate()) ;
        }
    }


    @Override
    public List<CommentsTable> getAllComment(CommentsTable commentsTable, Boolean isPassed) {

        List<CommentsTable> commentsTables = commentsTableMapper.selectList(new LambdaQueryWrapper<CommentsTable>()
                .eq(CommentsTable::getPassed,isPassed));


        return commentsTables;
    }

    @Override
    public List<CommentsTable> getSeriesComment(List<Long> commentIds) {


        List<CommentsTable> commentsTables = commentsTableMapper.selectList(new LambdaQueryWrapper<CommentsTable>()
                .in(CommentsTable::getId,commentIds).eq(CommentsTable::getPassed,true));

        Collections.sort(commentsTables,new mycompartor<CommentsTable>());

        return commentsTables;
    }

    @Override
    public Boolean putALike(CommentsTable commentsTable) {
        commentsTable = commentsTableMapper.selectById(commentsTable.getId());
        commentsTable.setLikesNums(commentsTable.getLikesNums() + 1);

        int res = commentsTableMapper.updateById(commentsTable);
        if(res == 1) return true;

        return false;
    }

    @Override
    public Long commentBack(CommentsTable commentsTable) {

        commentsTable.setPassed(false);
        commentsTable.setDate(new Date());
        commentsTable.setLikesNums(0);

        int res = commentsTableMapper.insert(commentsTable);
        if(res ==1)
            return commentsTable.getId();
        else
            return null;
    }

    @Override
    public Boolean setPassed(CommentsTable commentsTable) {

        commentsTable.setPassed(true);
        int res = commentsTableMapper.updateById(commentsTable);

        if(res == 1)
            return true;

        return false;
    }


}




