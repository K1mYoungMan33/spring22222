package kroryi.spring22.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kroryi.spring22.entity2.Member2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberJPARepository {
    @PersistenceContext
    private EntityManager em;

    public Member2 save(Member2 member){
        em.persist(member);
        return member;
    }

    public void delete(Member2 member){
        em.remove(member);
    }

    public List<Member2> findAll(){
        return em.createQuery("select m from Member2 m",Member2.class)
                .getResultList();
    }

    public Optional<Member2> findById(Long id) {
        return Optional.ofNullable(em.find(Member2.class, id));
    }

    public long count(){
        return em.createQuery("select count(m) from Member2 m", Long.class)
                .getSingleResult();
    }

    public Member2 find(Long id) {
        return em.find(Member2.class, id);
    }

    public static interface Member2Repository extends JpaRepository<Member2, Long> {
        @Query("select m from Member2 m where m.id in ?1")
        Optional<Member2> findByIdIn(Collection<Long> ids);
    }
}