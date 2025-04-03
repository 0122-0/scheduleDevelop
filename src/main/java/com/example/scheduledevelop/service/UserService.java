package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.LoginResponseDto;
import com.example.scheduledevelop.dto.SignUpResponseDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


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

    public UserResponseDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exists id : " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getName(), findUser.getEmail());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치 하지 않습니다.");
        }

        findUser.updatePassword(newPassword);
    }

    public void deleteUser(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }

    public LoginResponseDto login(String email, String password) {
        // step 1. email 에 맞는 USER 있는지 확인
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED,
                                "Does not exist email = " + email
                        )
                );
        //step 2 비밀번호 맞는지 확인 하기
        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치 하지 않습니다.");
        }
       

        return new LoginResponseDto(user.getId());
    }

}
