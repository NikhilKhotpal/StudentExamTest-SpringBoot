package com.test.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.studentModel.Question;

@Service
public class QuizeService1 {
	 private QuestionRepository questionRepository = null;

	    public QuizeService1(QuestionRepository questionRepository) {
	        this.questionRepository = questionRepository;
	    }

	    public List<Question> getAllQuestions() {
	        return questionRepository.findAll();
	    }

	    public Question saveQuestion(Question question) {
	        return questionRepository.save(question);
	    }

		public Optional<Question> getQuestionById(Long id) {
			// TODO Auto-generated method stub
			return questionRepository.findById(id);
		}
}
