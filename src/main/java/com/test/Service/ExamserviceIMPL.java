package com.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.Dao.MainDao;
import com.test.studentModel.AdminLogin;

import com.test.studentModel.LoginModel;
import com.test.studentModel.QA;
import com.test.studentModel.Question;
import com.test.studentModel.StudentModel;
import com.test.studentModel.UserModel;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Service
public class ExamserviceIMPL implements ExamService {
	 @Autowired
	    private MainDao maindao;
	
	 
	

@Transactional
	@Override
	public void updateStudent(StudentModel student) {
		// TODO Auto-generated method stub
		maindao.UpdateExam(student);
	}
@Transactional
	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		maindao.DeleteExam(id);
	}



	
	@Transactional
	@Override
	public void SaveStudent(StudentModel student) {
		// TODO Auto-generated method stub
		maindao.SaveStudent(student);
	}
	

@Transactional
	@Override
	public List<UserModel> login(LoginModel lm) {
		// TODO Auto-generated method stub
		
		return maindao.getusers(lm);
	}
@Transactional
	@Override
	public List<AdminLogin> Adminlogin(AdminLogin lm) {
		
	return  maindao.adminlogin(lm);
		// TODO Auto-generated method stub
		
	}
@Transactional
@Override
public List<QA> ExamStarted(QA qa) {
	// TODO Auto-generated method stub
	return maindao.getStartExam(qa);
}
@Transactional
@Override
public UserModel findByEmail(String email) {
	// TODO Auto-generated method stub
	
	return maindao.dologinto(email);
}
@Transactional
@Override
public boolean getchangepassword(String email, String password) {
	// TODO Auto-generated method stub
	return maindao.getchangepassword(email, password);
}
@Transactional
@Override
public void Answer(com.test.studentModel.Answer answer) {
	// TODO Auto-generated method stub
	maindao.Answer(answer);
}
@Transactional
@Override
public void question(Question question) {
	// TODO Auto-generated method stub
	maindao.question(question);
}


	
	

	

	

}
