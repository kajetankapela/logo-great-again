package com.logogreatagain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player")
public class Player {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Scores> scores = new ArrayList<>();
}
