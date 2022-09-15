package com.nseit.Dex.services;

import com.nseit.Dex.exception.ResourceAlreadyExistException;
import com.nseit.Dex.exception.ResourceNotFoundException;
import com.nseit.Dex.model.QuestionChoice;
import com.nseit.Dex.model.Questions;
import com.nseit.Dex.repository.QuestionChoiceRepository;
import com.nseit.Dex.repository.QuestionRepository;
import com.nseit.Dex.request.QuestionChoiceRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionChoiceService {

    @Autowired
    private QuestionChoiceRepository questionChoiceRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionChoice addChoice(QuestionChoiceRequest questionChoiceRequest){
        QuestionChoice questionChoice = new QuestionChoice();
        BeanUtils.copyProperties(questionChoiceRequest, questionChoice);

        Questions questions = questionRepository.findById(questionChoiceRequest.getQuestionId())
                .orElseThrow(() -> new ResourceNotFoundException("Question with ID: " + questionChoiceRequest.getQuestionId()));

        questionChoice.setQuestionChoices(questions);

        boolean isChoiceExist = questionChoiceRepository.findByChoiceName(questionChoiceRequest.getChoiceName()).isPresent();
        if (isChoiceExist) {
            throw new ResourceAlreadyExistException("Choice Already Exist");
        }
        return questionChoiceRepository.save(questionChoice);
    }

    public List<QuestionChoice> viewAllChoice(){
        return questionChoiceRepository.findAll();
    }
}
