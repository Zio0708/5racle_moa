package com.moa.controller;

import com.moa.model.service.ReviewService;
import com.moa.model.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value="/{articleNum}", method = RequestMethod.POST)
    public @ResponseBody String writeReview(@PathVariable("articleNum") int articleNum,
                                             @RequestBody ReplyVO replyVO){
        replyVO.setArticleNum(articleNum);
        replyVO.setUserId(28); //temporary ... To do userId get from SessionAttribute ...
        String result=reviewService.insertReview(replyVO);
        System.out.println(result);
        return result;
    }
    @RequestMapping(value="/{articleNum}", method = RequestMethod.GET)
    public @ResponseBody  Map<String,Object> retrieveReviewList(@PathVariable("articleNum") int articleNum,
                                                     @RequestParam("section") int section,
                                                     @RequestParam("pageNum") int pageNum){
        Map<String,Object> pagingMap=new HashMap<String,Object>();
        pagingMap.put("section",section);
        pagingMap.put("pageNum",pageNum);
        pagingMap.put("articleNum",articleNum);

        Map<String, Object> articlesMap=reviewService.listReview(pagingMap);
        articlesMap.put("section", section);
        articlesMap.put("pageNum", pageNum);
        return articlesMap;
    }
}
