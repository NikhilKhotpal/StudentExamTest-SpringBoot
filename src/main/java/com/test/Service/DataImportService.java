package com.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.studentModel.Question;
@Service
public class DataImportService {
@Autowired
private QuestionRepository questionRepository;
	public void saveQuestions(List<Question> questionList) {
		// TODO Auto-generated method stub
		questionRepository.saveAll(questionList);
	}

	
}
