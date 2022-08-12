package com.example.footballleagueapi.dto.mapper;

import com.example.footballleagueapi.dto.LeagueDto;
import com.example.footballleagueapi.entity.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LeagueMapper {

   @Autowired
   private  MatchMapper matchMapper;
   @Autowired
   private  TeamMapper teamMapper;

    public LeagueMapper(){

    }


    public LeagueDto toLeagueDto(League league){

        LeagueDto leagueDto = new LeagueDto();
        leagueDto.setLeagueId(league.getLeagueId());
        leagueDto.setName(league.getName());
      //  leagueDto.setMatches(matchMapper.toMatchDtoList(league.getMatchList()));
      //  leagueDto.setTeams(teamMapper.toTeamDtoList(league.getTeamList()));

        return leagueDto;

    }

    public League toLeague(LeagueDto leagueDto){

        League league = new League();
        league.setLeagueId(leagueDto.getLeagueId());
        league.setName(leagueDto.getName());
       // league.setMatchList(matchMapper.toMatchList(leagueDto.getMatches()));
      //  league.setTeamList(teamMapper.toTeamList(leagueDto.getTeams()));

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
