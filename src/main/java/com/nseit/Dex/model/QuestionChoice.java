package com.nseit.Dex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questionChoice")

public class QuestionChoice {
    @Id
    @GeneratedValue
    private Integer choiceId;
    private String choiceName;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = false, referencedColumnName = "questionId")
    private Questions questionChoices;
}
