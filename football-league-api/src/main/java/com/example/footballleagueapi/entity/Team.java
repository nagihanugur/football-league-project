package com.example.footballleagueapi.entity;

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

    @Column(name = "won")
    private Integer won;

    @Column(name = "draw")
    private Integer draw;

    @Column(name = "lose")
    private Integer lose;

    @Column(name = "played")
    private Integer played;

    @Column(name = "goal_count")
    private Integer goalCount;



   /* @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    private GameState gameState;
*/


    public Team(){

    }
    public Team(Integer teamId, String name, String emblem, String features, Float power, Integer point, Integer won,
                Integer draw, Integer lose, Integer played, Integer goalCount){
        this.teamId = teamId;
        this.name = name;
        this.emblem = emblem;
        this.features = features;
        this.power = power;
        this.point = point;
        this.won = won;
        this.draw = draw;
        this.lose = lose;
        this.played = played;
        this.goalCount = goalCount;


    }

    public Integer getTeamId(){return teamId;}

    public void setTeamId(Integer teamId){
        this.teamId = teamId;
    }

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

  /*  public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    } */

    public Float getPower(){return power;}

    public void setPower(Float power){
        this.power = power;
    }

    public Integer getPoint(){return point;}

    public void setPoint(Integer point) {
        this.point = point;
    }
    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getGoalCount() {
        return goalCount;
    }

    public void setGoalCount(Integer goalCount) {
        this.goalCount = goalCount;
    }
}
