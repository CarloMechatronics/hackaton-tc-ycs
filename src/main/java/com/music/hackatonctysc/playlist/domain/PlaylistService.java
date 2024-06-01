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

    public void deletePlaylist(Integer id) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
        } else throw new IllegalArgumentException("Invalid id");
    }


    public List<Song> findAllPlaylistSongs(Integer id) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow();

        return playlist.getSongs();
    }

    public Playlist addSong(Integer id, Song song) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        if (song != null)
            playlist.getSongs().add(song);
        else throw new IllegalArgumentException("Invalid id");

        return playlistRepository.save(playlist);
    }

    public void deletePlaylistSong(Integer id, Integer songId) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid playlist id"));
        Song song = playlist.getSongs().stream()
                .filter(s -> s.getId().equals(songId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid song id"));
        playlist.getSongs().remove(song);

        playlistRepository.save(playlist);
    }

}
