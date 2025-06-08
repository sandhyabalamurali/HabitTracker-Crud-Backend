package com.example.HabitTracker.Controller;

import com.example.HabitTracker.Dtos.HabitDto;
import com.example.HabitTracker.Service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/habit")
public class HabitController {
    @Autowired
    public HabitService service;
    @GetMapping("/getAll")
    public List<HabitDto> getAll(){
        return service.getAll();
    }
    @GetMapping("/getbyhabit/{name}")
    public List<HabitDto> getHabit(@PathVariable  String name){
        return service.getByName(name);
    }

    @PostMapping("/post")
    public String addHabit(@RequestBody HabitDto dto){
        return service.AddHabits(dto);
    }
    @PutMapping("/update/{id}")
    public String updateHabit(@RequestBody HabitDto dto){
        return service.edit(dto);
    }
    @DeleteMapping("/del/{id}")
    public String Delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
