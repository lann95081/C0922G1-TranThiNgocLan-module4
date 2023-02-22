package com.example.management_player_football.model;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String age;
    private String position;
    private String experience;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "teamId")
    private Team team;

    private boolean delete_status;

    public Player() {
    }

    public boolean isDelete_status() {
        return delete_status;
    }

    public void setDelete_status(boolean delete_status) {
        this.delete_status = delete_status;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
