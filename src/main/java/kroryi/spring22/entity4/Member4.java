package kroryi.spring22.entity4;

import jakarta.persistence.*;
import kroryi.spring22.entity3.Member3;
import kroryi.spring22.entity5.RoleType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member4 extends Member3 {
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.ORDINAL)
//    private Long role;
    private Set<RoleType> roles = new HashSet<>();

//    public static RoleString
}
