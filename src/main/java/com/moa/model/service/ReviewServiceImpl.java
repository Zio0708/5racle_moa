package com.moa.model.service;

import com.moa.model.dao.ReviewDAO;
import com.moa.model.vo.CheckReviewVO;
import com.moa.model.vo.ReplyVO;
import com.moa.model.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewDAO reviewDAO;

    @Override
    public String insertReview(ReplyVO replyVO) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("userId",replyVO.getUserId());
        map.put("articleNum",replyVO.getArticleNum());

        CheckReviewVO checkReviewVO=reviewDAO.checkReviewCnt(map);
        if(checkReviewVO.getTot()==0)
            return "noAuthority";
        else if(checkReviewVO.getTot()>checkReviewVO.getRev()) {
            return reviewDAO.addReview(replyVO) > 0 ? "ok" : "error";
        }
        else{
            return "overFlow";
        }
    }

    @Override
    public Map<String,Object> listReview(Map<String, Object> pagingMap) {
        Map<String, Object> articlesMap=new HashMap<String, Object>();

        List<ReviewVO> reviewVOList=reviewDAO.selectAllReview(pagingMap);
        int articleNum=(int)pagingMap.get("articleNum");
        int totArticles = reviewDAO.selectTotReview(articleNum);

        articlesMap.put("reviewList", reviewVOList);
        articlesMap.put("totReviews", totArticles);
        return articlesMap;
    }
}
