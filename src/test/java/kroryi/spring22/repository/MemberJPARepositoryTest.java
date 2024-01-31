package kroryi.spring22.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional//transaction이 쭉 보다가 마지막에 변경감지(dirty checking)
@Rollback(false)
class MemberJPARepositoryTest {
    @Autowired
    MemberJPARepository memberJpaRepository;

    @Test
    public void basicCRUD(){
//        Member3 member1 = new Member3("member1");
//        Member3 member2 = new Member3("member2");
//        memberJpaRepository.save(member1);
//        memberJpaRepository.save(member2);
//
//        Member3 findMember1 = memberJpaRepository.findById(member1.getId()).get();
//        Member3 findMember2 = memberJpaRepository.findById(member2.getId()).get();
//        assertThat(findMember1).isEqualTo(member1);
//        assertThat(findMember2).isEqualTo(member2);
//
//        List<Member3> all = memberJpaRepository.findAll();
//        assertThat(all.size()).isEqualTo(2);
//
//        long deletedCount = memberJpaRepository.count();
//        assertThat(deletedCount).isEqualTo(0);
    }
}