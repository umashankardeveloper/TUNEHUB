package com.MusicApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MusicApp.entity.Songs;
import com.MusicApp.repository.SongsRepository;

@Service
public class SongsServiceIplementation implements SongsService{
	@Autowired
	SongsRepository repos;
	
	@Override
	public void addSongs(Songs songs) {
		repos.save(songs);
		
	}

	@Override
	public List<Songs> viewAllSongs() {
		List<Songs> songList=repos.findAll();
		System.out.println(songList);
		return songList;
	}

	@Override
	public boolean songExist(String name) {
		if(repos.findByName(name)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public void updateSong(Songs s) {
		repos.save(s);
		
	}

}
