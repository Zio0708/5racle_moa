package com.moa.model.service;


import com.moa.model.dao.UserDAO;
import com.moa.model.vo.SimpleUserInfoVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class MemberInfoService {
    @Autowired
    private UserDAO userDAO;

    public SimpleUserInfoVO selectMemberInfo(int userId){
        return userDAO.selectUserInfo(userId);
    }
}
