package com.test.controller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.Service.QARepository;
import com.test.studentModel.QA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/qaa")
public class QuestionAnwerController {
@Autowired
private QARepository qareposatory;
	
    // Method to read the questions.json file and return its content as JSON
    @GetMapping("/import")
    public ResponseEntity<?> importFromJSONFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileInputStream fileInputStream = new FileInputStream("questions.json")) {
            // Read the JSON file and map it to a list of QA objects
            List<QA> qaList = objectMapper.readValue(fileInputStream, new TypeReference<List<QA>>() {});

            // Return the list as a JSON response
            return ResponseEntity.ok(qaList);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error reading data from JSON file");
        }
    }
    @GetMapping("/export")
    public ResponseEntity<?> exportToJSONFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Fetch data from the database
            List<QA> qaList = qareposatory.findAll();

            // Convert the list of QA objects to JSON and save it to a file
            File file = new File("questions.json");
            objectMapper.writeValue(file, qaList);

            // Return a success message
            return ResponseEntity.ok("Data exported to questions.json successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error exporting data to JSON file");
        }
    }
}