package com.music.hackatonctysc.eventos;

import com.music.hackatonctysc.playlist.domain.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendPlaylistCreationNotification(Playlist playlist, String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Playlist creation notification");
        message.setText("Your playlist has been successfully created.");
        mailSender.send(message);
    }
}
