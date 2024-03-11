package com.MusicApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MusicApp.entity.Users;
import com.MusicApp.service.SongsService;
import com.MusicApp.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController 
{
	@Autowired
	UsersService userv;
	
	@Autowired
	SongsService sserv;
	
	@PostMapping("register")
	public String addUsers(@ModelAttribute Users user)
	{
		if(userv.emailExists(user.getEmail())==false)
		{
			userv.addUsers(user);
			return "registerSuccess";
		}
		else
		{
			return "registerFail";
 		}
	}
	@PostMapping("map-login")
	public String validate(@RequestParam String email,@RequestParam String password, HttpSession session,Model model)
	{
		if(userv.getUser(email) != null)
		{
		if(userv.validate(email, password)==true)
		{
			session.setAttribute("email", email);
			if(userv.getUser(email).getRoll().equals("admin"))
			{ 
			return "admin";
			}
			else
			{
				return "user";
			}
		}
		else
		{
		     return "loginFail";
		}	
		}
		else
		{
			return "userNotFound";
		}
	}
	@PostMapping("generatePassword")
	public String generatePassword(@RequestParam String email,@RequestParam String newPassword,@RequestParam String confirmPassword)
	{
		if(newPassword.equals(confirmPassword))
		{
			userv.updatePassword(email,newPassword);
			return "login";
		}
		else
		{
			return "forgotPassword";
		}
	}
	@PostMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam String email)
	{
		userv.deleteCustomer(email);
		return "adminHome";
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
}

