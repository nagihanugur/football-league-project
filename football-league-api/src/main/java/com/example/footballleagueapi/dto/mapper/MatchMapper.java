package com.example.footballleagueapi.dto.mapper;

import com.example.footballleagueapi.dto.MatchDto;
import com.example.footballleagueapi.entity.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchMapper {

    private final TeamMapper teamMapper;

    public MatchMapper() {
        this.teamMapper = new TeamMapper();
    }

    public MatchDto toMatchDto(Match match){

        MatchDto matchDto = new MatchDto(teamMapper);
        matchDto.setMatchId(match.getMatchId());
        matchDto.setTeamFirst(teamMapper.toTeamDto(match.getTeamFirst()));
        matchDto.setTeamSecond(teamMapper.toTeamDto(match.getTeamSecond()));
        matchDto.setGoalFt(match.getGoalFt());
        matchDto.setGoalSt(match.getGoalSt());
        matchDto.setMatchDate(match.getMatchDate());

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

        return match;
    }

    public List<MatchDto> toMatchDtoList(List<Match> matchList){

        List<MatchDto> dtos = new ArrayList<>();
        matchList.forEach(match -> dtos.add(toMatchDto(match)));

        return dtos;
    }
}
