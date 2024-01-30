package kroryi.spring22.entity2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "team")
    private Set<Member2> member2s = new LinkedHashSet<>();

}