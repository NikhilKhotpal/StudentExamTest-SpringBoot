package com.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.Service.QAService;
import com.test.studentModel.AnswerModel;
import com.test.studentModel.QA;

@RestController
//@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:8080")
//@RequestMapping("/Exam")
public class QAController {
@Autowired
private QAService qaservice;

@GetMapping("/all")
public List<QA> getAllQA(){
	return qaservice.getAllQA();
}
@GetMapping("/alll")
public List<QA> getquestions(){
	return qaservice.getquestion();
	
}
@PostMapping("/add")
public QA addQA(@RequestBody QA qa) {
	return qaservice.addQA(qa);
}
@DeleteMapping("/delete/{id}")
public void deleteQA(@PathVariable Long  id) {
	qaservice.deleteQA(id);
}
@PostMapping("/questions")
public ResponseEntity<QA> getQuestion(@PathVariable("id") Long id) {
    QA question = qaservice.getQuestionById(id);
    if (question != null) {
        return ResponseEntity.ok(question);
    } else {
        return ResponseEntity.notFound().build();
    }
}

@PostMapping("/validate")
public ResponseEntity<String> validateAnswer(@RequestBody AnswerValidationRequest request,Long id) {     
	String correctAnswer ="";
	if (correctAnswer != null) {
    return ResponseEntity.ok("Correct Answer!");
} else {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect Answer. Try again!");
}}


@PostMapping("/questions1")
public ResponseEntity<Map<String, Object>> getAllQuestions() {
    List<QA> questions = qaservice.getAllQuestions(); // Method to get all questions
    Map<String, Object> response = new HashMap<>();
    List<Map<String, Object>> questionsList = new ArrayList<>();

    for (QA question : questions) {
        Map<String, Object> questionDetails = new HashMap<>();
        questionDetails.put("question", question.getQuestion());
        questionDetails.put("answer1", question.getAnswer1());
        questionDetails.put("answer2", question.getAnswer2());
        questionDetails.put("answer3", question.getAnswer3());
        questionDetails.put("answer4", question.getAnswer4());
        questionDetails.put("timeLimit", 60); // Time limit for each question in seconds
        questionsList.add(questionDetails);
    }

    response.put("questions", questionsList);
    return ResponseEntity.ok(response);
}



}
