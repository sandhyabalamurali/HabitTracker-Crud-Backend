package com.example.HabitTracker.Service;

import com.example.HabitTracker.Dtos.HabitDto;
import com.example.HabitTracker.Entity.HabitEntity;
import com.example.HabitTracker.Repository.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HabitService {
    @Autowired
    Habit repo;

    //get all the habits
    public List<HabitDto> getAll(){
        return repo.findAll().stream().map(
                HabitEntity->new HabitDto(
                        HabitEntity.getId(),
                        HabitEntity.getName(),
                        HabitEntity.getHabitType(),
                        HabitEntity.getStatus(),
                        HabitEntity.getNotes()
                )).collect(Collectors.toList());
    }

    // get habit by search
    public List<HabitDto> getByName(String name){
        return repo.findByName(name).stream().map(
                HabitEntity -> new HabitDto(
                        HabitEntity.getId(),
                        HabitEntity.getName(),
                        HabitEntity.getHabitType(),
                        HabitEntity.getStatus(),
                        HabitEntity.getNotes()
                )).collect(Collectors.toList());
    }
    //post the habits
    public String AddHabits(HabitDto dto){
        HabitEntity add=new HabitEntity();
        add.setName(dto.getName());
        add.setHabitType(dto.getHabitType());
        add.setStatus(dto.getStatus());
        add.setNotes(dto.getNotes());
        repo.save(add);
        return "Successfully Added";
    }

    //edit
    public String edit(HabitDto dto){
        Optional<HabitEntity> editing=repo.findById(dto.getId());
        if(editing.isPresent()){
            HabitEntity update=editing.get();
            update.setName(dto.getName());
            update.setHabitType(dto.getHabitType());
            update.setStatus(dto.getStatus());
            update.setNotes(dto.getNotes());
            repo.save(update);
            return "updated successfully";
        }

        return "Not Updated";
    }

    //delete
    public String delete(Integer id){
        repo.deleteById(id);
        return "deleted successfully";
    }
}
