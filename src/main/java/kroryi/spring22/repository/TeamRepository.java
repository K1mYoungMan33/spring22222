package kroryi.spring22.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kroryi.spring22.entity3.Member3;
import kroryi.spring22.entity3.Team3;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TeamRepository {
    @PersistenceContext
    private EntityManager em;

    public Team3 save( Team3 team ) {
        em.persist( team );
        return team;
    }

    public void delete( Team3 team ) {
        em.remove( team );
    }

    public Map<String, Object> findAll3(Team3 team ){
        return em.getProperties();
    }
    public Team3 findAll2( Team3 team ){
        return em.find( Team3.class, team );
    }
    public List<Team3> findAll(){
        return em.createQuery( "select t from Team3 t", Team3.class )
                .getResultList();
    }

    public Optional<Team3> findById(Long id){
        return Optional.ofNullable( em.find( Team3.class, id ) );
    }




}
