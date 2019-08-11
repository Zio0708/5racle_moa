package com.moa.model.dao;


import com.moa.model.vo.SimpleUserInfoVO;
import com.moa.mybatis.UserMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public SimpleUserInfoVO selectUserInfo(int userId) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.selectUserInfo(userId);
    }

    @Override
    public boolean checkExistUser(String userNick) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.selectUserExist(userNick);
        if(result == 1)
            return true;
        return false;
    }
}
