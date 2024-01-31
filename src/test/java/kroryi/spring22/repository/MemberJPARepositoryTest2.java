package kroryi.spring22.repository;

import kroryi.spring22.entity3.Member3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional//transaction이 쭉 보다가 마지막에 변경감지(dirty checking)
@Rollback(false)
class MemberJPARepositoryTest2 {
    @Autowired
    Member3Repository mem3repo;

    @Test
    public void findByNames(){
        List<Member3> result = mem3repo.findAll();
        for ( Member3 member : result )
            System.out.println( "member = " + member );
        assertThat(true);
        assertThat(false);
    }

    @Test
    public void findByUsername(){
        List<Member3> result = mem3repo.findByUsername( "member1" );
//        result.ifPresent(member3 -> System.out.println("member = " + member3.getUsername()));

        for ( Member3 member : result )
            System.out.println( "member = " + member );
    }

    @Test
    public void findByAgeLessThan(){
//        List<Member3> result = mem3repo.findByAgeLessThanAllIgnoreCase( 29
//        , Sort.by(Sort.Direction.ASC, "age")
//                );
        List<Member3> result = mem3repo.findByAgeLessThan( 29 );

        for ( Member3 member : result )
            System.out.println( "member = " + member );

    }

}