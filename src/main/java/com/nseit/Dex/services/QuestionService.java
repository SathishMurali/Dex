package com.nseit.Dex.services;

import com.nseit.Dex.model.Questions;
import com.nseit.Dex.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void addQuestion(Questions questions){
        questionRepository.save(questions);
    }

    public void updateQuestion(Questions questions){
        questionRepository.save(questions);
    }

    public List<Questions> viewQuestion(){
        return questionRepository.findAll();
    }

    public void deleteQuestion(int id){
        for(Questions questions: questionRepository.findAll()){
            if (id == questions.getQuestionId()){
                questionRepository.delete(questions);
            }
        }
    }
}
