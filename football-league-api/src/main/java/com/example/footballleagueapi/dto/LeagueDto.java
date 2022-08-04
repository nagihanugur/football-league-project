package com.example.footballleagueapi.dto;

import com.example.footballleagueapi.dto.mapper.MatchMapper;
import com.example.footballleagueapi.entity.League;

import java.util.List;

public class LeagueDto {

    Integer leagueId;
    String name;
   // List<MatchDto> matches;

    private MatchMapper matchMapper;

    public LeagueDto(){

    }

    public LeagueDto(Integer leagueId, String name, List<MatchDto> matches){

        this.leagueId = leagueId;
        this.name = name;
      //  this.matches = matches;

      //  this.matchMapper = new MatchMapper(leagueMapper);
    }

    public LeagueDto(String name, List<MatchDto> matches){

        this.name = name;
     //   this.matches = matches;
    }

    public LeagueDto(League league){

        this.leagueId = league.getLeagueId();
        this.name = league.getName();
       // this.matches = matchMapper.toMatchDtoList(league.getMatches());
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

  /*  public List<MatchDto> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDto> matches) {
        this.matches = matches;
    }*/
}
