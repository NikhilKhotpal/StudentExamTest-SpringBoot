package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.Service.QuizeService1;
import com.test.studentModel.Question;

@RestController
@RequestMapping("/api/questions")
public class QuizController11 {
    private final QuizeService1 quizService;

    public QuizController11(QuizeService1 quizService) {
        this.quizService = quizService;
    }

    @GetMapping("que")
    public List<Question> getAllQuestions() {
        return quizService.getAllQuestions();
    }

    @PostMapping("save")
    public Question createQuestion(@RequestBody Question question) {
        return quizService.saveQuestion(question);
    }
    @GetMapping("/seen/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> question = quizService.getQuestionById(id);
        
        return question.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }	
}