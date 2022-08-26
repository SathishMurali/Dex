package com.nseit.Dex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Admin {
    private String email;
    private String password;
    private ArrayList<Candidate> candidates = new ArrayList<>();
}
