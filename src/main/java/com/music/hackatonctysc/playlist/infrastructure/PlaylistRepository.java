package com.music.hackatonctysc.playlist.infrastructure;

import com.music.hackatonctysc.playlist.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}
