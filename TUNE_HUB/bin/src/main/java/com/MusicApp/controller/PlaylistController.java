package com.MusicApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.MusicApp.entity.Playlist;
import com.MusicApp.entity.Songs;
import com.MusicApp.service.PlaylistService;
import com.MusicApp.service.SongsService;


@Controller
public class PlaylistController 
{
	@Autowired
	 SongsService songservice;
	
	@Autowired
	PlaylistService playlistservice;
	
	@GetMapping("createplaylist")
	public String createPlaylist(Model model)
	{
		List<Songs> songList=songservice.viewAllSongs();
		model.addAttribute("songs", songList);
		
		return "createplaylist";
	}
	@PostMapping("addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		playlistservice.addPlaylist(playlist);
		List<Songs>songList=playlist.getSongs();
		for(Songs s:songList)
		{
			s.getPlaylist().add(playlist);
			songservice.updateSong(s);
		}
		return "admin";
	}
	@GetMapping("viewPlayList")
	public String viewPlayList(Model model)
	{
		List<Playlist> allPlaylists=playlistservice.fetchAllPlaylists();
		model.addAttribute("allPlaylists", allPlaylists);
		return "displayPlaylists";
	}
}

