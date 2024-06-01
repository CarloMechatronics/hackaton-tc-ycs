package com.music.hackatonctysc.Song.domain;

import com.music.hackatonctysc.Album.domain.Album;
import com.music.hackatonctysc.LIstaDeReproduccion.domain.Playlist;
import com.music.hackatonctysc.artist.domain.Artist;
import com.music.hackatonctysc.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @ManyToMany(mappedBy = "song")
    private List<Playlist> playlists;

    private Integer duration;
}

