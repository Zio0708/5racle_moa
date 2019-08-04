package com.moa.mybatis;

//MemberMapper.xml과 이름이 동일 해야함

import com.example.springmvc.vo.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MemberMapper {
    List<Member> getAllMembers();
    int insertMember(Member member);
    int deleteMember(String id);
    int updateMember(Map<String, Object> map);
    Member selectOne(String search_id);
    List<Member> selectOneByLike(Map<String, Object> map);
    List<Member> selectMultiCondition(Map<String, Object> map);
    int deleteMultiMember(Member member);
}
