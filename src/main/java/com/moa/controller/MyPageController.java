package com.moa.controller;


import com.moa.model.service.LuggageRequestInfoService;
import com.moa.model.service.LuggageRequestRecordService;
import com.moa.model.service.MemberInfoService;
import com.moa.model.vo.ReadStoreRequestVO;
import com.moa.model.vo.SimpleUserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value="/mypage")
public class MyPageController {
    @Autowired
    private LuggageRequestRecordService luggageRequestRecordService;
    @Autowired
    private LuggageRequestInfoService luggageRequestInfoService;
    @Autowired
    private MemberInfoService memberInfoService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public ModelAndView myPage() {
        ModelAndView mav = new ModelAndView();
        int userId = 28;
        SimpleUserInfoVO simpleUserInfoVO = memberInfoService.selectMemberInfo(userId);

        mav.addObject("profileName", simpleUserInfoVO.getProfileName());
        mav.addObject("userName", simpleUserInfoVO.getName());
        mav.addObject("userEmail", simpleUserInfoVO.getEmail());
        mav.addObject("requestCnt", simpleUserInfoVO.getRequestCnt());
        mav.addObject("notReadMessageCnt", simpleUserInfoVO.getNotReadMessageCnt());
        mav.addObject("usingStorageCnt", simpleUserInfoVO.getUsingStorageCnt());
        mav.setViewName("myPage");

        return mav;
    }

    @RequestMapping(value="/requestlist/{curPage}", method=RequestMethod.GET)
    public ModelAndView myPageRequestList(@PathVariable("curPage") int curPage){
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map;
        int userId = 28;
        int totPageCnt = 0;

        map = luggageRequestRecordService.selectLuggageRequestRecord(userId, curPage);
        totPageCnt = luggageRequestRecordService.LuggageRequestCountService(userId);

        mav.addObject("requestList", map.get("requestList"));
        mav.addObject("productList", map.get("productList"));
        mav.addObject("totPageCnt", totPageCnt);
        mav.addObject("curPage", curPage);

        mav.setViewName("requestList");

        return mav;
    }

    @RequestMapping(value="/requestlist/info/{requestNum}", method = RequestMethod.GET)
    @ResponseBody
    public ReadStoreRequestVO myPageRequestInfo(@PathVariable("requestNum") int requestId){
        ReadStoreRequestVO requestVO = luggageRequestInfoService.selectLuggageRequestInfo(requestId);
        requestVO.setApplicationDate(requestVO.getApplicationDate());
        return requestVO;
    }
}
