package com.moa.controller;

import com.example.springmvc.service.MemberService;
import com.example.springmvc.vo.Member;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Locale;


@RequestMapping("/member")
@Controller
public class MemberController {
    private Log logger= LogFactory.getLog(MemberController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MemberService service;

    @RequestMapping("/signup")
    public String signup(){
        return "/member/register";
    }

//    public String signupProc(@RequestParam(value="id") String id, @RequestParam(value="pwd") String pwd, @RequestParam(value="name") String name){
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupProc(Member member){
        System.out.println(member);
        service.insertMember(member);
        return "redirect:/member/tables";
    }

    @RequestMapping("/tables")
    public ModelAndView tables(){
        //log level TRACE < DEBUG < INFO < WARN < ERROR < FATAL
        // DEFAULT LOG LEVEL = INFO
        // DOESNT PRINT LOG IF LOWER THEN SETTING LOG LEVEL
        logger.info(messageSource.getMessage("members.title",null, Locale.ENGLISH));
        logger.trace( "called tables method with trace" );
        logger.debug("called tables method with debug");
        logger.warn(messageSource.getMessage("greeting.message",new String[]{"yejun"}, Locale.getDefault()));
        logger.error("called tables method with error");
        logger.fatal("called tables method with fatal");
        ModelAndView mav=new ModelAndView();
        mav.setViewName("member/tables");
        mav.addObject("members",service.getAllMember());
        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView retrieveAllMember(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("member/list");
        mav.addObject("members",service.getAllMember());
        return mav;
    }

    @RequestMapping(value="/deleteAll", method = RequestMethod.POST)
    public String deleteMember(@RequestParam(value="del_chk") String[] id){
        Member delMember=new Member();
        delMember.setIds(id);
        service.removeMembers(delMember);
        return "redirect:/member/tables";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleException(NullPointerException e){
        logger.error(e.getMessage());
        return "/error/page";
    }

    //@ResponseStatus(value = HttpStatus.ACCEPTED) //200
    //@ResponseStatus(value=HttpStatus.NOT_FOUND) // 404
    @ExceptionHandler(DataAccessException.class)
//    @ResponseStatus(value = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED, reason = "My response status changed to NETWORK ...")
    public ModelAndView handleSQLException(DataAccessException e){
        logger.error(e.getMessage());
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/error/page");
        mav.addObject("message","현재 DB점검중입니다.");
        return mav;
    }

    @RequestMapping(value = "/join", method= RequestMethod.GET)
    public String join(Model model) {
        model.addAttribute("memberForm",new Member());
        return "/member/join";
    }

    @RequestMapping(value="/join", method = RequestMethod.POST)
    public String joinProc(@Valid @ModelAttribute("memberForm") Member member, BindingResult result){
        if(result.hasErrors()) {

            return "/member/join";
        }
        service.insertMember(member);
        return "/member/table";
    }
}
