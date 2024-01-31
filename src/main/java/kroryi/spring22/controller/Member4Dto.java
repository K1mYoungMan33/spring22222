package kroryi.spring22.controller;

import kroryi.spring22.entity3.Member3;
import kroryi.spring22.entity3.Team3;
import kroryi.spring22.entity4.Member4;
import kroryi.spring22.entity5.RoleType;
import lombok.Value;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * DTO for {@link Member4}
 */
@Value
//public record Member4Dto(Long id, String username, int age, Team3 team, Set<RoleType> roles) implements Serializable {}
public class Member4Dto implements Serializable {
    Long id;
    String username;
    int age;
//    Team3 team;
    Set<RoleType> roles;

    public Member4Dto(Member3 member3, Long id, String username, int age, Team3 team, Set<RoleType> roles) {
        this.id = id;
        this.username = username;
        this.age = age;
//        this.team = team;
        this.roles = roles;
    }

    public Member4Dto(Member3 member3) {
        id = member3.getId();
        username = member3.getUsername();
        age = member3.getAge();
//        team = member3.getTeam();
        roles = new HashSet<>();
    }

    public Member4Dto(Member4Dto member3) {
        id = member3.getId();
        username = member3.getUsername();
        age = member3.getAge();
//        team = member3.getTeam();
        roles = member3.getRoles();
    }
}

