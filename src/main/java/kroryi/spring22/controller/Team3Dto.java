package kroryi.spring22.controller;

import kroryi.spring22.entity3.Team3;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link kroryi.spring22.entity3.Team3}
 */
@Value
public class Team3Dto implements Serializable {
    Long id;
    String name;

    public Team3Dto(Team3 team) {
        this.id = team.getId();
        this.name = team.getName();
    }
}