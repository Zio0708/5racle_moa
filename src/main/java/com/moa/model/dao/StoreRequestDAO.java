package com.moa.model.dao;

import com.moa.model.vo.SimpleUserRequestVO;

import java.util.List;

public interface StoreRequestDAO {
    public List<SimpleUserRequestVO> searchList(int userId);
}
