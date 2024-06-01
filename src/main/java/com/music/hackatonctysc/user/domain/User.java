package com.music.hackatonctysc.user.domain;

import com.music.hackatonctysc.LIstaDeReproduccion.domain.Playlist;
import com.music.hackatonctysc.Song.domain.Song;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

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
    private LocalDate registerDate;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Playlist> playlists;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Song>  listenSongs;
}
