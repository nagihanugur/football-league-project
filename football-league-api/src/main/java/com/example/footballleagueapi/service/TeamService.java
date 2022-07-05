package com.example.footballleagueapi.service;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.dto.mapper.TeamMapper;
import com.example.footballleagueapi.entity.Team;
import com.example.footballleagueapi.repository.ITeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamService(ITeamRepository teamRepository) {
        this.teamRepository = teamRepository;
        this.teamMapper = new TeamMapper();
    }


    public ServiceResult<List<TeamDto>> getAll(){

        List<Team> teams = teamRepository.getAllTeams();
        List<TeamDto> teamDtos = teamMapper.toTeamDtoList(teams);

        return (ServiceResult<List<TeamDto>>) teamDtos;
    }
}
