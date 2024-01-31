package kroryi.spring22.repository;

import kroryi.spring22.entity3.Member3;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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


}