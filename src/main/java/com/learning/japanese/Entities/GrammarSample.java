package com.learning.japanese.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "grammar_example")
public class GrammarSample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "jp")
    private String jp;

    @Column(name = "en")
    private String en;

    @ManyToOne
    @JoinColumn(name = "grammar_section_id")
    private Grammar grammar;

}
