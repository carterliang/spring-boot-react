package com.example.productcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productcart.model.*;



@RestController
@CrossOrigin("*")
@RequestMapping(value={"/login"})
public class LoginController {	
    @Autowired 
	LoginUserDAO dao;    
    
	@PostMapping()
	public LoginUser getByName(@RequestBody LoginUser user){
		LoginUser u= dao.findByUserNameAndPassword(user.getUserName(),user.getPassword());
		if(u != null)
			return u;
		else {
			return new LoginUser("","",false);
		}
	}
	
}



