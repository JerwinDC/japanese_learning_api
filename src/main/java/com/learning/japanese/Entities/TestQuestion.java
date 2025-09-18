package com.learning.japanese.Entities;

import com.learning.japanese.Dtos.TestType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "test_question")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "question_text")
    private String questionText;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TestType type;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(mappedBy = "testQuestion")
    private Set<TestOption> options = new HashSet<>();

    public void addOptions(TestOption testOption){

        options.add(testOption);
        testOption.setTestQuestion(this);

    }

    public void removeOptions(TestOption testOption){

        options.add(testOption);
        testOption.setTestQuestion(this);

    }

}
