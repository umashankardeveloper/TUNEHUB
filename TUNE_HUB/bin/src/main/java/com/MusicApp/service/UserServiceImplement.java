package com.MusicApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MusicApp.entity.Users;
import com.MusicApp.repository.UsersRepository;

@Service
public class UserServiceImplement implements UsersService
{
	@Autowired
	UsersRepository urepo;
	@Override
	public String addUsers(Users user) {
		urepo.save(user);
		return null;
	}
	@Override
	public boolean emailExists(String email) {
		if(urepo.findByEmail(email)==null)
		{
		return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public boolean validate(String email, String password) {
		if(urepo.findByEmail(email).getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	@Override
	public Users getUser(String email) {
		return urepo.findByEmail(email);
	}
	@Override
	public void updateuser(Users user) {
		urepo.save(user);
	}
	@Override
	public void updatePassword(String email, String newPassword) {
		Users user=urepo.findByEmail(email);
		user.setPassword(newPassword);
		urepo.save(user);
		
		
	}
	@Override
	public String deleteCustomer(String email) {
		Users user=urepo.findByEmail(email);
		urepo.delete(user);
		return "Customer is deleted Sucessfully";
	}

}
