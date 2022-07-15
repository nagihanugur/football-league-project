package com.example.footballleagueapi.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer matchId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "team_first")
    private Team teamFirst;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "team_second")
    private Team teamSecond;

    @Column(name = "goal_ft", nullable = true)
    private Integer goalFt;

    @Column(name = "goal_st", nullable = true)
    private Integer goalSt;


    @Column(name = "match_date")
    @Temporal(TemporalType.DATE)
    private Date matchDate;

    public Match(){

    }


    public Match(Integer matchId, Team teamFirst, Team teamSecond, Integer goalFt, Integer goalSt, Date  matchDate){
        this.matchId = matchId;
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.goalFt = goalFt;
        this.goalSt = goalSt;
        this.matchDate = matchDate;

    }

    public Match( Team teamFirst, Team teamSecond, Integer goalFt, Integer goalSt, Date  matchDate){

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

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }
}
