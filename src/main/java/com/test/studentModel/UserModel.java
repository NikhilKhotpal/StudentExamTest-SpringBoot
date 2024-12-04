package com.test.studentModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "usermodel")

public class UserModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	private int attempts =0;
	
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	@Valid
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
private String email;
	@Valid
	@NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
private String password;
	@Valid
	@NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
private String phone;
	@Valid
@NotBlank(message = "Department is required")
private String department;

    private boolean isVerified;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getDepartment() {
	return department;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public void setDepartment(String department) {
	this.department = department;
}
public boolean isPresent() {
	// TODO Auto-generated method stub
	return false;
}
public boolean isVerified() {
	return isVerified;
}
public UserModel(Long id,
		@Valid @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
		@Valid @NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters") String password,
		@Valid @NotBlank(message = "Phone number is required") @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits") String phone,
		@Valid @NotBlank(message = "Department is required") String department, boolean isVerified) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.phone = phone;
	this.department = department;
	this.isVerified = isVerified;
}
public void setVerified(boolean b) {
	// TODO Auto-generated method stub
	
}
public UserModel() {
}

}
