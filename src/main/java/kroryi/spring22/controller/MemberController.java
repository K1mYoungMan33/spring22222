package kroryi.spring22.controller;

import kroryi.spring22.dto.Member3Dto;
import kroryi.spring22.entity3.Member3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberServiceImpl memberService;

    @GetMapping("/list")
//    public Page<Member3Dto> member_list(@RequestParam(value = "page") int pageNo ){
    public Page<Member4Dto> member_list(@RequestParam(value = "page") int pageNo ){

//        return memberService.getMemberList( pageNo, 5 );
        return memberService.getMemberList( pageNo, 5 );
    }
}
