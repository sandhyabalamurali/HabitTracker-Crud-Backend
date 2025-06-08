package com.example.HabitTracker.Repository;

import com.example.HabitTracker.Entity.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface Habit extends JpaRepository<HabitEntity,Integer> {
    List<HabitEntity> findByName(String name);
}
