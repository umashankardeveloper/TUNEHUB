package com.MusicApp.service;

import java.util.List;

import com.MusicApp.entity.Songs;

public interface SongsService {

	public void addSongs(Songs songs);

	public List<Songs> viewAllSongs();

	public boolean songExist(String name);

	public void updateSong(Songs s);
}
