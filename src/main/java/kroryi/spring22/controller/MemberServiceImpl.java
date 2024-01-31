package kroryi.spring22.controller;

import kroryi.spring22.dto.Member3Dto;
import kroryi.spring22.entity3.Member3;
import kroryi.spring22.repository.Member3Repository;
import kroryi.spring22.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl {

    @Autowired
    MemberRepository memberRepository;
//    Page<Member4Dto> getMemberList(int pageNo, String criteria, String sort, int pageSize_ ){
    Page<Member4Dto> getMemberList(int pageNo, int pageSize_ ){
        int pageSize = ( pageSize_ < 1 ? 5 : pageSize_ );



//        Pageable pageableEx = (sort.equals("ASC")) ?
//                PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, criteria))
//                : PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, criteria));
//
////        return boardRepository.findAll(pageable).map(BoardResponseDto::new);


        Pageable pageable = PageRequest.of( pageNo, pageSize );

//        pageable.getOffset();
//        pageable.getPageNumber();
//        pageable.first();
//        pageable.getPageSize();
//        pageable.getSort();
//        pageable.getPageSize();
//        pageable.getPageSize();
//        pageable.getPageSize();



//        return memberRepository.findAll();
//        return memberRepository.findAll(pageable);
//        return memberRepository.findAll(pageable).map((Function<? super Member3, ? extends Member4Dto>) Member4Dto::new);
//        return memberRepository.findAll(pageable).map(Member4Dto::new);

//        return memberRepository.findAll(pageable).map(Member3Dto::new);
        return memberRepository.findAll(pageable).map(Member4Dto::new);
    }

}
