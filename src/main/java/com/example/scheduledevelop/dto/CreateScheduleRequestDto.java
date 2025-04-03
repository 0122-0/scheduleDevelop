package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String todotitle;

    private final String todo;

    private final String name;
    public CreateScheduleRequestDto(String todotitle, String todo, String name) {
        this.todotitle = todotitle;
        this.todo = todo;
        this.name = name;
    }



}
