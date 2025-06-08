package com.example.HabitTracker.Dtos;

import com.example.HabitTracker.Entity.HabitStatus;

public class HabitDto {
    private int id;
    private String name;
    private String habitType;
    private HabitStatus status;
    private String notes;
    public HabitDto(){

    }

    public HabitDto(int id, String name, String habitType, HabitStatus status, String notes) {
        this.id = id;
        this.name = name;
        this.habitType = habitType;
        this.status = status;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHabitType() {
        return habitType;
    }

    public void setHabitType(String habitType) {
        this.habitType = habitType;
    }

    public HabitStatus getStatus() {
        return status;
    }

    public void setStatus(HabitStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
