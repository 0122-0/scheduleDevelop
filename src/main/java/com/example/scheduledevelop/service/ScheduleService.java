package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.dto.UpdateScheduleTodoTitleDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String todotitle, String todo, Long userId) {

        User findUser = userRepository.findById(userId)
                .orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Does not exist userId = " + userId
                )
        );

        Schedule schedule = new Schedule(todotitle, todo);
        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTodotitle(), savedSchedule.getTodo());
    }

    public List<ScheduleResponseDto> findall() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();

    }

    public void deleteSchedule(Long id, Long userId) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        if(!findSchedule.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "작성자 정보가 일치 하지않습니다.");
        }

        scheduleRepository.delete(findSchedule);
    }

    @Transactional
    public void updateTodoTitle(Long id, String NewTodoTitle, Long userId) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        if(!findSchedule.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "작성자 정보가 일치 하지않습니다.");
        }

        findSchedule.updateTodoTitle(NewTodoTitle);
    }
}

