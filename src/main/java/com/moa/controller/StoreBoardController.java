package com.moa.controller;

import com.moa.file.FileUpload;
import com.moa.message.PathMessage;
import com.moa.model.service.LuggageWelcomeService;
import com.moa.model.service.StoreBoardSearchService;
import com.moa.model.service.StoreBoardService;
import com.moa.model.vo.DetailOptionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestMapping("/storeboard")
@Controller
public class StoreBoardController {
    @Autowired
    private StoreBoardService storeBoardService;
    @Autowired
    private LuggageWelcomeService luggageWelcomeService;
    @Autowired
    private StoreBoardSearchService storeBoard;

    @RequestMapping(value="" , method=  RequestMethod.GET)
    public String hostSearch(){
        return "hostSearch";
    }

    @RequestMapping(value="/Search" , method=  RequestMethod.POST)
    public @ResponseBody
    List<Object> hostSearch2(DetailOptionVO detail){
        System.out.println("전송중....");
        List<Object> documents = storeBoard.search(detail);
        System.out.println(documents.get(1));

        return documents;
    }

    @RequestMapping("/keep")
    public ModelAndView registerStoreBoard(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("keep");

        String hostId = "3"; //String hostId = (String)request.getAttribute("hostId");
        mav.addObject("hostId", hostId);
        Map<String, Object> map = luggageWelcomeService.initBoard(hostId);
        mav.addObject("map", map);
        return mav;
    }

    @RequestMapping("/keepregister")
    public @ResponseBody void keepRegisterStoreBoard(HttpServletRequest request) {
        Map<String, Object> articleMap = FileUpload.keepUpload(request);
        System.out.println("Result: " + luggageWelcomeService.noticeStorage(articleMap));
    }

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
