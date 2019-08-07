package com.moa.model.dao;

import com.moa.model.vo.SimpleAddressVO;
import com.moa.mybatis.AddressMapper;
import com.moa.mybatis.HostStorageMapper;
import lombok.NoArgsConstructor;
import oracle.net.jdbc.TNSAddress.Address;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class AddressDAOImpl implements AddressDAO {
	@Autowired
	private SqlSession sqlSession;

	public SimpleAddressVO search(int userId) {
		AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
		return mapper.searchUserAddress(userId);
	}
}
