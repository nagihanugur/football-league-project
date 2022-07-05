package com.example.footballleagueapi.dto;

import com.example.footballleagueapi.entity.Team;

public class TeamDto {

    private Integer id;
    private String name;
    private String features;
    private String emblem;
    private Float power;
    private Integer point;
    private Integer goals;

    public TeamDto(){

    }

    public TeamDto(Integer id, String name, String features, String emblem, Float power, Integer point, Integer goals){
        this.id = id;
        this.name = name;
        this.emblem = emblem;
        this.features = features;
        this.power = power;
        this.point = point;
        this.goals = goals;
    }

    public TeamDto(Team team){
        this.id = team.getId();
        this.name = team.getName();
        this.features = team.getFeatures();
        this.emblem = team.getEmblem();
        this.power = team.getPower();
        this.point = team.getPoint();
        this.goals = team.getGoals();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }
}
