package com.example.footballleagueapi.dto.mapper;

import com.example.footballleagueapi.dto.MatchDto;
import com.example.footballleagueapi.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchMapper {

    @Autowired
    private  TeamMapper teamMapper;

    @Autowired
    private  LeagueMapper leagueMapper;


    public MatchMapper() {
        if (teamMapper == null){
            teamMapper =  new TeamMapper();
        }
        if (leagueMapper == null){
            leagueMapper = new LeagueMapper();
        }

    }


    public MatchDto toMatchDto(Match match){
        MatchDto matchDto;
        matchDto = new MatchDto();
        matchDto.setMatchId(match.getMatchId());
        matchDto.setTeamFirst(teamMapper.toTeamDto(match.getTeamFirst()));
        matchDto.setTeamSecond(teamMapper.toTeamDto(match.getTeamSecond()));
        matchDto.setGoalFt(match.getGoalFt());
        matchDto.setGoalSt(match.getGoalSt());
        matchDto.setMatchDate(match.getMatchDate());
       matchDto.setLeagueDto(leagueMapper.toLeagueDto(match.getLeague()));


        return matchDto;
    }

    public Match toMatch(MatchDto dto){
        Match match = new Match();
        match.setMatchId(dto.getMatchId());
        match.setTeamFirst(teamMapper.toTeam(dto.getTeamFirst()));
        match.setTeamSecond(teamMapper.toTeam(dto.getTeamSecond()));
        match.setGoalFt(dto.getGoalFt());
        match.setGoalSt(dto.getGoalSt());
        match.setMatchDate(dto.getMatchDate());
        match.setLeague(leagueMapper.toLeague(dto.getLeagueDto()));
        return match;
    }

    public List<MatchDto> toMatchDtoList(List<Match> matchList){

        List<MatchDto> dtos = new ArrayList<>();
        matchList.forEach(match -> dtos.add(toMatchDto(match)));

        return dtos;
    }

    public List<Match> toMatchList(List<MatchDto> matchDtoList){

        List<Match> matches = new ArrayList<>();
        matchDtoList.forEach(matchDto -> matches.add(toMatch(matchDto)));

        return matches;
    }
}
