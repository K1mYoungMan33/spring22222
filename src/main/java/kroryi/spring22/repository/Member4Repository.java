package kroryi.spring22.repository;

import kroryi.spring22.controller.Member4Dto;
import kroryi.spring22.entity4.Member4;
import kroryi.spring22.entity5.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;


public interface Member4Repository extends JpaRepository<Member4, Long> {


    Page<Member4> findByUsernameContains(String username, Pageable pageable );

    Page<Member4> findByAge(int age, Pageable pageable);
    Page<Member4> findByRoles(RoleType age, Pageable pageable);

//    Page<Member4> findByRolesIn(RoleType roles, Pageable pageable);


//    Page<Member4Dto> MemberUserNameSearch( String keyword, Pageable pageable );

    Slice<Member4> findSliceBy(Pageable pageable );
}
