package com.test.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.studentModel.Question;

import jakarta.annotation.Resource;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
