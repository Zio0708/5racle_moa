package com.moa.model.dao;

import com.example.springmvc.vo.Member;

import java.util.List;
import java.util.Map;

public interface MemberDAO {
    List<Member> findAllMembers();
    int addMember(Member member);
    int deleteMember(String id);
    int modifyMember(Map<String, Object> map);
    Member searchOne(String search_id);
    List<Member> searchOneByLike(Map<String, Object> map);
    List<Member> searchByMultiCondition(Map<String, Object> map);
    int deleteMultiMember(Member member);
}
