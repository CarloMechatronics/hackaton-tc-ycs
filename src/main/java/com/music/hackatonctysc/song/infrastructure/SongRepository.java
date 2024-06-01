package com.music.hackatonctysc.song.infrastructure;

import com.music.hackatonctysc.song.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
}