package com.example.footballleagueapi.service;
import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.dto.mapper.LeagueMapper;
import com.example.footballleagueapi.dto.mapper.TeamMapper;
import com.example.footballleagueapi.entity.League;
import com.example.footballleagueapi.entity.Team;
import com.example.footballleagueapi.repository.ILeagueRepository;
import com.example.footballleagueapi.repository.ITeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final ITeamRepository teamRepository;
    private final ILeagueRepository leagueRepository;
    private final TeamMapper teamMapper;
    private final LeagueMapper leagueMapper;

    public TeamService(ITeamRepository teamRepository, ILeagueRepository leagueRepository) {
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;

        this.teamMapper = new TeamMapper();
        this.leagueMapper = new LeagueMapper();

    }

    public ServiceResult<List<TeamDto>> getAll(){

        List<Team> teams = teamRepository.getAllByOrderByTeamId();
        List<TeamDto> teamDtos = teamMapper.toTeamDtoList(teams);


        return new ServiceResult<List<TeamDto>>(teamDtos);
    }

    public ServiceResult<List<TeamDto>> getAllTeamByLeagueId(Integer id){
        List<Team> teams = teamRepository.findAllByLeague_LeagueId(id);
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

   //     Team team = teamRepository.findTeamByTeamId(teamDto.getTeamId());


          Team savedTeam = teamRepository.save(teamMapper.toTeam(teamDto));
          serviceResult.setData(teamMapper.toTeamDto(savedTeam));
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
           team.get().setWon(teamDto.getWon());
           team.get().setDraw(teamDto.getDraw());
           team.get().setLose(teamDto.getLose());
           team.get().setPlayed(teamDto.getPlayed());
           team.get().setGoalCount(teamDto.getGoalCount());
           team.get().setLeague(leagueMapper.toLeague(teamDto.getLeagueDto()));


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
