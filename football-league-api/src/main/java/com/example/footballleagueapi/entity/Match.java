package com.example.footballleagueapi.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer matchId;

    @ManyToOne
    @JoinColumn(name = "team_first")
    private Team teamFirst;

    @ManyToOne
    @JoinColumn(name = "team_second")
    private Team teamSecond;

    @Column(name = "goal_ft")
    private Integer goalFt;

    @Column(name = "goal_st")
    private Integer goalSt;


    @Column(name = "match_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime matchDate;

    public Match(){

    }


    public Match(Integer matchId, Team teamFirst, Team teamSecond, Integer goalFt, Integer goalSt, LocalDateTime  matchDate){
        this.matchId = matchId;
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.goalFt = goalFt;
        this.goalSt = goalSt;
        this.matchDate = matchDate;

    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public Team getTeamFirst() {
        return teamFirst;
    }

    public void setTeamFirst(Team teamFirst) {
        this.teamFirst = teamFirst;
    }

    public Team getTeamSecond() {
        return teamSecond;
    }

    public void setTeamSecond(Team teamSecond) {
        this.teamSecond = teamSecond;
    }

    public int getGoalFt() {
        return goalFt;
    }

    public void setGoalFt(int goalFt) {
        this.goalFt = goalFt;
    }

    public int getGoalSt() {
        return goalSt;
    }

    public void setGoalSt(int goalSt) {
        this.goalSt = goalSt;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }
}
