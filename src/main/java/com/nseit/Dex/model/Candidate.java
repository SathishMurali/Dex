package com.nseit.Dex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Candidate {
    @Id
    private Integer rollNo;
    private String candidateName;
    private String dob;
    private Long phoneNumber;
}
