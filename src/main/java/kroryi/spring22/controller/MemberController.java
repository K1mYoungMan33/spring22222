package kroryi.spring22.controller;

import kroryi.spring22.dto.Member3Dto;
import kroryi.spring22.entity3.Member3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
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
    public Page<Member4Dto> member_list(
            @RequestParam(defaultValue = "0", value = "page") int pageNo,
            @RequestParam(defaultValue = "username", value = "orderby") String criteria,
            @RequestParam(defaultValue = "DESC", value = "sort") String sort
    ){

//        return memberService.getMemberList( pageNo, 5 );
        return memberService.getMemberList( pageNo, criteria, sort, 5 );
    }
    @GetMapping("/lis2t")
    public Page<Member4Dto> member_list2(
            @RequestParam(defaultValue = "0", value = "page") int pageNo,
            @RequestParam(defaultValue = "username", value = "orderby") String criteria,
            @RequestParam(defaultValue = "DESC", value = "sort") String sort,
            @RequestParam(defaultValue = "", value = "keyword") String keyword
    ){
        if ( keyword == null )
        {
            return member_list( pageNo, criteria, sort );
        }
        return memberService.MemberUserNameSearch( pageNo, criteria, sort, keyword, 5 );
    }
    @GetMapping("/li3st")
    public Page<Member4Dto> member_list3(
            @RequestParam(defaultValue = "0", value = "page") int pageNo,
            @RequestParam(defaultValue = "username", value = "orderby") String criteria,
            @RequestParam(defaultValue = "DESC", value = "sort") String sort,
            @RequestParam(defaultValue = "1", value = "stype") int stype,
            @RequestParam(defaultValue = "", value = "keyword") String keyword
    ){
        if ( keyword == null )
            return member_list( pageNo, criteria, sort );
        return switch (stype) {
            case 1 -> memberService.MemberUserNameSearch(pageNo, criteria, sort, keyword, 5);
            case 2 -> memberService.MemberAgeSearch(pageNo, criteria, sort, keyword, 5);
            case 3 -> memberService.MemberRolesSearch(pageNo, criteria, sort, keyword, 5);
//            default -> memberService.MemberList(pageNo, criteria, sort);
            default -> null;
        };
    }

    @GetMapping("/l4ist")
    public Slice<Member4Dto> member_list4(
            @RequestParam(defaultValue = "0", value = "page") int pageNo,
            @RequestParam(defaultValue = "username", value = "orderby") String criteria,
            @RequestParam(defaultValue = "DESC", value = "sort") String sort
    ){
        return memberService.MemberFindSliceBy( pageNo, criteria, sort, 50);
    }


}
