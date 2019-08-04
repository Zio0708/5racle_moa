package com.moa.mybatis;

import com.example.springmvc.vo.HostReputationVO;

public interface HostReputationMapper {
    public HostReputationVO selectOne(int articleNum);
}
