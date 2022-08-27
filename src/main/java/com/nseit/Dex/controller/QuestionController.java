package com.nseit.Dex.controller;

import com.nseit.Dex.model.Questions;
import com.nseit.Dex.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public void add(@RequestBody Questions questions){
        questionService.addQuestion(questions);
    }

    @PutMapping
    public void update(@RequestBody Questions questions){
        questionService.updateQuestion(questions);
    }

    @GetMapping("/all")
    public void view(){
        questionService.viewQuestion();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        questionService.deleteQuestion(id);
    }
}
