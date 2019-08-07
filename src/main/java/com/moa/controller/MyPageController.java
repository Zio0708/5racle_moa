package com.moa.controller;


import com.moa.model.service.LuggageRequestRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value="/mypage")
public class MyPageController {
    @Autowired
    private LuggageRequestRecordService luggageRequestRecordService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String myPage(){
        return "/myPage";
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
}
