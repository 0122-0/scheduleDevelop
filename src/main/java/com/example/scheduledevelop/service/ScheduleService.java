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

    public ScheduleResponseDto save(String todotitle, String todo, String name) {

        User findUser = userRepository.findUserByNameOrElseThrow(name);

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

    public void deleteSchedule(Long id) {

        Schedule findshedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findshedule);
    }

    @Transactional
    public void updateTodoTitle(Long id, String oldTodoTitle, String NewTodoTitle) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        if(!findSchedule.getTodotitle().equals(oldTodoTitle)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치 하지 않습니다.");
        }

        findSchedule.updateTodoTitle(NewTodoTitle);
    }
}

