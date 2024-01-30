package kroryi.spring22.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kroryi.spring22.entity3.Member3;
import kroryi.spring22.entity3.Team3;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberTest {
    @PersistenceContext
    EntityManager em;


    @Test
    public void testEntity() {
        Team3 teamA = new Team3("teamA");
        Team3 teamB = new Team3("teamB");

        em.persist(teamA);
        em.persist(teamB);

        Member3 member1 = new Member3("member1", 10, teamA);
        Member3 member2 = new Member3("member1", 20, teamA);
        Member3 member3 = new Member3("member1", 30, teamB);
        Member3 member4 = new Member3("member1", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);


        em.flush();//강제로 영속성 컨텍스트의 모아놨던 Insert 쿼리 다 날려버림
        em.clear();//영속성 컨텍스트의 캐시까지 깔끔하게 날려버림


        List<Member3> members = em.createQuery("select  m from Member3 m", Member3.class)
                .getResultList();

        for (Member3 member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member.team = " + member.getTeam());
        }//iter




    }
}