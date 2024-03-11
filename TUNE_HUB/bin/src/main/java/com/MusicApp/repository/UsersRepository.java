package com.MusicApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MusicApp.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>
{

	public Users findByEmail(String email);

}
