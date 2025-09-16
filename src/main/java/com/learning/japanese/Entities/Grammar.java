package com.learning.japanese.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "grammar_section")
public class Grammar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "formula")
    private String formula;

    @OneToMany(mappedBy = "grammar", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true)
    private Set<GrammarSample> samples = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    public void addSample(GrammarSample grammarSample){
        samples.add(grammarSample);
        grammarSample.setGrammar(this);
    }

    public void removeSample(GrammarSample grammarSample){
        samples.remove(grammarSample);
        grammarSample.setGrammar(null);
    }

}
