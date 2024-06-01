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
    @JoinColumn(name = "artistId")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album albumID;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private User usuario;

    @ManyToMany(mappedBy = "canciones")
    private List<Playlist> playlists;

    private Integer duration;
}

