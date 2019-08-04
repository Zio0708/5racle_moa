package com.moa.mybatis;

import com.moa.model.vo.RequestProductVO;
import com.moa.model.vo.SimpleUserRequestVO;

import java.util.List;

public interface StoreRequestMapper {
    List<SimpleUserRequestVO> searchRequestList(int userId);
    List<RequestProductVO> searchRequestProduct(int requestId);
}
