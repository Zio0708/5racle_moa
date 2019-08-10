package com.moa.controller;

import com.moa.message.TransactionStateMessaage;
import com.moa.model.service.LuggageReceiveRecordServiceImpl;
import com.moa.model.service.LuggageRequestApproveServiceImpl;
import com.moa.model.service.MyStorageServiceImpl;
import com.moa.model.vo.SimpleHostRequestVO;
import com.moa.model.vo.SimpleStorageBoardVO;
import com.moa.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hostpage")
public class HostPageController {
    @Autowired
    private LuggageReceiveRecordServiceImpl receiveService;
    @Autowired
    private LuggageRequestApproveServiceImpl requestService;
    @Autowired
    private MyStorageServiceImpl myStorageService;

    @RequestMapping("")
    public String hostPage(){
        return "confirmyet";
    }

    //승인대기====================================================================
    @RequestMapping(value = "/confirmyet",method = RequestMethod.GET)
    public String confirmYet(){
        return "confirmyet";
    }


    @ResponseBody
    @RequestMapping(value = "/confirmyet/list",method = RequestMethod.GET)
    public Map<String, Object> confirmYetUpdate(HttpServletRequest request,
                                                @RequestParam("curPage") int curPage){

        HttpSession session = request.getSession();//추후 로그인 처리
        int hostId = 1;
        //*****************list logic************************
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("firstNum",(curPage-1)*10+1);
        map.put("lastNum",(curPage-1)*10+10);
        map.put("hostId",hostId);
        map.put("stateType", TransactionStateMessaage.WAITING_APPROVE);
        List<SimpleHostRequestVO> list
                = receiveService.selectLuggageWaitingReceiveRecord(map);


        //******************paging logic*********************
        Map<String,Object> pagingInfo = new HashMap<String,Object>();
        pagingInfo.put("hostId",hostId);
        pagingInfo.put("stateType", TransactionStateMessaage.WAITING_APPROVE);

        int listCnt = receiveService.selectLuggageWaitingReceiveRecordCnt(pagingInfo);
        Pagination pagination = new Pagination(listCnt,curPage,list.size());


        //결과
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("list",list);
        result.put("pagination",pagination);

        return result;
    }

    @RequestMapping(value = "/confirmyet/confirm", method= RequestMethod.GET)
    @ResponseBody
    public boolean confirmCheck(@RequestParam("articleNum") int articleNum,
                             @RequestParam("state") String state){
        boolean result;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("requestNum",articleNum);
        if(state.equals("approve")){
            map.put("newState", TransactionStateMessaage.BEFORE_PAYMENT);
        }
        else{
            map.put("newState", TransactionStateMessaage.REJECT_APPROVE);
        }
        result = requestService.updateTransactionHistory(map);

        return result;
    }

    //승인완료====================================================================
    @RequestMapping(value = "/confirmdone",method = RequestMethod.GET)
    public String confirmDone(){

        return "confirmdone";
    }
    //승인완료/업데이트
    @ResponseBody
    @RequestMapping(value = "/confirmdone/list",method = RequestMethod.GET)
    public Map<String,Object> confirmDoneUpdate(HttpServletRequest request,
                                                @RequestParam("curPage") int curPage){
        HttpSession session = request.getSession();//추후 로그인 처리
        int hostId = 1;


        //*****************list logic************************
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("firstNum",(curPage-1)*10+1);
        map.put("lastNum",(curPage-1)*10+10);
        map.put("hostId",hostId);
        List<SimpleHostRequestVO> list
                = receiveService.selectLuggageWaitingReceiveRecord(map);

        //******************paging logic*********************
        Map<String,Object> pagingInfo = new HashMap<String,Object>();
        pagingInfo.put("hostId",hostId);

        int listCnt = receiveService.selectLuggageWaitingReceiveRecordCnt(pagingInfo);
        Pagination pagination = new Pagination(listCnt,curPage,list.size());

        //결과
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("list",list);
        result.put("pagination",pagination);

        return result;
    }

    //나의보관소====================================================================
    @RequestMapping(value = "/mystorage",method = RequestMethod.GET)
    public String myStorage(){
        return "myStorage";
    }

    @ResponseBody
    @RequestMapping(value = "/mystorage/list", method = RequestMethod.GET)
    public Map<String,Object> myStrotageList(HttpServletRequest request,
                                  @RequestParam("curPage") int curPage){
        Map<String,Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();//추후 로그인 처리
        int hostId = 1;
        //*****************list logic************************
        Map<String,Object> storageInfo = new HashMap<String,Object>();
        storageInfo.put("firstNum",(curPage-1)*10+1);
        storageInfo.put("lastNum",(curPage-1)*10+10);
        storageInfo.put("hostId",hostId);

        List<SimpleStorageBoardVO> list = myStorageService.selectMyStorage(storageInfo);


        //*****************paging logic************************
        Map<String,Object> pagingInfo = new HashMap<String,Object>();
        pagingInfo.put("hostId",hostId);
        int listCnt = myStorageService.selectMyStorageCnt(hostId);

        Pagination pagination = new Pagination(listCnt,curPage,list.size());

        //결과
        result.put("list",list);
        result.put("pagination",pagination);

        return result;
    }

}
