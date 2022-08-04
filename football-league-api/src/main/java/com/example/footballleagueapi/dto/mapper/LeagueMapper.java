package com.example.footballleagueapi.dto.mapper;

import com.example.footballleagueapi.dto.LeagueDto;
import com.example.footballleagueapi.entity.League;

import java.util.ArrayList;
import java.util.List;

public class LeagueMapper {

  //  private final MatchMapper matchMapper;

    public LeagueMapper(){
    //    this.matchMapper = new MatchMapper(leagueMapper);
    }

    public LeagueDto toLeagueDto(League league){

        LeagueDto leagueDto = new LeagueDto();
        leagueDto.setLeagueId(league.getLeagueId());
        leagueDto.setName(league.getName());
     //   leagueDto.setMatches(matchMapper.toMatchDtoList(league.getMatches()));

        return leagueDto;

    }

    public League toLeague(LeagueDto leagueDto){

        League league = new League();
        league.setLeagueId(leagueDto.getLeagueId());
        league.setName(leagueDto.getName());
      //  league.setMatches(matchMapper.toMatchList(leagueDto.getMatches()));

        return league;
    }

    public List<LeagueDto> toLeagueDtoList(List<League> leagues){

        List<LeagueDto> dtos = new ArrayList<>();
        leagues.forEach(league -> dtos.add(toLeagueDto(league)));

        return dtos;
    }

    public List<League> toLeagueList(List<LeagueDto> leagueDtoList){

        List<League> leagues = new ArrayList<>();
        leagueDtoList.forEach(leagueDto -> leagues.add(toLeague(leagueDto)));

        return leagues;
    }
}
