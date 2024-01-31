package kroryi.spring22.entity4;

import jakarta.persistence.*;
import kroryi.spring22.entity3.Member3;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content", length = 999999999)
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_3_member_id")
    private Member3 member3;

}