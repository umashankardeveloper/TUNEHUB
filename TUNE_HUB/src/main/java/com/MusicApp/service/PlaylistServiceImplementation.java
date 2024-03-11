package com.MusicApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MusicApp.entity.Playlist;
import com.MusicApp.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService{

	@Autowired
	PlaylistRepository repos;

	@Override
	public void addPlaylist(Playlist playlist) {
		repos.save(playlist);
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
			return repos.findAll();
	}

}
