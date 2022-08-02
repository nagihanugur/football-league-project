package com.example.footballleagueapi.service;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.dto.mapper.TeamMapper;
import com.example.footballleagueapi.entity.Team;
import com.example.footballleagueapi.repository.IGoalRepository;
import com.example.footballleagueapi.repository.ITeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final IGoalRepository goalRepository;



    public TeamService(ITeamRepository teamRepository, IGoalRepository goalRepository) {
        this.teamRepository = teamRepository;
        this.goalRepository = goalRepository;


        this.teamMapper = new TeamMapper();

    }


    public ServiceResult<List<TeamDto>> getAll(){

        List<Team> teams = teamRepository.getAllByOrderByTeamId();
        List<TeamDto> teamDtos = teamMapper.toTeamDtoList(teams);


        return new ServiceResult<List<TeamDto>>(teamDtos);
    }

    public ServiceResult<TeamDto> getTeamById(Integer id){
        ServiceResult<TeamDto> serviceResult = new ServiceResult<>();

        Optional<Team> team = teamRepository.findById(id);

        if (team.isPresent()){
            serviceResult.setData(teamMapper.toTeamDto(team.get()));

            return serviceResult;
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("can't found team by id...");
        return serviceResult;
    }

    @Transactional
    public ServiceResult<TeamDto> saveTeam(TeamDto teamDto){

        ServiceResult<TeamDto> serviceResult = new ServiceResult<>();
        Team team = teamRepository.findTeamByTeamId(teamDto.getTeamId());

      if(team == null){
          if (teamDto.getName() == null || teamDto.getEmblem() == null || teamDto.getPower() ==null || teamDto.getFeatures() == null){

              serviceResult.setSuccess(false);
              serviceResult.setErrorMessage("Please fill all requirements and don't entered goal id and state id that already exist! ");
              return serviceResult;
          }

          Team savedTeam = teamRepository.save(teamMapper.toTeam(teamDto));
          serviceResult.setData(teamMapper.toTeamDto(savedTeam));
          return serviceResult;

      }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("This team is already exist..");
        return serviceResult;



    }

    public ServiceResult<TeamDto> updateTeam(TeamDto teamDto, Integer teamId){

        Optional<Team> team = teamRepository.findById(teamId);
        ServiceResult<TeamDto> serviceResult = new ServiceResult<>();

       if (team.isPresent()){
           team.get().setName(teamDto.getName());
           team.get().setEmblem(teamDto.getEmblem());
           team.get().setFeatures(teamDto.getFeatures());
           team.get().setPoint(teamDto.getPoint());
           team.get().setPower(teamDto.getPower());

           Team  updatedTeam = teamRepository.save(team.get());
           serviceResult.setData(teamMapper.toTeamDto(updatedTeam));
           return serviceResult;

       }

       serviceResult.setSuccess(false);
       serviceResult.setErrorMessage(" was not found team ");
       return serviceResult;
    }




    @Transactional
    public ServiceResult<Void> deleteTeamById(Integer id){
        ServiceResult<Void> serviceResult = new ServiceResult<>();

        Optional<Team> team = teamRepository.findById(id);

        if(team.isEmpty()){
            serviceResult.setSuccess(false);
            serviceResult.setErrorMessage("can't found team by id...");
            return serviceResult;
        }

        teamRepository.delete(team.get());
        serviceResult.setSuccess(true);

        return serviceResult;

    }

    public ServiceResult<Void> deleteAllTeam(){

        ServiceResult<Void> serviceResult = new ServiceResult<>();

        List<Team> teamList = teamRepository.getAllByOrderByTeamId();

        if (teamList.isEmpty()){
            serviceResult.setSuccess(false);
            serviceResult.setErrorMessage("were not found teams");
            return serviceResult;
        }

        teamRepository.deleteAll(teamList);
        serviceResult.setSuccess(true);
        return serviceResult;
    }


}
