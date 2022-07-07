package com.example.footballleagueapi.dto;

import com.example.footballleagueapi.entity.Match;
import com.example.footballleagueapi.entity.Team;

import java.time.LocalDateTime;

public class MatchDto {

    private Integer matchId;
    private Team teamFirst;
    private Team teamSecond;
    private Integer goalFt;
    private Integer goalSt;
    private LocalDateTime matchDate;

    public MatchDto(){

    }
    public MatchDto(Integer matchId, Team teamFirst, Team teamSecond, Integer goalFt, Integer goalSt, LocalDateTime matchDate){

        this.matchId = matchId;
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.goalFt = goalFt;
        this.goalSt = goalSt;

    }

    public MatchDto(Match match){
        this.matchId = match.getMatchId();
        this.teamFirst = match.getTeamFirst();
        this.teamSecond = match.getTeamSecond();
        this.goalFt = match.getGoalFt();
        this.goalSt = match.getGoalSt();
        this.matchDate = match.getMatchDate();

    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
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

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }
}
