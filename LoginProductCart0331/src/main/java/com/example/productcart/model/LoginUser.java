package com.example.productcart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "loginusers")
public class LoginUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer uid;
	String userName;
	String password;
	boolean isActive;
    
	public LoginUser() {
		
	}

	public LoginUser(String userName, String password, boolean isActive) {
		
		this.userName = userName;
		this.password = password;
		this.isActive = isActive;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "LoginUser [uid=" + uid + ", userName=" + userName + ", password=" + password + ", isActive=" + isActive
				+ "]";
	}
}


