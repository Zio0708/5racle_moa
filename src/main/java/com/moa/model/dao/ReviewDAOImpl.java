package com.moa.model.dao;


import com.moa.model.vo.CheckReviewVO;
import com.moa.model.vo.ReplyVO;
import com.moa.model.vo.ReviewVO;
import com.moa.mybatis.ReviewMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
    @Autowired
    @Qualifier("sqlSession_oracle")
    private SqlSession sqlSession_orcle;

    @Override
    public int addReview(ReplyVO replyVO) {
        ReviewMapper mapper=sqlSession_orcle.getMapper(ReviewMapper.class);
        return mapper.insertReview(replyVO);
    }

    @Override
    public List<ReviewVO> selectAllReview(Map<String, Object> pagingMap) {
        ReviewMapper mapper=sqlSession_orcle.getMapper(ReviewMapper.class);
        return mapper.selectReviewByPaging(pagingMap);
    }

    @Override
    public int selectTotReview(int articleNum) {
        ReviewMapper mapper=sqlSession_orcle.getMapper(ReviewMapper.class);
        return mapper.countReview(articleNum);
    }

    @Override
    public CheckReviewVO checkReviewCnt(Map<String, Object> map) {
        ReviewMapper mapper=sqlSession_orcle.getMapper(ReviewMapper.class);
        return mapper.checkReview(map);
    }
}
