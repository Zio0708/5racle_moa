package com.moa.model.dao;

import com.moa.model.vo.SimpleAddressVO;

public interface AddressDAO {
    SimpleAddressVO search(int userId);
}
