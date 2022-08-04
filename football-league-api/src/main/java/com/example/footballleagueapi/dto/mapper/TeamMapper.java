package com.example.footballleagueapi.dto.mapper;

import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamMapper {

  //  private final GameStateMapper gameStateMapper;

   /* public TeamMapper() {
        this.gameStateMapper = new GameStateMapper();
    } */

    public TeamDto toTeamDto(Team team){

        TeamDto dto = new TeamDto();
        dto.setTeamId(team.getTeamId());
        dto.setName(team.getName());
        dto.setFeatures(team.getFeatures());
        dto.setEmblem(team.getEmblem());
        dto.setPower(team.getPower());
        dto.setPoint(team.getPoint());
        dto.setWon(team.getWon());
        dto.setDraw(team.getDraw());
        dto.setLose(team.getLose());
        dto.setPlayed(team.getPlayed());
        dto.setGoalCount(team.getGoalCount());
        //dto.setGameStateDto(gameStateMapper.toGameStateDto(team.getGameState()));
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
        team.setWon(dto.getWon());
        team.setDraw(dto.getDraw());
        team.setLose(dto.getLose());
        team.setPlayed(dto.getPlayed());
        team.setGoalCount(dto.getGoalCount());
     //   team.setGameState(gameStateMapper.toGameState(dto.getGameStateDto()));

        return team;
    }

}
