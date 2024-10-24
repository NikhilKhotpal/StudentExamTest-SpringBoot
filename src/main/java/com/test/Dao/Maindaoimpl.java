package com.test.Dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.studentModel.AdminLogin;
import com.test.studentModel.Answer;
import com.test.studentModel.LoginModel;
import com.test.studentModel.QA;
import com.test.studentModel.Question;
import com.test.studentModel.StudentModel;
import com.test.studentModel.UserModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;

@Repository
public class Maindaoimpl implements MainDao {
	@Autowired
	private EntityManager em1;
	
	@Autowired
    private SessionFactory sessionFactory;
	@Transactional
	@Override
	public void SaveStudent(StudentModel sm) {
		// TODO Auto-generated method stub
		Session session=em1.unwrap(Session.class);
		session.save(sm);
	}
	

	
	@Transactional
	@Override
	public void UpdateExam(Long id) {
		// TODO Auto-generated method stub
		//em1.merge(id);
	}
	@Transactional
	@Override
	public void DeleteExam(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void UpdateExam(StudentModel student) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void emailexists(String email) {
		// TODO Auto-generated method stub
		String hql="FROM UserModel S where S.email='"+email+"'";
		Session session=em1.unwrap(Session.class);
		Query<StudentModel> query1=session.createQuery(hql);
		List<StudentModel> list=query1.list();
		List<StudentModel> list1=list.size()>0?list:null;
	}

	@Override
	public List<UserModel> getusers(LoginModel Um) {
		// TODO Auto-generated method stub
		String email=Um.getEmail();
		String password=Um.getPassword();
		String hql="From UserModel U where U.email='"+Um.getEmail()+"' and U.password='"+Um.getPassword()+"'";		
		Session session=em1.unwrap(Session.class);
		
		Query<UserModel> query=session.createQuery(hql);
		//query.setParameter("email",email);
		//query.setParameter("password",password);
		List<UserModel> list=query.list();
		List<UserModel> list1=list.size()>0?list:null;
		return list1;
	}
	@Transactional
	@Override
	public List<AdminLogin> adminlogin(AdminLogin Al) {
		// TODO Auto-generated method stub
		String email=Al.getEmail();
		String hql="From AdminLogin A where A.email='"+Al.getEmail()+"' and A.password='"+Al.getPassword()+"'";		
		Session session=em1.unwrap(Session.class);
		
		Query<AdminLogin> query=session.createQuery(hql);
		//query.setParameter("email",email);
		//query.setParameter("password",password);
		List<AdminLogin> list=query.list();
		List<AdminLogin> list1=list.size()>0?list:null;
		return list1;
	}
	@Transactional
	@Override
	public List<QA> getStartExam(QA qa) {
		// TODO Auto-generated method stub
		 String hql = "FROM QA Q WHERE Q.question = :question " +
                 "AND Q.answer1 = :answer1 " +
                 "AND Q.answer2 = :answer2 " +
                 "AND Q.answer3 = :answer3 " +
                 "AND Q.answer4 = :answer4" +
                 "AND Q.correctanswer=: correctanswer ";

    // Unwrap the session from the EntityManager
    Session session = em1.unwrap(Session.class);
    
    // Create the query and set parameters
    Query<QA> query = session.createQuery(hql, QA.class);
    query.setParameter("question", qa.getQuestion());
    query.setParameter("answer1", qa.getAnswer1());
    query.setParameter("answer2", qa.getAnswer2());
    query.setParameter("answer3", qa.getAnswer3());
    query.setParameter("answer4", qa.getAnswer4());
    query.setParameter("correctanswer", qa.getCorrectanswer());
    // Execute the query and return the result
    List<QA> list = query.getResultList();

    // Return the list or an empty list if no results are found
    return list.isEmpty() ? Collections.emptyList() : list;
	}

	
	@Override
	public UserModel dologinto(String email) {
		// TODO Auto-generated method stub
		String hql = "From UserModel U where U.email = :email";
	    Session session = em1.unwrap(Session.class);
	    
	    // Create query and set the parameter
	    Query<UserModel> query = session.createQuery(hql);
	    query.setParameter("email", email);
	    
	    // Execute the query and get the result list
	    List<UserModel> list = query.list();
	    
	    // Return the first user from the list if available, otherwise return null
	    if (list != null && !list.isEmpty()) {
	        return list.get(0); // Return the first user
	    } else {
	        return null; // No user found
	    }
	}



	@Override
	public boolean otpverification(String otp) {
		// TODO Auto-generated method stub
		return false;
	}


@Transactional
	@Override
	public boolean getchangepassword(String email, String password) {
	Session session = em1.unwrap(Session.class);
    session.beginTransaction();

    String hql = "UPDATE UserModel SET password = :password WHERE email = :email";
    Query query = session.createQuery(hql);
    query.setParameter("password", password); // Ensure the password is hashed
    query.setParameter("email", email);

    int result = query.executeUpdate(); // Executes the update
    session.getTransaction().commit();
    
    return result > 0; // Return true if at least one row was updated
	
}



@Override
public void Answer(Answer answer) {
	// TODO Auto-generated method stub
	Session session=em1.unwrap(Session.class);
session.save(answer);
}



@Override
public void question(Question question) {
	// TODO Auto-generated method stub
	Session session=em1.unwrap(Session.class);
 session.save(question);
}





}
