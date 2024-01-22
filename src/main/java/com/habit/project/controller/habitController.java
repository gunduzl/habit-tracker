package com.habit.project.controller;

import com.habit.project.bussiness.requests.CreateHabitRequests;
import com.habit.project.model.Habit;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.habit.project.bussiness.requests.CreateHabitRequests;
import com.habit.project.repository.habitRepository;


@RestController
@RequestMapping("/habits")
public class habitController {

    private final habitRepository habitRepository;

    public habitController(habitRepository habitrepository){
        this.habitRepository = habitrepository;
    }

    @PostMapping
    void create(@RequestBody CreateHabitRequests request){
        Habit  habit = new Habit();
        habit.setName(request.name());
        this.habitRepository.save(habit);
    }

}
