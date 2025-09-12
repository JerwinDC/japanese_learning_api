package com.learning.japanese.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "level")
    private String level;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "lesson")
    private Set<UserProgress> userProgress = new HashSet<>();
}
