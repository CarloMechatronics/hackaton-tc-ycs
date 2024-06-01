package com.music.hackatonctysc.playlist.domain;

import com.music.hackatonctysc.playlist.infrastructure.PlaylistRepository;
import com.music.hackatonctysc.song.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist getPlaylistById(Integer id) {
        return playlistRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Playlist updatePlaylist(Integer id, Playlist playlist) {
        Playlist existingPlaylist = playlistRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        existingPlaylist.setName(playlist.getName());

        return playlistRepository.save(playlist);
    }

    public List<Song> findAllPlaylistSongs(Integer id) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow();

        return playlist.getSongs();
    }

    public

    public Void deletePlaylist(Integer id) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
        } else throw new IllegalArgumentException("Invalid id");
    }
}
