package com.test.controller;

public class AnswerValidationRequest {
	private Long questionid;
    private String selectedAnswer;
	public Long getQuestionId() {
		return questionid;
	}
	public void setQuestionId(Long questionid) {
		this.questionid = questionid;
	}
	
	public String getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	
	public AnswerValidationRequest(Long questionid, String selectedAnswer) {
		super();
		this.questionid = questionid;
		this.selectedAnswer = selectedAnswer;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "AnswerValidationRequest{" +
        "questionId=" + questionid +
        ", selectedAnswer='" + selectedAnswer + '\'' +
        '}';
	}
}
