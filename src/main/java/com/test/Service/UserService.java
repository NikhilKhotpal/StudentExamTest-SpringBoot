package com.test.Service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.studentModel.LoginModel;
import com.test.studentModel.LoginModel;
import com.test.studentModel.UserModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	@PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private EmailService emailService; // Inject EmailService
    @Transactional
    // Get all users
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
   
    @Transactional

    // Get user by ID
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }
    @Transactional
    // Add new user
    public UserModel addUser(@Valid UserModel user) {
        UserModel savedUser = userRepository.save(user);
        
        
        
        // Send email to the user after registration
        String subject = "Welcome to Our Platform";
        String body = "Dear " + savedUser.getEmail() + ",\n\n" +
                      "Thank you for registering. Here are your credentials:\n\n" +
                      "Email: " + savedUser.getEmail() + "\n" +
                      "Password: " + savedUser.getPassword() + "\n\n" +
                      "Best regards,\nOur Team";

        emailService.sendEmail(savedUser.getEmail(), subject, body);

        return savedUser;
    }
@Transactional
    // Update existing user
    public UserModel updateUser(UserModel user) {
        return userRepository.save(user);
    }
@Transactional
    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
public boolean isUserAlreadyRegistered(String email,String password) {
    return userRepository.existsByEmailOrPhone(email,password);
}

public boolean changePassword(String email, String newPassword, String newPassword2) {
	// TODO Auto-generated method stub
	UserModel user = userRepository.findByEmail(email);
    if (user == null) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return true;
    }	
	return false;
}



}


