package com.moa.model.dao;

import com.moa.model.vo.SimpleUserInfoVO;

public interface UserDAO {
    SimpleUserInfoVO selectUserInfo(int userId);
}
