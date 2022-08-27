package com.nseit.Dex.controller;

import com.nseit.Dex.model.Candidate;
import com.nseit.Dex.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    public void addCandidate(Candidate candidate){
        candidateService.addCandidate(candidate);
    }
}
