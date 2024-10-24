package com.test.studentModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectedAnswer {
	private String question;
	private String selectedAnswer;
    private boolean isCorrect;
   
	
	


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getSelectedAnswer() {
		return selectedAnswer;
	}


	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}


	public boolean isCorrect() {
		return isCorrect;
	}


	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}


	@JsonCreator
    public SelectedAnswer(@JsonProperty("question") String question,
                          @JsonProperty("selectedAnswer") String selectedAnswer,
                          @JsonProperty("isCorrect") boolean isCorrect) {
        this.question = question;
        this.selectedAnswer = selectedAnswer;
        this.isCorrect = isCorrect;
    }
	
	
	
	
}
