package com.MusicApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.MusicApp.entity.Songs;
import com.MusicApp.service.SongsService;

@Controller
public class SongsController 
{
	@Autowired
	SongsService Songserv;
	@PostMapping("map-addSong")
	public String addSongs(@ModelAttribute Songs songs)
	{
		if(Songserv.songExist(songs.getName())==false)
		{
			Songserv.addSongs(songs);
			return "SongFail";
		}
		else
		{
			return "admin";
		}
	}
	@GetMapping("viewsong")
	public String viewSongs(Model model)
	{
		List<Songs> viewSongs=Songserv.viewAllSongs();
		model.addAttribute("songs", viewSongs);
		return "displaydata";
	}
	@GetMapping("/playSongs")
	public String playSongs(Model model)
	{
		boolean premium=false;
		if(premium==true)
		{
		List<Songs> viewSongs=Songserv.viewAllSongs();
		model.addAttribute("songs", viewSongs);
		return "displaySongs";
		}
		else
		{
			return "makePayment";
		}
		
	}
}

