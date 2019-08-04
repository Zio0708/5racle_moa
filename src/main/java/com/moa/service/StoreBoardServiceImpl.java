package com.moa.service;

import com.example.springmvc.dao.HostReputationDAO;
import com.example.springmvc.dao.StoreBoardDAO;
import com.example.springmvc.vo.HostReputationVO;
import com.example.springmvc.vo.StoreBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StoreBoardServiceImpl implements StoreBoardService{
    @Autowired
    private StoreBoardDAO storeBoardDAO;
    @Autowired
    private HostReputationDAO hostReputationDAO;
    @Override
    public Map<String, Object> selectStorage(int articleNum) {
        Map<String,Object> selectMap=new HashMap<String,Object>();
        StoreBoardVO storeBoardVO=storeBoardDAO.searchOne(articleNum);
        if(storeBoardVO==null)
            return null;
        HostReputationVO hostReputationVO = hostReputationDAO.searchOne(articleNum);
        //List<ReviewVO> reviewList= ReviewDAO.searchList(hostReputationVO.getNick());
        //file upload logic
        selectMap.put("storeBoardVO", storeBoardVO);
        selectMap.put("hostReputationVO", hostReputationVO);
        //selectMap.put("reviewList", reviewList);
        return selectMap;
    }
}
