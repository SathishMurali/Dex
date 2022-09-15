package com.nseit.Dex.controller;

import com.nseit.Dex.model.Questions;
import com.nseit.Dex.request.QuestionRequest;
import com.nseit.Dex.response.APIResponse;
import com.nseit.Dex.response.SuccessResponse;
import com.nseit.Dex.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private APIResponse apiResponse;

//    @Secured({Role.ROLE_ADMIN})
    @PostMapping("/add")
    public ResponseEntity<APIResponse> addQuestion(@RequestBody QuestionRequest questionRequest) {
        Questions addedQuestions = questionService.addQuestion(questionRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(addedQuestions);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @Secured({Role.ROLE_ADMIN})
    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateQuestion(@RequestBody QuestionRequest questionRequest) {
        Questions updatedQuestions = questionService.updateQuestion(questionRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(updatedQuestions);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @Secured({Role.ROLE_ADMIN, Role.ROLE_CANDIDATE})
    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewQuestion() {
        List<Questions> questions = questionService.viewAllQuestions();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(questions);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @Secured({Role.ROLE_ADMIN})
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<APIResponse> deleteQuestion(@PathVariable Integer questionId) {
        questionService.deleteQuestion(questionId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(new SuccessResponse());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}