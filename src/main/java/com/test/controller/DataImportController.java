package com.test.controller;


import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.Service.AnswerRepository;
import com.test.Service.DataImportService;
import com.test.Service.QuestionRepository;
import com.test.Service.QuestionTestReposatory;
import com.test.studentModel.Answer;
import com.test.studentModel.QUESTIONTEST;
import com.test.studentModel.Question;
import com.test.studentModel.QuestionWithAnswers;

@RestController
public class DataImportController {
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private QuestionRepository questionRepository; // Autowire your service
    
    @Autowired
    private AnswerRepository answerRepository;
    
    @Autowired
    private QuestionTestReposatory quetest;
    
    @GetMapping("/export12")
    public ResponseEntity<?> exportToJSONFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Fetch all questions from the database
            List<QUESTIONTEST> qaList = quetest.findAll();

            // Ensure the answers are loaded for each question
            for (QUESTIONTEST question : qaList) {
                List<Answer> answers = answerRepository.findByQuestionId(question.getId());  // Fetch answers by question ID

                // Ensure that each answer has the correct 'answerText'
                for (Answer answer : answers) {
                    if (answer.getAnswerText() == null || answer.getAnswerText().isEmpty()) {
                        System.out.println("Answer text is missing for Answer ID: " + answer.getId());
                    }
                }

                //question.setAnswers(answers);  // Set the answers to the question
            }

            // Write the list of questions (with answers) to a JSON file
            File file = new File("questions_with_answers.json");
            objectMapper.writeValue(file, qaList);

            // Return a success message
            return ResponseEntity.ok("Data exported to questions_with_answers.json successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error exporting data to JSON file: " + e.getMessage());
        }
    }

}
