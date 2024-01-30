package kroryi.spring22.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "titles")
public class Title {
    @EmbeddedId
    private TitleId id;

    @Column(name = "to_date")
    private LocalDate toDate;

}