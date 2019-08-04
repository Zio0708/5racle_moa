package com.moa.model.service;

import java.util.List;
import java.util.Map;

import com.moa.model.dao.StoreBoardDAOImpl;
import com.moa.model.vo.SimpleStorageBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyStorageServiceImpl {
	@Autowired
	private StoreBoardDAOImpl storeBaordDAO;

	
	public List<SimpleStorageBoardVO> selectMyStorage(Map<String,Object> storageInfo){
		return storeBaordDAO.searchMyStorage(storageInfo);
	}

	public int selectMyStorageCnt(int hostId){
		return storeBaordDAO.searchMyStorageCnt(hostId);
	}
}
