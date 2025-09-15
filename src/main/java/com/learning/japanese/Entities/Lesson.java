package com.learning.japanese.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(mappedBy = "lesson")
    private Set<Section> sections = new LinkedHashSet<>();

    public void addSection(Section section) {
        sections.add(section);
        section.setLesson(this);
    }

    public void removeSection(Section section) {
        sections.remove(section);
        section.setLesson(null);
    }
}
