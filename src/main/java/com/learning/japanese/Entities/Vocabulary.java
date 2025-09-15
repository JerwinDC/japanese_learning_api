package com.learning.japanese.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "vocabulary_item")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "jp")
    private String jp;

    @Column(name = "romaji")
    private String romaji;

    @Column(name = "en")
    private String en;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Vocabulary(String jp, String romaji, String en) {
        this.jp = jp;
        this.romaji = romaji;
        this.en = en;
    }
}