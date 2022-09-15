package com.nseit.Dex.controller;

import com.nseit.Dex.request.CandidateHistoryRequest;
import com.nseit.Dex.response.APIResponse;
import com.nseit.Dex.response.CandidateHistoryResponse;
import com.nseit.Dex.services.CandidateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/history")
public class CandidateHistoryController {

    @Autowired
    private CandidateHistoryService candidateHistoryService;

    @Autowired
    private APIResponse apiResponse;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewAllCandidateHistories(){
        List<CandidateHistoryResponse> candidateHistoryResponses = candidateHistoryService.viewAllCandidateHistories();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(candidateHistoryResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addToHistory(@RequestBody CandidateHistoryRequest historyRequest){
        List<CandidateHistoryResponse> candidateHistoryResponses = candidateHistoryService.addToHistory(historyRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(candidateHistoryResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
