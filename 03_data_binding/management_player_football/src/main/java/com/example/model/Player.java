package com.example.model;

public class Player {
    private int id;
    private String name;
    private String dayOfBirth;
    private String experience;
    private String position;
    private String photos;

    public Player() {
    }

    public Player(int id, String name, String dayOfBirth, String experience, String position, String photos) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.experience = experience;
        this.position = position;
        this.photos = photos;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
