package com.moa.controller;

import com.example.springmvc.service.MemberService;
import com.example.springmvc.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/member")
@RestController
public class ApiMemberController {
    @Autowired
    private MemberService service;

    @RequestMapping("")
    public List<Member> retrieveAllMember(){
        return service.getAllMember();
    }
}
