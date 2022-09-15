package com.nseit.Dex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "examHistory")
public class ExamHistory {

    @Id
    @GeneratedValue
    private Integer examHistoryId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
    private Subjects subjects;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private ExamUser examUser;
}
