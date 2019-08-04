package com.moa.model.service;

import com.moa.model.dao.AddressDAO;
import com.moa.model.vo.SimpleAddressVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@NoArgsConstructor
public class AddressSearchService {
	@Autowired
	private AddressDAO addressDAO;

	public Map<String, Object> searchAddress(int userId) {
		Map<String, Object> addressInfo = new HashMap<String, Object>();
		SimpleAddressVO simpleAddressVO = addressDAO.search(userId);
		
		addressInfo.put("addressId", simpleAddressVO.getAddressId());
		addressInfo.put("address", simpleAddressVO.getBaseAddress() + " " + simpleAddressVO.getDetailAddress());
		
		return addressInfo;
	}
}
