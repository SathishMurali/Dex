package com.nseit.Dex.services;

import com.nseit.Dex.exception.ResourceNotFoundException;
import com.nseit.Dex.model.CandidateHistory;
import com.nseit.Dex.model.Subjects;
import com.nseit.Dex.repository.CandidateHistoryRepository;
import com.nseit.Dex.repository.SubjectsRepository;
import com.nseit.Dex.request.CandidateHistoryRequest;
import com.nseit.Dex.response.CandidateHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateHistoryService {

    @Autowired
    private CandidateHistoryRepository candidateHistoryRepository;

    @Autowired
    private SubjectsRepository subjectsRepository;

    public List<CandidateHistoryResponse> viewAllCandidateHistories() {
        List<CandidateHistory> candidateHistories = candidateHistoryRepository.findAll();
        List<CandidateHistoryResponse> candidateHistoryResponses = new ArrayList<>();

        for (CandidateHistory candidateHistory : candidateHistories){
            CandidateHistoryResponse candidateHistoryResponse = new CandidateHistoryResponse();

            candidateHistoryResponse.setSubjectName(candidateHistory.getSubjects().getSubjectName());
            candidateHistoryResponse.setScore   (candidateHistory.getScore());
            candidateHistoryResponse.setExamDateTime(candidateHistory.getExamDateTime());
            candidateHistoryResponses.add(candidateHistoryResponse);
        }
        return candidateHistoryResponses;
    }

    public List<CandidateHistoryResponse> addToHistory(CandidateHistoryRequest historyRequest){
        List<CandidateHistory> candidateHistories = new ArrayList<>();
        Subjects subjects = subjectsRepository.findById(historyRequest.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject does not exist" + historyRequest.getSubjectId()));

        CandidateHistory candidateHistory = new CandidateHistory();
        candidateHistory.setSubjects(subjects);

        candidateHistoryRepository.save(candidateHistory);
        return viewAllCandidateHistories();
    }
}
