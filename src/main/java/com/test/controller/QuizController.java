package com.test.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.Service.QAService;
import com.test.studentModel.QA;
import com.test.studentModel.QuizResult;
import com.test.studentModel.SelectedAnswer;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QAService questionService;

    private List<QA> totalQuestions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<SelectedAnswer> selectedAnswers = new ArrayList<>();

    @GetMapping("/start")
    public ResponseEntity<List<QA>> startQuiz() {
        totalQuestions = questionService.getAllQuestions();
        return new ResponseEntity<>(totalQuestions, HttpStatus.OK);
    }

    @PostMapping("/answer")
    public ResponseEntity<String> submitAnswer(@RequestBody SelectedAnswer answerRequest) {
        QA currentQuestion = totalQuestions.get(currentQuestionIndex);
        boolean isCorrect = currentQuestion.getCorrectanswer().equals(answerRequest.getSelectedAnswer());
        if (isCorrect) {
            score++;
        }

        selectedAnswers.add(new SelectedAnswer(currentQuestion.getQuestion(), answerRequest.getSelectedAnswer(), isCorrect));
        currentQuestionIndex++;

        if (currentQuestionIndex >= totalQuestions.size()) {
            return new ResponseEntity<>("Quiz completed", HttpStatus.OK);
        }

        return new ResponseEntity<>("Next question", HttpStatus.OK);
    }

    @PostMapping("/results")
    public ResponseEntity<QuizResult> submitAnswers(@RequestBody List<SelectedAnswer> selectedAnswers) {
        // Validate that selectedAnswers is not null and contains data
        if (selectedAnswers == null || selectedAnswers.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Handle no answers submitted
        }

        int score = 0;
        List<SelectedAnswer> processedAnswers = new ArrayList<>();

        // Your logic to process answers here
        for (SelectedAnswer answer : selectedAnswers) {
            // Assuming you have a way to get the correct answer
            ResponseEntity<String> correctanswer = getCorrectAnswer(answer.getQuestion());
            System.out.println("Correct Answer" +correctanswer);
            boolean isCorrect = answer.getSelectedAnswer().equals(correctanswer);
            if (isCorrect) {
                score++;
            }

            processedAnswers.add(new SelectedAnswer(answer.getQuestion(), answer.getSelectedAnswer(), isCorrect));
        }

        QuizResult resultData = new QuizResult();
        resultData.setScore(score);
        resultData.setTotalQuestions(selectedAnswers.size());
        resultData.setSelectedAnswers(processedAnswers);
        resultData.setTotalQuestions(score);
        
        return ResponseEntity.ok(resultData);
    }

	@GetMapping("/answers/{question}")
    public ResponseEntity<String> getCorrectAnswer(@PathVariable String question) {
        for (QA qa : totalQuestions) {
            if (qa.getQuestion().equals(question)) {
                return new ResponseEntity<>(qa.getCorrectanswer(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
    }

}



