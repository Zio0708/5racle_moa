package com.moa.model.service;

import com.moa.model.dao.StoreRequestDAO;
import com.moa.model.vo.SimpleUserRequestVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class LuggageRequestRecordService {
	@Autowired
	private StoreRequestDAO storeRequestDAO;
	
	public Map<String, Object> selectLuggageRequestRecord(int userId){
		Map<String, Object> map = new HashMap<String, Object>();
		List<SimpleUserRequestVO> requestList = new ArrayList<SimpleUserRequestVO>();
		List<String> productList = new ArrayList<String> ();
		requestList = storeRequestDAO.searchList(userId);
		
		for(int i = 0 ; i < requestList.size(); i++) {
			String productInfo = "";
			for(int j = 0 ; j < requestList.get(i).getProductName().size() ; j++) {
				productInfo += requestList.get(i).getProductName().get(j);
				productInfo += "(" + requestList.get(i).getProductCnt().get(j) + "), ";
			}
			if(productInfo.length() > 20) {
				productInfo = productInfo.substring(0, 20);
				productInfo += "...";
			}
			else {
				productInfo = productInfo.substring(0, productInfo.length() - 2);
			}
			productList.add(productInfo);
		}
	
		map.put("requestList", requestList);
		map.put("productList", productList);
		
		return map;
	}
}
