package com.moa.mybatis;

import com.moa.model.vo.SimpleUserInfoVO;


public interface UserMapper {
    SimpleUserInfoVO selectUserInfo(int userId);
}
