package com.example.footballleagueapi.entity;
import com.example.footballleagueapi.entity.Goal;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer teamId;

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

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "state_id" )
    private GameState gameState;



    public Team(){

    }
    public Team(Integer teamId, String name, String emblem, String features, Float power, Integer point, Goal goal, GameState gameState){
        this.teamId = teamId;
        this.name = name;
        this.emblem = emblem;
        this.features = features;
        this.power = power;
        this.point = point;
        this.goal = goal;
        this.gameState = gameState;
    }

    public Integer getTeamId(){return teamId;}

    public void setTeamId(Integer id){
        this.teamId = teamId;
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

    public Goal getGoal(){return goal;}

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
