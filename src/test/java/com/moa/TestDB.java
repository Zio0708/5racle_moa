package com.moa;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static junit.framework.TestCase.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/dispatcher-servlet.xml","file:web/WEB-INF/mybatis-config.xml"})
@WebAppConfiguration
public class TestDB {


  /*  @Test
    public void 멤버가져오기(){
        List<Member> list= dao.findAllMembers();
        list.forEach(System.out::println);
//        list.forEach(v-> System.out.println(v));
//        list.forEach(v->{
//            System.out.println(v);s
//        });
        assertNotNull("멤버 가져오기 실패.",list);
    }
    @Test
    public void 멤버추가(){
        Member member=new Member("dldpwns12","adsf456","이예준");
        for(int i=0;i<300;i++){
            Random r=new Random();
            Member m=new Member(RandomStr.ranStr(r.nextInt(15)+6),RandomStr.ranStr(r.nextInt(15)+6), RandomStr.randomHangulName());
            dao.addMember(m);
        }

        assertTrue("멤버 추가 실패", dao.addMember(member)>0);
        assertTrue("멤버 삭제 실패",dao.deleteMember(member.getId())>0);
    }
    @Test
    public void 멤버수정(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id","dldpwns3");
        map.put("pwd","asdzxc2");
        map.put("name","leeyejun");
        assertTrue("멤버 수정 실패",dao.modifyMember(map)>0);
    }
    @Test
    public void 멤버아이디로찾기(){
        String search_id="dldpwns3";
        String search_wrong_id="none_Exist";
        Member member=dao.searchOne(search_id);
        System.out.println(member);
        assertTrue("멤버 아이디로 찾기 실패",member.getId().equals(search_id));

        member=dao.searchOne(search_wrong_id);
        assertNull("멤버 아아디로 찾기 실패",member);
    }
    @Test
    public void 멤버유사아이디로찾기(){
        Map<String,Object> map = new HashMap<>();
        map.put("search_name","예준");
        List<Member> list=dao.searchOneByLike(map);
        list.forEach(a->System.out.println(a));
        assertTrue("멤버 유사아이디로 찾기 실패",list!=null&&!list.isEmpty());
    }
    @Test
    public void 멤버멀티조건으로찾기(){
        Map<String,Object> map = new HashMap<>();
        map.put("search_name","예준");
        List<Member> list=dao.searchByMultiCondition(map);
        list.forEach(a->System.out.println(a));
        System.out.println("\n");
        assertTrue("멤버 멀티조건 이름으로 찾기 실패",list!=null&&!list.isEmpty());


        map.put("search_mem_type",1);
        list=dao.searchByMultiCondition(map);
        list.forEach(a->System.out.println(a));
        System.out.println("\n");
        assertTrue("멤버 멀티조건으로 이름 & 타입으로 찾기 실패",list!=null&&!list.isEmpty());


        map.remove("search_name");
        list=dao.searchByMultiCondition(map);
        list.forEach(a->System.out.println(a));
        assertTrue("멤버 멀티조건으로 타입으로 찾기 실패",list!=null&&!list.isEmpty());
    }

    @Test
    public void 멤버다중삭제(){
        String[] ids={"id1","id2"};
        Member member = new Member();
        member.setIds(ids);
        assertTrue("멤버 다중 삭제 실패",dao.deleteMultiMember(member)>0);
    }*/
}