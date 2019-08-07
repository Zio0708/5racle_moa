package com.moa.model.service;

import com.moa.model.dao.StoreRequestDAO;
import com.moa.model.dao.StoreRequestDAOImpl;
import com.moa.model.vo.ReadStoreRequestVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class LuggageRequestInfoService {
	@Autowired
	private StoreRequestDAO storeRequestDAO;

	public ReadStoreRequestVO selectLuggageRequestInfo(int requestId) {
		System.out.println(storeRequestDAO);


		System.out.println("asdasd");
		System.out.println("asdasd");
		System.out.println(storeRequestDAO);
		return storeRequestDAO.search(requestId);
	}
}
