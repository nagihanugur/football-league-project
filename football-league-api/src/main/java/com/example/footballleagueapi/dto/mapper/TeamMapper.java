package com.example.footballleagueapi.dto.mapper;

import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamMapper {

    public TeamDto toTeamDto(Team team){

        TeamDto dto = new TeamDto();
        dto.setTeamId(team.getTeamId());
        dto.setName(team.getName());
        dto.setFeatures(team.getFeatures());
        dto.setEmblem(team.getEmblem());
        dto.setPower(team.getPower());
        dto.setPoint(team.getPoint());
        return dto;
    }

    public List<TeamDto> toTeamDtoList(List<Team> teams){

        List<TeamDto> dtos = new ArrayList<>();
        teams.forEach(team -> dtos.add(toTeamDto(team)));
        return dtos;
    }

    public Team toTeam(TeamDto dto){

        Team team = new Team();

        team.setTeamId(dto.getTeamId());
        team.setName(dto.getName());
        team.setFeatures(dto.getFeatures());
        team.setEmblem(dto.getEmblem());
        team.setPower(dto.getPower());
        team.setPoint(dto.getPoint());

        return team;
    }

}
