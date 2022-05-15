package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.why.plant.dao.mapper.CommentTotalTableMapper;
import com.why.plant.dao.model.CommentTotalTable;
import com.why.plant.service.CommentTotalTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【CommentTotalTable】的数据库操作Service实现
* @createDate 2022-05-15 16:06:17
*/
@Service
public class CommentTotalTableServiceImpl extends ServiceImpl<CommentTotalTableMapper, CommentTotalTable>
    implements CommentTotalTableService {

    @Autowired
    private CommentTotalTableMapper commentTotalTableMapper;

    @Override
    public List<Long> getCommentList(CommentTotalTable commentTotalTable) {
         CommentTotalTable selectTotal = commentTotalTableMapper.selectOne(new LambdaQueryWrapper<CommentTotalTable>()
                .select(CommentTotalTable::getCommentList).eq(CommentTotalTable::getId,commentTotalTable.getId()));
        String list = selectTotal.getCommentList();
        String[] split = list.split(",");
        List<Long> commentList = new ArrayList<>();
        for(int i = 0 ; i< split.length;i++)
        {
            commentList.add(new Long(split[i]));
        }

        return commentList;
    }

    @Override
    public List<CommentTotalTable> getAllComment(CommentTotalTable commentTotalTable) {

        List<CommentTotalTable> commentTotalTables = commentTotalTableMapper.selectList(new LambdaQueryWrapper<>());

        return commentTotalTables;

    }

    @Override
    public Boolean addComment(Long commendId, Long mainId) {
        CommentTotalTable commentTotalTable = commentTotalTableMapper.selectOne(new LambdaQueryWrapper<CommentTotalTable>()
                .eq(CommentTotalTable::getId,mainId));

        String oldCommentList = commentTotalTable.getCommentList();
        String newCommentList = oldCommentList + "," +commendId.toString();
        commentTotalTable.setCommentList(newCommentList);

        int res =commentTotalTableMapper.updateById(commentTotalTable);
        if(res == 1)
            return true;

        return false;
    }

    @Override
    public Boolean addNewTitle(CommentTotalTable commentTotalTable) {

        int res = commentTotalTableMapper.insert(commentTotalTable);

        if(res == 1)
            return true;
        return false;
    }
}




