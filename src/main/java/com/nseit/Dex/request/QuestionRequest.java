package com.nseit.Dex.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionRequest {

    private Integer questionId;
    private Integer subjectId;
    private String question;
    private String questionChoice;
    private String correctAnswer;
}
