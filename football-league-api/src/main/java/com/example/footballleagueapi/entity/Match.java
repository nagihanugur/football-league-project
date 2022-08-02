package com.example.footballleagueapi.entity;


import com.example.footballleagueapi.dto.TeamDto;

import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="sequence_match", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Column(name = "match_id")
    private Integer matchId;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "team_first", referencedColumnName = "team_id")
    private Team teamFirst;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "team_second", referencedColumnName = "team_id")
    private Team teamSecond;

    @Column(name = "goal_ft")
    private Integer goalFt;


   @Column(name = "goal_st")
    private Integer goalSt;


    @Column(name = "match_date")

    private String matchDate;

    public Match(Team teamFirst, Team teamSecond, Integer goalFt, Integer goalSt, String matchDate){
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.goalSt = goalSt;
        this.goalFt = goalFt;
        this.matchDate = matchDate;

    }

    public Match(){

    }


    public Match(Integer matchId, Team teamFirst, Team teamSecond, Integer goalFt, Integer goalSt, String  matchDate){
        this.matchId = matchId;
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.goalFt = goalFt;
        this.goalSt = goalSt;
        this.matchDate = matchDate;

    }



    public Integer  getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer  matchId) {
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

    public Integer getGoalFt() {
        return goalFt;
    }

    public void setGoalFt(Integer goalFt) {
        this.goalFt = goalFt;
    }

    public Integer getGoalSt() {
        return goalSt;
    }

    public void setGoalSt(Integer goalSt) {
        this.goalSt = goalSt;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }
}
