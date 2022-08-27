package com.nseit.Dex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")

public class Questions {
    @Id
    @GeneratedValue
    private Integer questionId;
    private String question;
    private String questionChoice;
    @ManyToMany(mappedBy = "questionsAsked")
    private List<Candidate> candidateList;
}
