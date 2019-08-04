package com.moa.service;

import com.example.springmvc.vo.Member;

import java.util.List;
import java.util.Map;

public interface MemberService {
    List<Member> getAllMember();
    boolean insertMember(Member member);
    boolean removeMember(String id);
    boolean updateMember(Map<String, Object> map);
    Member retrieveMember(String search_id);
    List<Member> retrieveMembersWithLike(Map<String, Object> map);
    List<Member> retrieveMembersWithFilter(Map<String, Object> map);
    boolean removeMembers(Member member);
}
