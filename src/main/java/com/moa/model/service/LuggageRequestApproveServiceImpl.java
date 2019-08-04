package com.moa.model.service;

import com.moa.model.dao.TransactionDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LuggageRequestApproveServiceImpl {
	@Autowired
	private TransactionDAOImpl transactionDAO;
	
//	public LuggageRequestApproveServiceImpl() {
//		transactionDAO = new TransactionDAOImpl();
//	}
//	public LuggageRequestApproveServiceImpl(TransactionDAOImpl transactionDAO) {
//		this.transactionDAO = transactionDAO;
//	}
	
	public boolean updateTransactionHistory(Map<String, Object> transactionInfo) {

		return  transactionDAO.update(transactionInfo);
	}
}
