package com.moa.model.service;

import com.moa.model.vo.ReplyVO;

import java.util.Map;

public interface ReviewService {
    public String insertReview(ReplyVO replyVO);
    public Map<String,Object> listReview(Map<String, Object> pagingMap);
}
