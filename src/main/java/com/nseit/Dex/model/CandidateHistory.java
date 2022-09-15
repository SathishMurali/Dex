package com.nseit.Dex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidateHistory")
public class CandidateHistory {
    @Id
    @GeneratedValue
    private Integer candidateHistoryId;
    private String examDateTime;
    private Integer score;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
    private Subjects subjects;
}
