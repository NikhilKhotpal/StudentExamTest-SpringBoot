package com.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Dao.MainDao;
import com.test.studentModel.AdminLogin;
import com.test.studentModel.Answer;
import com.test.studentModel.LoginModel;
import com.test.studentModel.QA;
import com.test.studentModel.Question;
import com.test.studentModel.StudentModel;
import com.test.studentModel.UserModel;


public interface ExamService {

    // Create a new student
   public void SaveStudent(StudentModel student);

    // Retrieve a student by ID

    // Retrieve all students

    // Update an existing student
    void updateStudent(StudentModel student);

    // Delete a student by ID
    void deleteStudent(Long id);

    // Handle student login
   

    // Enroll a student in an exam

    // Get all exams for a specific student



	public List<UserModel> login(LoginModel lm);

	public List<AdminLogin> Adminlogin(AdminLogin lm);
	
	public List<QA> ExamStarted(QA qa);

	public UserModel findByEmail(String email);
	
	public boolean getchangepassword(String email,String password);
	public void Answer(Answer answer);
	public void question(Question question);
	
}

