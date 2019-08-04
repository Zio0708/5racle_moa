package com.moa.service;

import com.example.springmvc.dao.MemberDAO;
import com.example.springmvc.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAO dao;
    public List<Member> getAllMember() {
        return dao.findAllMembers();
    }

    @Override
    public boolean insertMember(Member member) {
        return dao.addMember(member) >0 ? true : false;
    }

    @Override
    public boolean removeMember(String id) {
        return dao.deleteMember(id)>0 ? true:false;
    }

    @Override
    public boolean updateMember(Map<String, Object> map) {
        return dao.modifyMember(map)>0? true:false;
    }

    @Override
    public Member retrieveMember(String search_id) {
        return dao.searchOne(search_id);
    }

    @Override
    public List<Member> retrieveMembersWithLike(Map<String, Object> map) {
        return dao.searchOneByLike(map);
    }

    @Override
    public List<Member> retrieveMembersWithFilter(Map<String, Object> map) {
        return dao.searchByMultiCondition(map);
    }

    @Override
    public boolean removeMembers(Member member) {
        return dao.deleteMultiMember(member)>0? true:false;
    }


}
