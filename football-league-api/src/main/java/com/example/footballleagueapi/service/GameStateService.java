package com.example.footballleagueapi.service;


import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.GameStateDto;
import com.example.footballleagueapi.dto.mapper.GameStateMapper;
import com.example.footballleagueapi.entity.GameState;
import com.example.footballleagueapi.repository.IGameStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameStateService {

    private final IGameStateRepository gameStateRepository;
    private final GameStateMapper gameStateMapper;

    public GameStateService(IGameStateRepository gameStateRepository){
        this.gameStateRepository = gameStateRepository;
        this.gameStateMapper = new GameStateMapper();
    }

    public ServiceResult<List<GameStateDto>> getAllState(){

        List<GameState> states = gameStateRepository.getAllByOrderByStateId();
        List<GameStateDto> stateDtos = gameStateMapper.toGameStateList(states);

        return new ServiceResult<>(stateDtos);

    }


}
