package com.moa.service;

import com.example.springmvc.dao.StoreRequestDAO;
import com.example.springmvc.vo.StoreRequestVO;
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
