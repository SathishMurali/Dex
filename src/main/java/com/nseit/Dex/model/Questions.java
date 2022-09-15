package com.nseit.Dex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")

public class Questions {
    @Id
    @GeneratedValue
    private Integer questionId;
    private String question;
    private String correctAnswer;

    @OneToMany(mappedBy = "questionChoices", cascade = CascadeType.ALL)
    private List<QuestionChoice> choiceList;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", nullable = false, referencedColumnName = "subjectId")
    private Subjects subjectSelection;
}
