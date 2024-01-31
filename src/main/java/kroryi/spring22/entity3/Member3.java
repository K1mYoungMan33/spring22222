package kroryi.spring22.entity3;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","username","age","team"})
public class Member3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_id")
    private Team3 team;

    public Member3(String username){
        this.username = username;
    }
    public Member3(String username, int age, Team3 team ){
        this.username = username;
        this.age = age;
        if ( team != null) { changeTeam(team); }
    }
    public void changeTeam( Team3 team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
