package com.example.footballleagueapi.service;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.MatchDto;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.dto.mapper.MatchMapper;
import com.example.footballleagueapi.dto.mapper.TeamMapper;
import com.example.footballleagueapi.entity.Match;
import com.example.footballleagueapi.entity.Team;
import com.example.footballleagueapi.repository.IMatchRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchService {

    private final IMatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final TeamMapper teamMapper;

    public MatchService(IMatchRepository matchRepository){
        this.matchRepository = matchRepository;
        this.matchMapper = new MatchMapper();
        this.teamMapper = new TeamMapper();
    }

    public ServiceResult<List<MatchDto>> getAllMatches(){

        List<Match> matches = matchRepository.getAllByOrderByMatchId();
        List<MatchDto> matchDtoList = matchMapper.toMatchDtoList(matches);


        return new ServiceResult<List<MatchDto>>(matchDtoList);
    }

   /* public ServiceResult<List<MatchDto>> createAllMatches(List<TeamDto> teamDtoList){
        List<Match> matchList = new ArrayList<>();

        int sumMatch = teamDtoList.size() - 1;

        Collections.shuffle(teamDtoList);

        for(int i = 1; i <= teamDtoList.size(); i++){
            for(int j = 1; j <= teamDtoList.size(); j++){

                int firstTeam = i;
                int secondTeam = j;

                if(teamDtoList.get(firstTeam) != teamDtoList.get(secondTeam)){

                    Date nowTime = new Date();

                    matchList.add(new Match(teamMapper.toTeam(teamDtoList.get(firstTeam)),teamMapper.toTeam(teamDtoList.get(secondTeam)),null,null, nowTime));

                }
            }
        }

        Collections.shuffle(matchList);

        return new ServiceResult<List<MatchDto>>(matchMapper.toMatchDtoList(matchList));
    }*/

    //Tek haftalık

    public ServiceResult<List<MatchDto>> createAllMatches(List<TeamDto> teamDtoList) {

        ServiceResult<List<MatchDto>> serviceResult = new ServiceResult<>();

        List<Match> matchList = new ArrayList<>();
        List<MatchDto> matchDtoList = (List<MatchDto>) getAllMatches();
        //List<TeamDto> tempList = new ArrayList<>();

        //int sumMatch = teamDtoList.size() - 1;
        int firstHalf = teamDtoList.size() / 2;

        Collections.shuffle(teamDtoList);

        if(firstHalf % 2 == 0) {
            for (int j = 1; j <= firstHalf; j++) {

                int firstTeam = j;
                int secondTeam = (teamDtoList.size() + 1) - j;
                Date firstTime = new Date();
                Date secondTime = new Date();

                Match match = (new Match(teamMapper.toTeam(teamDtoList.get(firstTeam)), teamMapper.toTeam(teamDtoList.get(secondTeam)), null, null, firstTime));
                Match match2 = (new Match(teamMapper.toTeam(teamDtoList.get(secondTeam)), teamMapper.toTeam(teamDtoList.get(firstTeam)),null,null, secondTime));
                if (matchDtoList.contains(match)) {
                    serviceResult.setSuccess(false);
                    serviceResult.setErrorMessage("This match is already exist!");
                    return serviceResult;
                }

                matchList.add(match);
                matchList.add(match2);

            }


            return new ServiceResult<List<MatchDto>>(matchMapper.toMatchDtoList(matchList));
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("Please add team as even count");
        return serviceResult;

    }


}
