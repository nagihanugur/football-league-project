package com.example.footballleagueapi.service;


import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.LeagueDto;
import com.example.footballleagueapi.dto.mapper.LeagueMapper;
import com.example.footballleagueapi.dto.mapper.MatchMapper;
import com.example.footballleagueapi.entity.League;
import com.example.footballleagueapi.repository.ILeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    private final ILeagueRepository leagueRepository;
    private final LeagueMapper leagueMapper;
  //  private final MatchMapper matchMapper;
    private final MatchService matchService;

    public LeagueService(ILeagueRepository leagueRepository,  MatchService matchService) {
        this.leagueRepository = leagueRepository;
        this.leagueMapper = new LeagueMapper();
       // this.matchMapper = new MatchMapper(leagueMapper);
        this.matchService = matchService;
    }

    public ServiceResult<List<LeagueDto>> getAllLeagues(){

        List<League> leagues =  leagueRepository.getAllByOrderByLeagueId();
        List<LeagueDto> leagueDtoList = leagueMapper.toLeagueDtoList(leagues);


        return new ServiceResult<List<LeagueDto>>(leagueDtoList);
    }

    public ServiceResult<LeagueDto> saveLeague(LeagueDto leagueDto){

        Optional<League> league = leagueRepository.findById(leagueDto.getLeagueId());


        ServiceResult<LeagueDto> serviceResult = new ServiceResult<>();
        if(league.isPresent()){

            league.get().setLeagueId(leagueDto.getLeagueId());
            league.get().setName(leagueDto.getName());
        //    league.get().setMatches(matchMapper.toMatchList(leagueDto.getMatches()));

            League updatedLeague = leagueRepository.save(league.get());
           serviceResult.setData(leagueMapper.toLeagueDto(updatedLeague));
           return serviceResult;


        }else{

           leagueRepository.save(league.get());
           serviceResult.setData(leagueMapper.toLeagueDto(league.get()));
           return serviceResult;

        }

    }
}
