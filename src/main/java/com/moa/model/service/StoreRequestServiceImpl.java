package com.moa.model.service;

import com.moa.model.dao.StoreRequestDAO;
import com.moa.model.vo.StoreRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreRequestServiceImpl implements StoreRequestService{
    @Autowired
    private StoreRequestDAO dao;

    @Override
    public int insert(StoreRequestVO storeRequestVO) {
        return dao.insert(storeRequestVO);
    }
}
