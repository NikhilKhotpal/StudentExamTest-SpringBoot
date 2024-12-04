package com.test.studentModel;

import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class QUESTIONTEST {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String questiontext;
private String answers;
private String text;

public String getAnswers() {
	return answers;
}
public void setAnswers(String answers) {
	this.answers = answers;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getQuestiontext() {
	return questiontext;
}
public void setQuestiontext(String questiontext) {
	this.questiontext = questiontext;
}

}
