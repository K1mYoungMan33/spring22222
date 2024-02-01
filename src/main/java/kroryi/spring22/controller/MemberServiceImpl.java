package kroryi.spring22.controller;

import kroryi.spring22.entity5.RoleType;
import kroryi.spring22.repository.Member4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl {

    @Autowired
    Member4Repository memberRepository;
//    Page<Member4Dto> getMemberList(int pageNo, String criteria, String sort, int pageSize_ ){
    Page<Member4Dto> getMemberList(int pageNo, String criteria, String sort, int pageSize_ ){
        int pageSize = ( pageSize_ < 1 ? 5 : pageSize_ );



        Pageable pageableEx = (sort.equals("ASC")) ?
                PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, criteria))
                : PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, criteria));
//
////        return boardRepository.findAll(pageable).map(BoardResponseDto::new);


        Pageable pageable = PageRequest.of( pageNo, pageSize );

//        pageable.getOffset();
//        pageable.getPageNumber();
//        pageable.first();
//        pageable.getPageSize();
//        pageable.getSort();
//        pageable.toLimit();
//        pageable.();



//        return memberRepository.findAll();
//        return memberRepository.findAll(pageable);
//        return memberRepository.findAll(pageable).map((Function<? super Member3, ? extends Member4Dto>) Member4Dto::new);
//        return memberRepository.findAll(pageable).map(Member4Dto::new);

//        return memberRepository.findAll(pageable).map(Member3Dto::new);
//        return memberRepository.findAll(pageable).map(Member4Dto::new);
        return memberRepository.findAll(pageableEx).map(Member4Dto::new);
    }


//    Page<Member4Dto> MemberUserNameSearch( String keyword, Pageable pageable )
    Page<Member4Dto> MemberUserNameSearch( int pageNo, String criteria, String sort, String keyword, int pageSize_ )
    {
        int pageSize = ( pageSize_ < 1 ? 5 : pageSize_ );

        Pageable pageable = (sort.equals("ASC")) ?
                PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, criteria))
                : PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, criteria));


        Pageable pageable2 = PageRequest.of(pageNo, pageSize, Sort.by( Sort.Direction.fromString(sort), criteria));


        return memberRepository.findByUsernameContains(keyword, pageable ).map(Member4Dto::new);
    }


    Page<Member4Dto> MemberAgeSearch( int pageNo, String criteria, String sort, String keyword, int pageSize_ )
    {
        int pageSize = ( pageSize_ < 1 ? 5 : pageSize_ );

        Pageable pageable = (sort.equals("ASC")) ?
                PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, criteria))
                : PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, criteria));


        return memberRepository.findByAge(Integer.parseInt(keyword), pageable ).map(Member4Dto::new);
    }
    Page<Member4Dto> MemberRolesSearch( int pageNo, String criteria, String sort, String keyword, int pageSize_ )
    {
        int pageSize = ( pageSize_ < 1 ? 5 : pageSize_ );

        Pageable pageable = (sort.equals("ASC")) ?
                PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, criteria))
                : PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, criteria));


//        return memberRepository.findByUsernameContains(keyword, pageable ).map(Member4Dto::new);
//        return memberRepository.findByRolesIn(keyword, pageable ).map(Member4Dto::new);
        return memberRepository.findByRoles(RoleType.valueOf(keyword), pageable ).map(Member4Dto::new);
    }


    Slice<Member4Dto> MemberFindSliceBy( int pageNo, String criteria, String sort, int pageSize_ )
    {
        int pageSize = ( pageSize_ < 1 ? 5 : pageSize_ );

        Pageable pageable = (sort.equals("ASC")) ?
                PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, criteria))
                : PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, criteria));

        return memberRepository.findSliceBy(pageable ).map(Member4Dto::new);
    }

}
