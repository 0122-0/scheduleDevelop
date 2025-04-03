package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;

    private final String todotitle;

    private final String todo;

    public ScheduleResponseDto(Long id, String todotitle, String todo) {
        this.id = id;
        this.todotitle = todotitle;
        this.todo = todo;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTodotitle(), schedule.getTodo());
    }
}
