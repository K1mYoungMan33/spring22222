package kroryi.spring22.repository;

import kroryi.spring22.dto.Member3Dto;
import kroryi.spring22.entity3.Member3;
import kroryi.spring22.entity4.Member4;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member4, Long> {
}
