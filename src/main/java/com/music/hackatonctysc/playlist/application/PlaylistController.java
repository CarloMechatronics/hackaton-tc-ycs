package com.music.hackatonctysc.playlist.application;

import com.music.hackatonctysc.playlist.domain.Playlist;
import com.music.hackatonctysc.playlist.domain.PlaylistService;
import com.music.hackatonctysc.song.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;


    @GetMapping("/{playlist_id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Integer playlist_id) {
        Playlist playlist = playlistService.getPlaylistById(playlist_id);
        return ResponseEntity.ok(playlist);
    }


    @PutMapping("/{playlist_id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable Integer playlist_id, @RequestBody Playlist playlist) {
        Playlist updatedPlaylist = playlistService.updatePlaylist(playlist_id, playlist);
        return ResponseEntity.ok(updatedPlaylist);
    }

    @DeleteMapping("/{playlist_id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Integer playlist_id) {
        playlistService.deletePlaylist(playlist_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{playlist_id}/songs")
    public ResponseEntity<List<Song>> getAllPlaylistSongs(@PathVariable Integer playlist_id) {
        List<Song> songs = playlistService.findAllPlaylistSongs(playlist_id);
        return ResponseEntity.ok(songs);
    }

    @PostMapping("/{playlist_id}/songs")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Integer playlist_id, @RequestBody Song song) {
        Playlist updatedPlaylist = playlistService.addSong(playlist_id, song);
        return ResponseEntity.ok(updatedPlaylist);
    }

    @DeleteMapping("/{playlist_id}/songs/{song_id}")
    public ResponseEntity<Void> deleteSongFromPlaylist(@PathVariable Integer playlist_id, @PathVariable Integer song_id) {
        playlistService.deletePlaylistSong(playlist_id, song_id);
        return ResponseEntity.noContent().build();
    }
}
