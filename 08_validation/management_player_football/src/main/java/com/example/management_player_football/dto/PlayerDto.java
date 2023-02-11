package com.example.management_player_football.dto;

import com.example.management_player_football.model.Team;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class PlayerDto implements Validator {
    private int id;

    @NotBlank(message = "Tên không được để trống.")
    @Size(min = 5, max = 100, message = "Tên nhập vào phải có độ dài từ 5 đến 100 kí tự.")
    @Pattern(regexp = "^[a-zA-Z\\+]*$", message = "Tên không được chứa kí tự đặc biệt")
    private String name;

    @NotBlank(message = "Tuổi không được để trống.")
    @Min(value = 16, message = "Tuổi phải lớn hơn hoặc bằng 16")
    @Max(value = 100, message = "Tuổi phải nhỏ hơn hoặc bằng 100")
    private String age;

    @NotBlank(message = "Vị trí không được bỏ trống.")
    private String position;

    @NotBlank(message = "Kinh nghiệm không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*$", message = "Kinh nghiệm phải là số nguyên dương.")
    private String experience;
    private Team team;

    public PlayerDto() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public void validate(PlayerDto playerDto, BindingResult bindingResult) {
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
