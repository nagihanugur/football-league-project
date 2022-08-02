package com.example.footballleagueapi.dto;
import com.example.footballleagueapi.entity.Team;

public class TeamDto {

    private Integer teamId;
    private String name;
    private String features;
    private String emblem;
    private Float power;
    private Integer point;


    public TeamDto(){

    }

    public TeamDto(Integer teamId, String name, String features, String emblem, Float power, Integer point){
        this.teamId = teamId;
        this.name = name;
        this.emblem = emblem;
        this.features = features;
        this.power = power;
        this.point = point;

    }

    public TeamDto(Team team){
        this.teamId = team.getTeamId();
        this.name = team.getName();
        this.features = team.getFeatures();
        this.emblem = team.getEmblem();
        this.power = team.getPower();
        this.point = team.getPoint();

    }

    public Integer getTeamId() {

        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

}
