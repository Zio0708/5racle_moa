package com.moa.controller;

import com.moa.model.service.StoreBoardSearchService;
import com.moa.model.vo.DetailOptionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping(value="/moa")
@Controller
public class StoreBoardSearchController {
    @Autowired
    private StoreBoardSearchService storeBoard;

    @RequestMapping(value="/Search" , method=  RequestMethod.GET)
    public @ResponseBody List<Object> hostSearch(DetailOptionVO detail){
        System.out.println("전송중....");
        List<Object> documents = storeBoard.search(detail);
        System.out.println(documents.get(1));

        return documents;
    }


}
