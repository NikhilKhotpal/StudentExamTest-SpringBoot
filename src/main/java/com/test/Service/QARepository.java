package com.test.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.controller.AnswerValidationRequest;
import com.test.studentModel.QA;

public interface QARepository extends JpaRepository<QA, Long> {
	@Query("SELECT q.correctanswer FROM QA q WHERE q.id = :questionId")
	String findCorrectAnswerByQuestionId(@Param("questionId") Long questionId);

}
