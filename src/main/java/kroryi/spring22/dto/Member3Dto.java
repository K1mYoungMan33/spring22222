package kroryi.spring22.dto;

import kroryi.spring22.entity3.Member3;
import kroryi.spring22.entity3.Team3;
import lombok.Value;

import java.io.Serializable;
import java.util.HashSet;

/**
 * DTO for {@link kroryi.spring22.entity3.Member3}
 */
@Value
public class Member3Dto implements Serializable {
    Long id;
    String username;
    int age;
//    Team3 team;

    public Member3Dto(Member3Dto member3) {
        id = member3.getId();
        username = member3.getUsername();
        age = member3.getAge();
//        team = member3.getTeam();
    }
}