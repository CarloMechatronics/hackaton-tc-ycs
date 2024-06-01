package com.music.hackatonctysc.artist.domain;

import com.music.hackatonctysc.Song.domain.Song;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArtist;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Song> songs;
}
