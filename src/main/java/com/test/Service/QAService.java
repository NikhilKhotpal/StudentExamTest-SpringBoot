package com.test.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.controller.AnswerValidationRequest;
import com.test.studentModel.AnswerModel;
import com.test.studentModel.QA;

@Service
public class QAService {
@Autowired
private QARepository qareposatory;
public List<QA>getAllQA(){
	return qareposatory.findAll();
	
}
public List<QA> getAllQuestions() {
	// TODO Auto-generated method stub
	return qareposatory.findAll();
}

public List<QA>getquestion(){
	return qareposatory.findAll();
	
}

public QA addQA(QA qa) {
    return qareposatory.save(qa);
}

// Delete Q&A by ID
public void deleteQA(Long id) {
	qareposatory.deleteById(id);
}
public QA getQuestionById(Long id) {
    return qareposatory.findById(id).orElse(null);
}

public String validateAnswer(Long questionId, String selectedAnswer) {
    QA question = getQuestionById(questionId);
    if (question != null && question.getCorrectanswer() == null) {
        String correctanswer = question.getCorrectanswer().toString(); // Convert to String if needed
       
    }
	return selectedAnswer;
    
}
public ResponseEntity<String> getCorrectAnswer(Long questionId) {
	// TODO Auto-generated method stub
	 String correctAnswer = qareposatory.findCorrectAnswerByQuestionId(questionId);

	    // Check if the answer exists
	    if (correctAnswer != null) {
	        // Return the answer with an OK status (200)
	        return ResponseEntity.ok(correctAnswer);
	    } else {
	        // If no answer is found, return a NOT FOUND status (404)
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Correct answer not found for question ID: " + questionId);
	    }
}

	
public String getCorrectAnswer1(Long questionId) {
    // Fetch the correct answer from the repository
    QA question = qareposatory.findById(questionId).orElseThrow();
    return question.getCorrectanswer(); // Assuming this method returns the correct answer
}
public String getcorrectanswer(Long questionId) {
	return qareposatory.findCorrectAnswerByQuestionId(questionId);
	
}



}
