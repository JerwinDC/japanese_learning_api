package com.learning.japanese.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TestQuestion> questions = new HashSet<>();

    public void addQuestions(TestQuestion testQuestion){

        questions.add(testQuestion);
        testQuestion.setTest(this);

    }

    public void removeQuestions(TestQuestion testQuestion){

        questions.remove(testQuestion);
        testQuestion.setTest(null);

    }

}
