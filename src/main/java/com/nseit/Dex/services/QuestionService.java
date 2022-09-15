package com.nseit.Dex.services;

import com.nseit.Dex.exception.ResourceAlreadyExistException;
import com.nseit.Dex.exception.ResourceNotFoundException;
import com.nseit.Dex.model.Questions;
import com.nseit.Dex.model.Subjects;
import com.nseit.Dex.repository.QuestionRepository;
import com.nseit.Dex.repository.SubjectsRepository;
import com.nseit.Dex.request.QuestionRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubjectsRepository subjectsRepository;

    public Questions addQuestion(QuestionRequest questionRequest){
        Questions questions = new Questions();
        BeanUtils.copyProperties(questionRequest, questions);

        Subjects subjects = subjectsRepository.findById(questionRequest.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject with Id: " + questionRequest.getSubjectId()));
        questions.setSubjectSelection(subjects);

        boolean isQuestionExists = questionRepository.findByQuestion(questionRequest.getQuestion()).isPresent();
        if (isQuestionExists){
            throw new ResourceAlreadyExistException("Question Already Exists");
        }
        return questionRepository.save(questions);
    }

    public List<Questions> viewAllQuestions() {
        return questionRepository.findAll();
    }

    public Questions updateQuestion(QuestionRequest questionRequest){
        Questions questions = new Questions();
        BeanUtils.copyProperties(questionRequest, questions);
        if (questionRequest.getQuestionId() == null){
            throw new ResourceNotFoundException("No Question with ID: " + questionRequest.getQuestionId());
        }
        Subjects subjects = subjectsRepository.findById(questionRequest.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("No Subject with ID: " + questionRequest.getSubjectId()));
        questions.setSubjectSelection(subjects);
        return questionRepository.save(questions);
    }

    public void deleteQuestion(Integer questionId){
        questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("No Question with ID: " + questionId));
        questionRepository.deleteById(questionId);
    }
}