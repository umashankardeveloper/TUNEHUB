package com.MusicApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MusicApp.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>
{

}