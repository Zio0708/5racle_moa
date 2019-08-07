package com.moa.controller;


import com.moa.model.service.LuggageRequestInfoService;
import com.moa.model.service.LuggageRequestRecordService;
import com.moa.model.vo.ReadStoreRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value="/mypage")
public class MyPageController {
    @Autowired
    private LuggageRequestRecordService luggageRequestRecordService;
    @Autowired
    private LuggageRequestInfoService luggageRequestInfoService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public ModelAndView myPage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("profileName", "profile.jpg");
        mav.addObject("userName", "김모아");
        mav.addObject("userEmail", "moa@google.com");
        mav.addObject("requestCnt", 0);
        mav.addObject("notReadMessageCnt", 0);
        mav.addObject("usingStorageCnt", 2);
        mav.setViewName("myPage");
        return mav;
    }

    @RequestMapping(value="/requestlist", method=RequestMethod.GET)
    public ModelAndView myPageRequestList(){
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map;

        map = luggageRequestRecordService.selectLuggageRequestRecord(28);

        mav.addObject("requestList", map.get("requestList"));
        mav.addObject("productList", map.get("productList"));
        System.out.println("set attribute success");
        mav.setViewName("requestList");

        return mav;
    }

    @RequestMapping(value="/requestlist/{requestNum}", method = RequestMethod.GET)
    @ResponseBody
    public ReadStoreRequestVO myPageRequestInfo(@PathVariable("requestNum") int requestId){
        ReadStoreRequestVO requestVO = luggageRequestInfoService.selectLuggageRequestInfo(requestId);
        System.out.println(requestVO);
        requestVO.setApplicationDate(requestVO.getApplicationDate());
        return requestVO;
    }
}
