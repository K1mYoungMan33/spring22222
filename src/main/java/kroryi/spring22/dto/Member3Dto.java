package kroryi.spring22.dto;

import kroryi.spring22.entity3.Team3;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link kroryi.spring22.entity3.Member3}
 */
@Value
public class Member3Dto implements Serializable {
    Long id;
    String username;
    int age;
    Team3 team;
}