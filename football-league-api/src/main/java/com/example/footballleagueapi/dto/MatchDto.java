package com.example.footballleagueapi.dto;

import com.example.footballleagueapi.dto.mapper.LeagueMapper;
import com.example.footballleagueapi.dto.mapper.TeamMapper;
import com.example.footballleagueapi.entity.Match;


public class MatchDto {
    private Integer matchId;
    private TeamDto teamFirst;
    private TeamDto teamSecond;
    private LeagueDto leagueDto;
    private Integer goalFt;
    private Integer goalSt;
    private Integer matchDate;


    private TeamMapper teamMapper;
    private LeagueMapper leagueMapper;

    public MatchDto() {
    }

    public MatchDto(TeamMapper teamMapper, LeagueMapper leagueMapper) {
        this.teamMapper = teamMapper;
        this.leagueMapper = leagueMapper;
    }
    public MatchDto(Integer matchId, TeamDto teamFirst, TeamDto teamSecond, Integer goalFt, Integer goalSt, Integer matchDate, LeagueDto leagueDto) {
        this.matchId = matchId;
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.goalFt = goalFt;
        this.goalSt = goalSt;
        this.matchDate = matchDate;
        this.leagueDto = leagueDto;
    }
    public MatchDto(TeamDto teamFirst, TeamDto teamSecond, Integer goalFt, Integer goalSt, Integer matchDate, LeagueDto leagueDto) {
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.goalFt = goalFt;
        this.goalSt = goalSt;
        this.matchDate = matchDate;
        this.leagueDto = leagueDto;

    }

    public MatchDto(Match match) {
        this.matchId = match.getMatchId();
        this.teamFirst = teamMapper.toTeamDto(match.getTeamFirst());
        this.teamSecond = teamMapper.toTeamDto(match.getTeamSecond());
        this.goalFt = match.getGoalFt();
        this.goalSt = match.getGoalSt();
        this.matchDate = match.getMatchDate();
       this.leagueDto = leagueMapper.toLeagueDto(match.getLeague());

    }


    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public TeamDto getTeamFirst() {
        return teamFirst;
    }

    public void setTeamFirst(TeamDto teamFirst) {
        this.teamFirst = teamFirst;
    }

    public TeamDto getTeamSecond() {
        return teamSecond;
    }

    public void setTeamSecond(TeamDto teamSecond) {
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

    public Integer getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Integer matchDate) {
        this.matchDate = matchDate;
    }

    public LeagueDto getLeagueDto() {
        return leagueDto;
    }

    public void setLeagueDto(LeagueDto leagueDto) {
        this.leagueDto = leagueDto;
    }
}
