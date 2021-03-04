package com.logogreatagain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scores_table")
public class Scores {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "day")
    private int day;
    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;
    @Column(name = "points")
    private Long points;

    @ManyToOne
    @Builder.Default
    private Player player = new Player();
}
