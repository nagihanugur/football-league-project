package com.example.footballleagueapi.dto;

import com.example.footballleagueapi.dto.mapper.MatchMapper;
import com.example.footballleagueapi.dto.mapper.TeamMapper;
import com.example.footballleagueapi.entity.League;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class LeagueDto {

    Integer leagueId;
    String name;
    List<MatchDto> matches;
    List<TeamDto> teams;

    @Autowired
    private MatchMapper matchMapper;
    @Autowired
    private  TeamMapper teamMapper;


    public LeagueDto(){


    }
    public LeagueDto(Integer leagueId, String name){

        this.leagueId = leagueId;
        this.name = name;

    }
    public LeagueDto(String name){

        this.name = name;
    }

   public LeagueDto(Integer leagueId, String name, List<MatchDto> matches, List<TeamDto> teams){

        this.leagueId = leagueId;
        this.name = name;
       this.matches = matches;
       this.teams = teams;

    }

    public LeagueDto(String name, List<MatchDto> matches, List<TeamDto> teams){

        this.name = name;
       this.matches = matches;
       this.teams = teams;
    }

    public LeagueDto(League league){

        this.leagueId = league.getLeagueId();
        this.name = league.getName();
        this.matches = matchMapper.toMatchDtoList(league.getMatchList());
       this.teams = teamMapper.toTeamDtoList(league.getTeamList());
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MatchDto> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDto> matches) {
        this.matches = matches;
    }

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }
}
