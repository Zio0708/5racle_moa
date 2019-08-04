package com.moa.dao;

import com.example.springmvc.mybatis.MemberMapper;
import com.example.springmvc.vo.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    private SqlSession sqlSession;
    public List<Member> findAllMembers() {
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        List<Member> list=mapper.getAllMembers();
        return list;
    }

    public int addMember(Member member) {
        int res=0;
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        try {
            res= mapper.insertMember(member);
        }catch(Exception e){
            res=0;
        }finally {
            return res;
        }
    }

    @Override
    public int deleteMember(String id) {
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        return mapper.deleteMember(id);
    }

    @Override
    public int modifyMember(Map<String, Object> map) {
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        return mapper.updateMember(map);
    }

    @Override
    public Member searchOne(String search_id) {
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        return mapper.selectOne(search_id);
    }

    @Override
    public List<Member> searchOneByLike(Map<String,Object> map) {
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        return mapper.selectOneByLike(map);
    }

    @Override
    public List<Member> searchByMultiCondition(Map<String, Object> map) {
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        return mapper.selectMultiCondition(map);
    }

    @Override
    public int deleteMultiMember(Member member) {
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        return mapper.deleteMultiMember(member);
    }
}
