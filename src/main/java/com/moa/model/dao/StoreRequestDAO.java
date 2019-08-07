package com.moa.model.dao;

import com.moa.model.vo.*;

import java.util.List;

public interface StoreRequestDAO {
    public ReadStoreRequestVO search(int requestId);
    public List<SimpleUserRequestVO> searchList(int userId);

}
