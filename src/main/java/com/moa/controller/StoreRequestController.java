package com.moa.controller;

import com.moa.file.FileUpload;
import com.moa.model.service.StoreRequestService;
import com.moa.model.vo.StoreRequestVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/entrust")
public class StoreRequestController {
    private Log logger= LogFactory.getLog(StoreRequestController.class);

    @Autowired
    private StoreRequestService storeRequestService;

    @RequestMapping(value = "/{articleNum}" , method = RequestMethod.GET)
    public String entrustForm(@PathVariable("articleNum") int articleNum){
        return "entrust";
    }

    @RequestMapping(value = "/{articleNum}" , method = RequestMethod.POST)
    public @ResponseBody boolean entrust(@PathVariable("articleNum") int articleNum, HttpServletRequest request) throws ServletException, IOException {
        Map<String, Object> articleMap = FileUpload.entrustUpload(request);
        int userId = 1;
        String categoryList = null;
        String productList = null;
        String productCntList = null;
        String productSizeList = null;
        String pictureList = null;

        List<String> dateList = null;
        Date start_date = null;
        Date end_date = null;
        List<String> priceList = null;

        String transaction = (String) articleMap.get("trade_type_answer");
        String content = (String) articleMap.get("post_contents");

        int i=0;

        if (articleMap.get("categoryList") != null) {
            categoryList = ((List<String>) articleMap.get("categoryList")).toString();
            categoryList = categoryList.substring(1,categoryList.length()-1);
        }
        if (articleMap.get("productList") != null) {
            productList = ((List<String>) articleMap.get("productList")).toString();
            productList = productList.substring(1,productList.length()-1);
        }
        if (articleMap.get("priceList") != null) {
            priceList = (List<String>) articleMap.get("priceList");
        }
        if (articleMap.get("productCntList") != null) {
            productCntList= ((List<String>) articleMap.get("productCntList")).toString();
            productCntList=productCntList.substring(1,productCntList.length()-1);
        }
        if (articleMap.get("productSizeCntList") != null) {
            productSizeList = ((List<String>) articleMap.get("productSizeCntList")).toString();
            productSizeList=productSizeList.substring(1,productSizeList.length()-1);
        }
        if (articleMap.get("dateList") != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            dateList = (List<String>) articleMap.get("dateList");
            start_date = Date.valueOf(dateList.get(0));
            end_date = Date.valueOf(dateList.get(1));
        }
        if (articleMap.get("pictureList") != null) {
            pictureList = ((List<String>) articleMap.get("pictureList")).toString();
            pictureList=pictureList.substring(1,pictureList.length()-1);
        }

        for(String s:priceList)
            System.out.println(s);
        StoreRequestVO storeRequestVO = new StoreRequestVO(articleNum, userId,  Integer.parseInt(priceList.get(0)),
                Integer.parseInt(priceList.get(1)), start_date, end_date,transaction,content,productCntList, productSizeList,categoryList, productList, pictureList);
        logger.info(storeRequestVO);
        System.out.println(storeRequestVO);
        int storeRequestNum = storeRequestService.insert(storeRequestVO);
        logger.info("result = " + storeRequestNum);
        if(storeRequestNum!=0)
            return true;
        return false;
    }
}
