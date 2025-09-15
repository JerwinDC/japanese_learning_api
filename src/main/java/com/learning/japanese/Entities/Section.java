package com.learning.japanese.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "lesson_section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vocabulary> vocabularies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grammar> grammars = new LinkedHashSet<>();

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Section(String type, String title){
        this.type = type;
        this.title = title;
    }

    public void addVocab(Vocabulary vocabulary){
        vocabularies.add(vocabulary);
        vocabulary.setSection(this);
    }

    public void removeVocab(Vocabulary vocabulary){
        vocabularies.remove(vocabulary);
        vocabulary.setSection(null);
    }

    public void addGrammar(Grammar grammar){
        grammars.add(grammar);
        grammar.setSection(this);
    }

    public void removeGrammar(Grammar grammar){
        grammars.remove(grammar);
        grammar.setSection(null);
    }

}