package com.music.hackatonctysc.song.domain;

import com.music.hackatonctysc.song.infrastructure.SongRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongService(final SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public Song updateSongById(Integer id, Song song) {
        Song existingSong = songRepository.findById(id).orElseThrow();

        existingSong.setTitle(song.getTitle());
        existingSong.setArtist(song.getArtist());
        existingSong.setAlbum(song.getAlbum());

        return songRepository.save(existingSong);
    }

    public void deleteSongById(Integer id) {
        if (songRepository.existsById(id))
            songRepository.deleteById(id);
        else throw new IllegalArgumentException("Invalid id");
    }
}
