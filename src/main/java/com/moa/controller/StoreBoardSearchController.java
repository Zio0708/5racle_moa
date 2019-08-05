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

@Controller
public class StoreBoardSearchController {
    @Autowired
    private StoreBoardSearchService storeBoard;

    @RequestMapping(value="/" , method=  RequestMethod.GET)
    public String hostSearchGO(){


        return "hostSearch";
    }


}
