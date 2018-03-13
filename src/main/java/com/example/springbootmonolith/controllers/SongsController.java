package com.example.springbootmonolith.controllers;

import com.example.springbootmonolith.models.Songs;
import com.example.springbootmonolith.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongsController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/songs")
    public Iterable<Songs> findAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/songs/{songId}")
    public Optional<Songs> findSongsById(@PathVariable Long songId) {
        return songRepository.findById(songId);
    }

    @DeleteMapping("/songs/{songId}")
    public HttpStatus deleteSongById(@PathVariable Long userId) {
        songRepository.deleteById(userId);
        return HttpStatus.OK;
    }

    @PostMapping("/songs")
    public Songs createNewSong(@RequestBody Songs newSong) {
        return songRepository.save(newSong);
    }

    @PatchMapping("/songs/{songId}")
    public Songs updateSongById(@PathVariable Long songId, @RequestBody Songs songRequest) {

        Songs songsFromDb = songRepository.findById(songId).get();

        songsFromDb.setTitle(songRequest.getTitle());
        songsFromDb.setLength(songRequest.getTitle());

        return songRepository.save(songsFromDb);
    }
}
