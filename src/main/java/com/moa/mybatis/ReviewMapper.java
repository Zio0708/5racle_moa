package com.moa.mybatis;

import com.moa.model.vo.CheckReviewVO;
import com.moa.model.vo.ReplyVO;
import com.moa.model.vo.ReviewVO;

import java.util.List;
import java.util.Map;

public interface ReviewMapper {
    public List<ReviewVO> selectReviewByPaging(Map<String, Object> map);
    int countReview(int articleNum);
    int insertReview(ReplyVO replyVO);
    CheckReviewVO checkReview(Map<String, Object> map);
}
