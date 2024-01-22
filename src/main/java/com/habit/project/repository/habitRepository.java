package com.habit.project.repository;
import com.habit.project.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface habitRepository extends JpaRepository<Habit,Integer>{

}
