package com.example.footballleagueapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "emblem")
    private String emblem;

    @Column(name = "features")
    private String features;

    @Column(name = "power")
    private Float power;

    @Column(name = "point")
    private Integer point;

    @Column(name = "goals")
    private Integer goals;

    public Team(){

    }
    public Team(Integer id, String name, String emblem, String features, Float power, Integer point, Integer goals){
        this.id = id;
        this.name = name;
        this.emblem = emblem;
        this.features = features;
        this.power = power;
        this.point = point;
        this.goals = goals;
    }

    public Integer getId(){return id;}

    public void setId(Integer id){
        this.id = id;
    };

    public String getName(){return name;}

    public void setName(String name){
        this.name = name;
    }

    public String getEmblem(){return emblem;}

    public void setEmblem(String emblem){
        this.emblem = emblem;
    }

    public String getFeatures(){return features;}

    public void setFeatures(String features){
        this.features = features;
    }

    public Float getPower(){return power;}

    public void setPower(Float power){
        this.power = power;
    }

    public Integer getPoint(){return point;}

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getGoals(){return goals;}

    public void setGoals(Integer goals) {
        this.goals = goals;
    }
}
