package com.music.hackatonctysc.LIstaDeReproduccion.domain;

import com.music.hackatonctysc.Song.domain.Song;
import com.music.hackatonctysc.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPlaylist;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer idUser;

    @Column(nullable = false)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;


    @ManyToMany
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> song;

}
