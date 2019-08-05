package com.moa.controller;

import com.moa.message.PathMessage;
import com.moa.model.service.StoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/storeBoard")
@Controller
public class StoreBoardController {
    @Autowired
    private StoreBoardService storeBoardService;

    @RequestMapping("/{articleNum}")
    public ModelAndView retrieveStoreBoard(@PathVariable("articleNum") int articleNum){
        ModelAndView mav=new ModelAndView();
        mav.setViewName(PathMessage.STORE_BOARD_ONE);
        mav.addObject("storeBoard",storeBoardService.selectStorage(articleNum));
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/error/page");
        mav.addObject("message","존재하지 않는 페이지 입니다.");
        return mav;
    }
}
