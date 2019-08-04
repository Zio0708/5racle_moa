package com.moa.controller;

import com.moa.file.FileUpload;
import com.moa.model.service.LuggageWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RequestMapping("/storeBoard")
@Controller
public class KeepRegisterController {
    @Autowired
    private LuggageWelcomeService luggageWelcomeService;


    @RequestMapping("/keepregister")
    public @ResponseBody void registerStoreBoard(HttpServletRequest request) throws ServletException, IOException {
        Map<String, Object> articleMap = FileUpload.keepUpload(request);
        System.out.println("Controller: " + articleMap);
        String hostId = "21";       //(String)request.getAttribute("hostId");

//        int articleNum = luggageWelcomeService.noticeStorage(hostId, articleMap);
        System.out.println("Result: " + luggageWelcomeService.noticeStorage(hostId, articleMap));
        //request.setAttribute("articleNum", articleNum);

        /*ModelAndView mav=new ModelAndView();
        mav.setViewName(PathMessage.KEEPREGISTER);
        articleMap.put("articleNum", articleNum);
        mav.addObject("storeBoard",luggageWelcomeService.noticeStorage("hostId", articleMap));
        return mav;*/
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/error/page");
        mav.addObject("message","존재하지 않는 페이지 입니다.");
        return mav;
    }
}
