package com.test.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.studentModel.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);  // Custom query method to get answers by question ID
}
