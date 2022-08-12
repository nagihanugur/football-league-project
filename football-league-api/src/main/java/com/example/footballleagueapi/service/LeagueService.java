package com.example.footballleagueapi.service;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.LeagueDto;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.dto.mapper.LeagueMapper;
import com.example.footballleagueapi.entity.League;
import com.example.footballleagueapi.entity.Team;
import com.example.footballleagueapi.repository.ILeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    private final ILeagueRepository leagueRepository;
    private final LeagueMapper leagueMapper;

    public LeagueService(ILeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
        this.leagueMapper = new LeagueMapper();
    }

    public ServiceResult<List<LeagueDto>> getAllLeagues(){

        List<League> leagueServiceResult =  leagueRepository.getAllByOrderByLeagueId();
        List<LeagueDto> leagueDtoList = leagueMapper.toLeagueDtoList(leagueServiceResult);

        return new ServiceResult<List<LeagueDto>>(leagueDtoList);

    }

    public ServiceResult<LeagueDto> getLeagueById(Integer id){
        ServiceResult<LeagueDto> serviceResult = new ServiceResult<>();

        Optional<League> league = leagueRepository.findById(id);

        if (league.isPresent()){
            serviceResult.setData(leagueMapper.toLeagueDto(league.get()));

            return serviceResult;
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("can't found league by id...");
        return serviceResult;

    }

    public ServiceResult<Void> deleteLeagueById(Integer id){
        ServiceResult<Void> serviceResult = new ServiceResult<>();
        Optional<League> league = leagueRepository.findById(id);
        if (league.isPresent()){

            leagueRepository.deleteById(id);
            serviceResult.setSuccess(true);
            return serviceResult;
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("can't found league by id..");
        return serviceResult;

    }

    public ServiceResult<LeagueDto> saveLeague(LeagueDto leagueDto){

        ServiceResult<LeagueDto> serviceResult = new ServiceResult<>();
        League league = leagueRepository.findLeagueByLeagueId(leagueDto.getLeagueId());

        if (league == null){
            League savedLeague = leagueRepository.save(leagueMapper.toLeague(leagueDto));
            LeagueDto savedDto = leagueMapper.toLeagueDto(savedLeague);
            serviceResult.setData(savedDto);

            return serviceResult;
        }


            league.setName(leagueDto.getName());

            League updateLeague = leagueRepository.save(league);
            LeagueDto updateDto = leagueMapper.toLeagueDto(updateLeague);
            serviceResult.setData(updateDto);

            return serviceResult;


    }




}
