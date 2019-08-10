package com.moa.model.service;

import com.moa.model.dao.StoreBoardDAO;
import com.moa.model.vo.StoreBoardFormVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class LuggageWelcomeServiceImpl implements LuggageWelcomeService {
    @Autowired
    private StoreBoardDAO storeBoardDAO;

    public Map<String, Object> initBoard(String hostId) {
        Map<String, Object> map = new HashMap<>();
        map.put("storageAddress",storeBoardDAO.selectStorageAddress(hostId));
        List<String> transactionList = new ArrayList<>();
        map.put("transaction", storeBoardDAO.selectTransaction());
        List<String> categoryList = new ArrayList<>();
        map.put("category", storeBoardDAO.selectCategory());
        List<String> periodList = new ArrayList<>();
        map.put("period", storeBoardDAO.selectStoragePeriod());
        List<String> priceList = new ArrayList<>();
        map.put("price", storeBoardDAO.selectPrice());
        return map;
    }

    public int noticeStorage(Map<String, Object> articleMap) {
        String hostId = (String) articleMap.get("hostId");
        String transaction = (String) articleMap.get("trade_type_answer");
        String pet = (String) articleMap.get("pet_text");
        String cctv = (String) articleMap.get("cctv_answer");
        List<String> forbiddenCategoryList = null;
        List<String> forbiddenProductList = null;
        String period = (String) articleMap.get("time_answer");
        List<String> priceList = null;
        String title = (String) articleMap.get("post_title");
        String content = (String) articleMap.get("post_contents");
        List<String> pictureList = null;

        if (articleMap.get("categoryList") != null) {
            forbiddenCategoryList = (List<String>) articleMap.get("categoryList");
        }
        if (articleMap.get("productList") != null) {
            forbiddenProductList = (List<String>) articleMap.get("productList");
        }
        if (articleMap.get("priceList") != null) {
            priceList = (List<String>) articleMap.get("priceList");
        }
        if (articleMap.get("pictureList") != null) {
            pictureList = (List<String>) articleMap.get("pictureList");
        }

        StoreBoardFormVO form = new StoreBoardFormVO(hostId, transaction, pet, cctv, forbiddenCategoryList, forbiddenProductList, period, priceList, pictureList, title, content, 100);
        return storeBoardDAO.insert(form);
    }
}
