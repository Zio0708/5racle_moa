package com.moa.model.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={
        "file:web/WEB-INF/dispatcher-servlet.xml",
        "file:web/WEB-INF/mybatis-config.xml"
})
@WebAppConfiguration
public class TestMessengerService {
    @Autowired
    MessengerListServiceImpl service;
    @Autowired
    MemberInfoService service2;

    @Test
    public void TEST_메세지_보내기(){
        Map<String,Object> messageInfo = new HashMap<String,Object>();
        messageInfo.put("senderNick","성진킴");
        messageInfo.put("receiverNick","JIHO");
        messageInfo.put("content","new test");

        System.out.println(service.messageSend(messageInfo));
    }
    @Test
    public void TEST_유저존재여부(){
        System.out.println(service2.checkExistUser("ㅇㄴㅇ"));
    }
}
