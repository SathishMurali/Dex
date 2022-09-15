package com.nseit.Dex.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionChoiceRequest {
    private Integer questionId;
    private Integer choiceId;
    private String choiceName;
}
