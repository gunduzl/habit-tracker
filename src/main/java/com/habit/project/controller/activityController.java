package com.habit.project.controller;

import com.habit.project.bussiness.requests.CreateActivityRequest;
import com.habit.project.model.Activity;
import com.habit.project.model.Habit;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.habit.project.repository.ActivityRepository;
import com.habit.project.repository.habitRepository;


@RestController
@RequestMapping("/activities")
public class activityController {

    private final ActivityRepository activityRepository;

    private final habitRepository habitRepository;

    public activityController(ActivityRepository activityRepository, com.habit.project.repository.habitRepository habitRepository) {
        this.activityRepository = activityRepository;
        this.habitRepository = habitRepository;
    }

    @PostMapping
    void create(@RequestBody CreateActivityRequest request){
        Habit habit = this.habitRepository.findById(request.habitId()).orElseThrow(EntityNotFoundException::new);
        Activity activity = new Activity();
        activity.setHabit(habit);
        this.activityRepository.save(activity);
    }
}
