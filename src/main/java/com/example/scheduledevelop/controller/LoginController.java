package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.common.Const;
import com.example.scheduledevelop.dto.LoginRequestDto;
import com.example.scheduledevelop.dto.LoginResponseDto;
import com.example.scheduledevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LoginController {
    private  final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login (@RequestBody LoginRequestDto requestDto, HttpServletRequest request){


        LoginResponseDto login = userService.login(requestDto.getEmail(), requestDto.getPassword());

        HttpSession session = request.getSession();
        session.setAttribute(Const.LOGIN_USER, login);

        return new ResponseEntity<>(login, HttpStatus.OK);
    }




}
