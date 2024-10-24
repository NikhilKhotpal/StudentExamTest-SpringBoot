package com.test.Dao;

import java.util.List;

import com.test.studentModel.AdminLogin;
import com.test.studentModel.Answer;
import com.test.studentModel.LoginModel;
import com.test.studentModel.QA;
import com.test.studentModel.Question;
import com.test.studentModel.StudentModel;
import com.test.studentModel.UserModel;

import jakarta.persistence.TypedQuery;

public interface MainDao {
public void SaveStudent(StudentModel student);
public void UpdateExam(Long id);
public void DeleteExam(Long id);
public void UpdateExam(StudentModel student);
public void emailexists(String email);
public List<UserModel> getusers(LoginModel lm);
public List<AdminLogin> adminlogin(AdminLogin Al);
public List<QA> getStartExam(QA qa);
public UserModel dologinto(String email);
public boolean	otpverification(String otp);
public boolean getchangepassword(String email,String password);
public void Answer(Answer answer);
public void question(Question question);
}
