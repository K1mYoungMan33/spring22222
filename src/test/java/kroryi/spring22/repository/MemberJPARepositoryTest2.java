package kroryi.spring22.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kroryi.spring22.entity3.Member3;
import kroryi.spring22.entity3.Team3;
import kroryi.spring22.entity4.Member4;
import kroryi.spring22.entity5.RoleType;
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

    @Test
    public void findAllTest(){
        List<Member3> result = mem3repo.findAll();

        for ( Member3 member : result )
            System.out.println( "member = " + member );
    }



    @PersistenceContext
    EntityManager em;
    @Test
    public void roleTest(){
        Member4 member1 = new Member4();// "회원권한1" );
        member1.setUsername( "홍길동" );
        member1.setAge(12);
        Team3 team1 = new Team3( "경리부" );
        member1.setTeam( team1 );
        member1.getRoles().add( RoleType.USER );

        Member4 member2 = new Member4();// "회원권한2" );
        member2.setUsername( "이순신" );
        member2.setAge(30);
        Team3 team2 = new Team3( "생산부" );
        member2.setTeam( team2 );
        member2.getRoles().add( RoleType.ADMIN );

        System.out.println( member1 );
        System.out.println( member2 );


        em.persist(team1);
        em.persist(team2);
        em.persist(member1);
        em.persist(member2);

        em.flush();//강제로 영속성 컨텍스트의 모아놨던 Insert 쿼리 다 날려버림
        em.clear();//영속성 컨텍스트의 캐시까지 깔끔하게 날려버림

    }


    @Test
    public void queryTest() {


        {
            List<Member3> result = mem3repo.memberList( "이순신" );
            for ( Member3 member : result )
                System.out.println( "member = " + member );
        }


        {
            List<Member3> result = mem3repo.findByTa_NaenUeae( "생산부", "이순신" );
            for ( Member3 member : result )
                System.out.println( "member = " + member );
        }

        {
            List<Member4> result = mem3repo.memberListNative( 21 );
            for ( Member4 member : result )
                System.out.println( "member = " + member );
        }


    }
}