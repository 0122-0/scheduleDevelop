package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.SignUpRequestDto;
import com.example.scheduledevelop.dto.SignUpResponseDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduledevelop")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){

        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getName(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

}
