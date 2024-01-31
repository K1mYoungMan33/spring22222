package kroryi.spring22.entity3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString(of = {"id","name"})
public class Team3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member3> members = new ArrayList<>();

    public Team3(String name){
        this.name = name;
    }
}
