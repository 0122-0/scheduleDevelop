package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.SignUpResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class UserService {
    // 레포지토리에 연결.
    private final UserRepository userRepository;

    //
    public SignUpResponseDto signUp(String name, String email, String password) {

        User user = new User(name, email, password);
        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getEmail(), savedUser.getPassword());
    }
}
