package com.example.footballleagueapi.service;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.MatchDto;
import com.example.footballleagueapi.dto.mapper.MatchMapper;
import com.example.footballleagueapi.entity.Match;
import com.example.footballleagueapi.repository.IMatchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private final IMatchRepository matchRepository;
    private final MatchMapper matchMapper;

    public MatchService(IMatchRepository matchRepository){
        this.matchRepository = matchRepository;
        this.matchMapper = new MatchMapper();
    }

    public ServiceResult<List<MatchDto>> getAllMatches(){

        List<Match> matches = matchRepository.getAllByOrderByMatchId();
        List<MatchDto> matchDtoList = matchMapper.toMatchDtoList(matches);

        return new ServiceResult<List<MatchDto>>(matchDtoList);
    }
}
