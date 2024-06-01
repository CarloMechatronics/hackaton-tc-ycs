package com.music.hackatonctysc.user.domain;

import com.music.hackatonctysc.user.dto.UserRegisterDto;
import com.music.hackatonctysc.user.dto.UserResponseDto;
import com.music.hackatonctysc.user.infrastructure.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public UserResponseDto saveUser(UserRegisterDto userRegisterDto) {
        User newUser = new User();
        newUser.setName(userRegisterDto.getName());
        newUser.setEmail(userRegisterDto.getEmail());
        newUser.setPassword(userRegisterDto.getPassword());
        newUser.setRegisterDate(LocalDate.now());

        return modelMapper.map(userRepository.save(newUser), UserResponseDto.class);
    }
}
