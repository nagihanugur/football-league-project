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

    public ServiceResult<List<MatchDto>> createAllMatches(List<TeamDto> teamDtoList) {

        List<Match> matchList = new ArrayList<>();
        //List<MatchDto> matchDtoList = new ArrayList<>();
        //List<TeamDto> tempList = new ArrayList<>();

        //int sumMatch = teamDtoList.size() - 1;
        int firstHalf = teamDtoList.size() / 2;

        Collections.shuffle(teamDtoList);


            for (int j = 1; j <= firstHalf; j++) {

                int firstTeam = j;
                int secondTeam = (teamDtoList.size() + 1) - j;
                Date nowTime = new Date();


                matchList.add(new Match(teamMapper.toTeam(teamDtoList.get(firstTeam)),teamMapper.toTeam(teamDtoList.get(secondTeam)),null,null, nowTime));


            }



        return new ServiceResult<List<MatchDto>>(matchMapper.toMatchDtoList(matchList));


    }


}
