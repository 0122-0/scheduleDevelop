package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String todotitle;

    private final String todo;

    public CreateScheduleRequestDto(String todotitle, String todo) {
        this.todotitle = todotitle;
        this.todo = todo;

    }



}
