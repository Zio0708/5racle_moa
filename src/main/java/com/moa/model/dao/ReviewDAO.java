package com.moa.model.dao;



import com.moa.model.vo.CheckReviewVO;
import com.moa.model.vo.ReplyVO;
import com.moa.model.vo.ReviewVO;

import java.util.List;
import java.util.Map;

public interface ReviewDAO {
    public int addReview(ReplyVO replyVO);
    public List<ReviewVO> selectAllReview(Map<String, Object> pagingMap);
    public int selectTotReview(int articleNum);
    public CheckReviewVO checkReviewCnt(Map<String, Object> map);
}
