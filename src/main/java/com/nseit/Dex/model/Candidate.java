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
@Table(name = "candidate")

public class Candidate {
    @Id
    private Integer rollNo;
    private String candidateName;
    private String dob;
    private Long phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "candidate_questions",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private List<Questions> questionsAsked;
}
