package com.music.hackatonctysc.album.domain;

import com.music.hackatonctysc.song.domain.Song;
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
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idAlbum;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date releaseDate;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs;
}
