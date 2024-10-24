package com.test.studentModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class QA {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String question;
private String correctanswer;//correct answer
private String answer1;
private String answer2;
private String answer3;
private String answer4;
private int timeLimit;
public QA() {
	super();
	// TODO Auto-generated constructor stub
}
public int getTimeLimit() {
	return timeLimit;
}
public void setTimeLimit(int timeLimit) {
	this.timeLimit = timeLimit;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getCorrectanswer() {
	return correctanswer;
}
public void setCorrectanswer(String correctanswer) {
	this.correctanswer = correctanswer;
}
public String getAnswer1() {
	return answer1;
}
public void setAnswer1(String answer1) {
	this.answer1 = answer1;
}
public String getAnswer2() {
	return answer2;
}
public void setAnswer2(String answer2) {
	this.answer2 = answer2;
}
public String getAnswer3() {
	return answer3;
}
public void setAnswer3(String answer3) {
	this.answer3 = answer3;
}
public String getAnswer4() {
	return answer4;
}
public void setAnswer4(String answer4) {
	this.answer4 = answer4;
}



}
