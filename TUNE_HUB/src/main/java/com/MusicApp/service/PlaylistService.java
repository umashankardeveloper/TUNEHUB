package com.MusicApp.service;

import java.util.List;

import com.MusicApp.entity.Playlist;

public interface PlaylistService {

public void addPlaylist(Playlist playlist);
	
	public List<Playlist> fetchAllPlaylists();
}
