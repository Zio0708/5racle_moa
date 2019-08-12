package com.moa.controller;


import com.moa.message.MessengerStateMessage;
import com.moa.model.service.LuggageRequestInfoService;
import com.moa.model.service.LuggageRequestRecordService;
import com.moa.model.service.MessengerListServiceImpl;
import com.moa.model.vo.MessageVO;
import com.moa.model.service.MemberInfoService;
import com.moa.model.vo.ReadStoreRequestVO;
import com.moa.paging.Pagination;
import com.moa.model.vo.SimpleUserInfoVO;
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
    @Autowired
    private MemberInfoService memberInfoService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public ModelAndView myPage() {
        ModelAndView mav = new ModelAndView();
        int userId = 28;
        SimpleUserInfoVO simpleUserInfoVO = memberInfoService.selectMemberInfo(userId);

        mav.addObject("profileName", simpleUserInfoVO.getProfileName());
        mav.addObject("userName", simpleUserInfoVO.getName());
        mav.addObject("userEmail", simpleUserInfoVO.getEmail());
        mav.addObject("requestCnt", simpleUserInfoVO.getRequestCnt());
        mav.addObject("notReadMessageCnt", simpleUserInfoVO.getNotReadMessageCnt());
        mav.addObject("usingStorageCnt", simpleUserInfoVO.getUsingStorageCnt());
        mav.setViewName("myPage");
        return mav;
    }

    @RequestMapping(value="/requestlist/{curPage}", method=RequestMethod.GET)
    public ModelAndView myPageRequestList(@PathVariable("curPage") int curPage){
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map;
        int userId = 28;
        int totPageCnt = 0;

        map = luggageRequestRecordService.selectLuggageRequestRecord(userId, curPage);
        totPageCnt = luggageRequestRecordService.LuggageRequestCountService(userId);

        mav.addObject("requestList", map.get("requestList"));
        mav.addObject("productList", map.get("productList"));
        mav.addObject("totPageCnt", totPageCnt);
        mav.addObject("curPage", curPage);

        mav.setViewName("requestList");

        return mav;
    }

    @RequestMapping(value="/requestlist/info/{requestNum}", method = RequestMethod.GET)
    @ResponseBody
    public ReadStoreRequestVO myPageRequestInfo(@PathVariable("requestNum") int requestId){
        ReadStoreRequestVO requestVO = luggageRequestInfoService.selectLuggageRequestInfo(requestId);

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
        Pagination pagination = new Pagination(allListCnt,curPage,list.size());

        //ModelAndView
        mav.setViewName("messageReceive");
        mav.addObject(list);
        mav.addObject(pagination);



        return mav;
    }

    //보낸 메세지

    @RequestMapping("/message/send")
    public ModelAndView messageSendCurPage(HttpServletRequest request){
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


        return mav;
    }
    @RequestMapping("/message/send/{curPage}")
    public ModelAndView messageSend(HttpServletRequest request,
                                    @PathVariable int curPage){
        HttpSession session = request.getSession();//추후 로그인 처리
        int userId = 7;
        ModelAndView mav = new ModelAndView();

        //--list logic
        Map<String,Object> messageInfo = new HashMap<String,Object>();
        messageInfo.put("messageType", MessengerStateMessage.MESSAGE_TYPE_SENDER);
        messageInfo.put("userId",userId);
        messageInfo.put("firstNum",(curPage-1)*10+1);
        messageInfo.put("lastNum",(curPage-1)*10+10);

        List<MessageVO> list = messengerListService.messageList(messageInfo);
        int allListCnt = messengerListService.messageListCnt(messageInfo);

        //--paging logic
        Pagination pagination = new Pagination(allListCnt,curPage,list.size());

        //ModelAndView
        mav.setViewName("messageSend");
        mav.addObject(list);
        mav.addObject(pagination);



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
    @RequestMapping(value = {"/message/submit"}, method = RequestMethod.GET)
    public ModelAndView messageSubmitForm(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageSendDetail");

        //SESSION에 있는 닉네임 정보
        mav.addObject("userNick","성진킴");
        return mav;
    }
    @ResponseBody
    @RequestMapping(value = {"/message/sendmessage"}, method = RequestMethod.POST)
    public boolean messageSubmit(@RequestBody Map<String,Object> messageSendInfo){
        if(memberInfoService.checkExistUser((String)messageSendInfo.get("receiverNick"))==false){
            return false;
        }
        return messengerListService.messageSend(messageSendInfo);
    }
    @RequestMapping(value = {"/message/submit/{receiverNick}"}, method = RequestMethod.GET)
    public ModelAndView messageReply(@PathVariable String receiverNick){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("messageSendDetail");
        if(!receiverNick.equals("") || receiverNick != null){
            mav.addObject("receiverNick",receiverNick);
        }
        //SESSION에 있는 닉네임 정보
        mav.addObject("userNick","성진킴");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/message/read/{messageNumber}")
    public boolean messageRead(@PathVariable int messageNumber){
        return messengerListService.messageRead(messageNumber);
    }


}
