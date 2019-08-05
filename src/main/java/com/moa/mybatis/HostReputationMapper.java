package com.moa.mybatis;

import com.moa.model.vo.HostReputationVO;

public interface HostReputationMapper {
    HostReputationVO selectOne(int articleNum);
}
