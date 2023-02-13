package com.example.management_player_football.dto;

public class PlayerDto {
    private int id;
    private String name;
    private String dayOfBirth;
    private String position;
    private String experience;
    private boolean status;

    public PlayerDto() {
    }

    public PlayerDto(int id, String name, String dayOfBirth, String position, String experience, boolean status) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.position = position;
        this.experience = experience;
        this.status = status;
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

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
