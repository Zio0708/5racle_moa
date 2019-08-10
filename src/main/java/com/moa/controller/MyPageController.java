package com.moa.controller;


import com.moa.message.MessengerStateMessage;
import com.moa.model.service.LuggageRequestInfoService;
import com.moa.model.service.LuggageRequestRecordService;
import com.moa.model.service.MessengerListServiceImpl;
import com.moa.model.vo.MessageVO;
import com.moa.model.vo.ReadStoreRequestVO;
import com.moa.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/mypage")
public class MyPageController {
    @Autowired
    private LuggageRequestRecordService luggageRequestRecordService;
    @Autowired
    private LuggageRequestInfoService luggageRequestInfoService;
    @Autowired
    private MessengerListServiceImpl messengerListService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public ModelAndView myPage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("profileName", "profile.jpg");
        mav.addObject("userName", "김모아");
        mav.addObject("userEmail", "moa@google.com");
        mav.addObject("requestCnt", 0);
        mav.addObject("notReadMessageCnt", 0);
        mav.addObject("usingStorageCnt", 2);
        mav.setViewName("myPage");
        return mav;
    }

    @RequestMapping(value="/requestlist", method=RequestMethod.GET)
    public ModelAndView myPageRequestList(){
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map;

        map = luggageRequestRecordService.selectLuggageRequestRecord(28);

        mav.addObject("requestList", map.get("requestList"));
        mav.addObject("productList", map.get("productList"));
        System.out.println("set attribute success");
        mav.setViewName("requestList");

        return mav;
    }

    @RequestMapping(value="/requestlist/{requestNum}", method = RequestMethod.GET)
    @ResponseBody
    public ReadStoreRequestVO myPageRequestInfo(@PathVariable("requestNum") int requestId){
        ReadStoreRequestVO requestVO = luggageRequestInfoService.selectLuggageRequestInfo(requestId);
        System.out.println(requestVO);
        requestVO.setApplicationDate(requestVO.getApplicationDate());
        return requestVO;
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/error/page");
        mav.addObject("message","존재하지 않는 페이지 입니다.");
        return mav;
    }
    @RequestMapping(value = {"/message/receive","/message"})
    public ModelAndView message(HttpServletRequest request){
        HttpSession session = request.getSession();//추후 로그인 처리
        int userId = 7;
        ModelAndView mav = new ModelAndView();

        //--list logic
        Map<String,Object> messageInfo = new HashMap<String,Object>();
        messageInfo.put("messageType",MessengerStateMessage.MESSAGE_TYPE_RECEIVER);
        messageInfo.put("userId",userId);
        messageInfo.put("firstNum",1);
        messageInfo.put("lastNum",10);

        List<MessageVO> list = messengerListService.messageList(messageInfo);
        int allListCnt = messengerListService.messageListCnt(messageInfo);

        //--paging logic
        Pagination pagination = new Pagination(allListCnt,1,list.size());

        //ModelAndView
        mav.setViewName("messageReceive");
        mav.addObject(list);
        mav.addObject(pagination);

        System.out.println(mav);

        return mav;
    }
    @RequestMapping("/message/receive/{curPage}")
    public ModelAndView messageCurPage(HttpServletRequest request,
                                       @PathVariable int curPage){
        HttpSession session = request.getSession();//추후 로그인 처리
        int userId = 7;
        ModelAndView mav = new ModelAndView();

        //--list logic
        Map<String,Object> messageInfo = new HashMap<String,Object>();
        messageInfo.put("messageType",MessengerStateMessage.MESSAGE_TYPE_RECEIVER);
        messageInfo.put("userId",userId);
        messageInfo.put("firstNum",(curPage-1)*10+1);
        messageInfo.put("lastNum",(curPage-1)*10+10);

        List<MessageVO> list = messengerListService.messageList(messageInfo);
        int allListCnt = messengerListService.messageListCnt(messageInfo);

        //--paging logic
        Pagination pagination = new Pagination(allListCnt,1,list.size());

        //ModelAndView
        mav.setViewName("messageReceive");
        mav.addObject(list);
        mav.addObject(pagination);

        System.out.println(mav);

        return mav;
    }

    //보낸 메세지
    @RequestMapping("/message/send")
    public ModelAndView messageSend(HttpServletRequest request){
        HttpSession session = request.getSession();//추후 로그인 처리
        int userId = 7;
        ModelAndView mav = new ModelAndView();

        //--list logic
        Map<String,Object> messageInfo = new HashMap<String,Object>();
        messageInfo.put("messageType", MessengerStateMessage.MESSAGE_TYPE_SENDER);
        messageInfo.put("userId",userId);
        messageInfo.put("firstNum",1);
        messageInfo.put("lastNum",10);

        List<MessageVO> list = messengerListService.messageList(messageInfo);
        int allListCnt = messengerListService.messageListCnt(messageInfo);

        //--paging logic
        Pagination pagination = new Pagination(allListCnt,1,list.size());

        //ModelAndView
        mav.setViewName("messageSend");
        mav.addObject(list);
        mav.addObject(pagination);

        System.out.println(mav);

        return mav;
    }

    //메시지 상세보기
    @RequestMapping("/message/send/detail/{messageNum}")
    public ModelAndView messageSendDetail(@PathVariable int messageNum){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageDetail");
        MessageVO msg = messengerListService.messageDetail(messageNum);
        mav.addObject("messageInfo",msg);
        mav.addObject("messageType","send");
        return mav;
    }
    @RequestMapping("/message/receive/detail/{messageNum}")
    public ModelAndView messageReceiveDetail(@PathVariable int messageNum){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageDetail");
        MessageVO msg = messengerListService.messageDetail(messageNum);
        mav.addObject("messageInfo",msg);
        mav.addObject("messageType","receive");
        return mav;
    }
    @RequestMapping(value = "/message/submit", method = RequestMethod.POST)
    public ModelAndView messageSubmitReceiver(@RequestParam String receiverNick){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageSendDetail");
        mav.addObject("receiveNick", receiverNick);
        //SESSION에 있는 닉네임 정보
        mav.addObject("userNick","성진킴");
        return mav;
    }
    @RequestMapping(value = "/message/submit", method = RequestMethod.GET)
    public ModelAndView messageSubmit(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageSendDetail");
        //SESSION에 있는 닉네임 정보
        mav.addObject("userNick","성진킴");
        return mav;
    }
}
