package com.test.studentModel;

import java.util.List;

public class QuizResult {
	private int score;
    private int totalQuestions;
    private List<SelectedAnswer> selectedAnswers;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public QuizResult(int score, int totalQuestions, List<SelectedAnswer> selectedAnswers) {
		super();
		this.score = score;
		this.totalQuestions = totalQuestions;
		this.selectedAnswers = selectedAnswers;
	}
	public QuizResult() {
		// TODO Auto-generated constructor stub
	}
	public List<SelectedAnswer> getSelectedAnswers() {
		return selectedAnswers;
	}
	public void setSelectedAnswers(List<SelectedAnswer> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}
	
}
