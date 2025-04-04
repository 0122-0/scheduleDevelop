package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.common.Const;
import com.example.scheduledevelop.dto.CreateScheduleRequestDto;
import com.example.scheduledevelop.dto.LoginResponseDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.dto.UpdateScheduleTodoTitleDto;
import com.example.scheduledevelop.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor

public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute(Const.LOGIN_USER);

        LoginResponseDto login = (LoginResponseDto) session.getAttribute(Const.LOGIN_USER);

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getTodotitle(), requestDto.getTodo(), login.getId());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findall();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateSchedule(
            @PathVariable  Long id,
            @RequestBody UpdateScheduleTodoTitleDto requestDto,
            HttpServletRequest request
    ){

        HttpSession session = request.getSession();
        session.getAttribute(Const.LOGIN_USER);

        LoginResponseDto login = (LoginResponseDto) session.getAttribute(Const.LOGIN_USER);

        scheduleService.updateTodoTitle(id,requestDto.getNewTodoTitle(), login.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchdule(@PathVariable Long id, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.getAttribute(Const.LOGIN_USER);

        LoginResponseDto login = (LoginResponseDto) session.getAttribute(Const.LOGIN_USER);

        scheduleService.deleteSchedule(id, login.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
