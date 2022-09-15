package com.nseit.Dex.controller;


import com.nseit.Dex.model.QuestionChoice;
import com.nseit.Dex.request.QuestionChoiceRequest;
import com.nseit.Dex.response.APIResponse;
import com.nseit.Dex.services.QuestionChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/choice")
public class QuestionChoiceController {

    @Autowired
    private QuestionChoiceService questionChoiceService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addChoice(@RequestBody QuestionChoiceRequest questionChoiceRequest){
        QuestionChoice addedQuestionChoice = questionChoiceService.addChoice(questionChoiceRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(addedQuestionChoice);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse>  viewChoice(){
        List<QuestionChoice> questionChoices = questionChoiceService.viewAllChoice();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(questionChoices);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
