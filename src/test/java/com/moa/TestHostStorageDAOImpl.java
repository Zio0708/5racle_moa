package com.moa;


import com.moa.model.dao.HostStorageDAO;
import com.moa.model.dao.StoreRequestDAO;
import com.moa.model.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
//test 할 경우에는 tomcat이 구동되어 xml파일들이 연동되는 것이 아니기 때문에 따로 연동시켜야한다.
@ContextConfiguration(locations ={
        "file:web/WEB-INF/dispatcher-servlet.xml",
        "file:web/WEB-INF/mybatis-config.xml"
})
@WebAppConfiguration
public class TestHostStorageDAOImpl {
    @Autowired
    private HostStorageDAO hostStorageDAO;
    @Autowired
    private StoreRequestDAO storeRequestDAO;

    @Test
    public void test_호스트신청_신규상가(){
        boolean res =  hostStorageDAO.insertNewCompany(new NewCompanyStorageVO(1,1,"1","1","1",29,"1","1","1"));

        assertTrue(res == true);
    }
    @Test
    public void test_호스트신청_신규집(){
        boolean res =  hostStorageDAO.insertNewHome(new NewHomeStorageVO(1,1,"1","1","1", 29));

        assertTrue(res == true);
    }
    @Test
    public void test_호스트신청_신규기타(){
        boolean res =  hostStorageDAO.insertNewOther(new NewOtherStorageVO(1,1,"1","1","1",29, "1"));

        assertTrue(res == true);
    }
    @Test
    public void test_호스트신청_기존상가(){
        boolean res =  hostStorageDAO.insertOriginCompany(new OriginCompanyStorageVO(29,29,"1","1","1"));

        assertTrue(res == true);
    }
    @Test
    public void test_호스트신청_기존집(){
        boolean res =  hostStorageDAO.insertOriginHome(new OriginHomeStorageVO(29,29));

        assertTrue(res == true);
    }
    @Test
    public void test_호스트신청_기존기타(){
        boolean res =  hostStorageDAO.insertOriginOther(new OriginOtherStorageVO(29,29,"1"));

        assertTrue(res == true);
    }

    @Test
    public void test_요청목록(){
        storeRequestDAO.searchList(28);
    }
}
