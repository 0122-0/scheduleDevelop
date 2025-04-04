package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleTodoTitleDto {
    private final String oldTodoTitle;

    private final String newTodoTitle;

    public UpdateScheduleTodoTitleDto(String oldTodoTitle, String newTodoTitle) {
        this.oldTodoTitle = oldTodoTitle;
        this.newTodoTitle = newTodoTitle;
    }
}
