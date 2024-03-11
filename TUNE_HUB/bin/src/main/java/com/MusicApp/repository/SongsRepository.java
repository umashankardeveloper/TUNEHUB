package com.MusicApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.MusicApp.entity.Songs;

public interface SongsRepository extends JpaRepository<Songs, Integer>
{
	public Songs findByName(String name);
}