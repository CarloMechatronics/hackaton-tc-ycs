package com.music.hackatonctysc.user.domain;

import com.music.hackatonctysc.LIstaDeReproduccion.domain.Playlist;
import com.music.hackatonctysc.Song.domain.Song;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArtist;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    @Column(nullable = false)
    private String password;

    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime registerDate;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Playlist> playlists;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Song>  listenSongs;
}
