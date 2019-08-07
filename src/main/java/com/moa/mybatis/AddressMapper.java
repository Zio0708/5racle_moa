package com.moa.mybatis;

import com.moa.model.vo.SimpleAddressVO;

public interface AddressMapper {
    SimpleAddressVO searchUserAddress(int userId);
}
