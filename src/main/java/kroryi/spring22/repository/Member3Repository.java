package kroryi.spring22.repository;

import kroryi.spring22.entity3.Member3;
import kroryi.spring22.entity4.Member4;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Member3Repository extends JpaRepository<Member3, Long> {



//    Optional<Member3> findByUsername(String username);
//    @Query("select m from Member3 m where m.username = ?1")
    List<Member3> findByUsername(String username);


    List<Member3> findByAgeLessThanAllIgnoreCase(int age, Sort sort);

    Optional<Member3> findByTeam_Name(String name);

    Optional<Member3> findByUsernameAndTeam_Name(String username, String name);

    long countById(Long id);

    boolean existsByUsername(String username);

//    @Query("select m from Member3 m where m.age = ?1")
//    Optional<Member3> findByAge(int age);
//    @Query("select m from Member3 m where m.age = ?1")
    List<Member3> findByAgeLessThan(int age);





//    ALTER TABLE springsite.member3 AUTO_INCREMENT = 111;

    @Query("select m from Member3 m left join fetch m.team")
    List<Member3> findMemberFetchJoin();


    @EntityGraph(attributePaths = {"team"})
    List<Member3> findAll();


    @Query( value="select m, m.team from Member3 m JOIN m.team where m.username=:username")
    List<Member3> memberList(@Param("username") String username );

    @Query("select m from Member3 m where m.team.name = ?1 and m.username = ?2")
    List<Member3> findByTa_NaenUeae(String name, String username);

    @Query(value="select * from member3 where age >:age", nativeQuery = true)
    List<Member4> memberListNative(@Param("age") int age );



}