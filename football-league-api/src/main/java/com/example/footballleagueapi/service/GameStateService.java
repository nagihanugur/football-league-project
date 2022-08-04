package com.example.footballleagueapi.service;


import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.GameStateDto;
import com.example.footballleagueapi.dto.mapper.GameStateMapper;
import com.example.footballleagueapi.entity.GameState;
import com.example.footballleagueapi.repository.IGameStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ServiceResult<GameStateDto> addState( GameStateDto stateDto){
        ServiceResult<GameStateDto> serviceResult = new ServiceResult<>();
        Optional<GameState> state = gameStateRepository.findById(stateDto.getStateId());

        if (state.isPresent()){
            state.get().setWon(stateDto.getWon());
            state.get().setDraw(stateDto.getDraw());
            state.get().setLose(stateDto.getLose());
            state.get().setPlayed(stateDto.getPlayed());

            GameState updatedState = gameStateRepository.save(state.get());
            serviceResult.setData(gameStateMapper.toGameStateDto(updatedState));
            return serviceResult;
        }

        GameState updatedState = gameStateRepository.save(gameStateMapper.toGameState(stateDto));
        serviceResult.setData(gameStateMapper.toGameStateDto(updatedState));
        return serviceResult;


    }

    public ServiceResult<GameStateDto> getStateById(Integer id){
        ServiceResult<GameStateDto> serviceResult = new ServiceResult<>();

        Optional<GameState> state = gameStateRepository.findById(id);

        if (state.isPresent()){

            serviceResult.setData(gameStateMapper.toGameStateDto(state.get()));
            return serviceResult;

        }

        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("was not found state by id..");
        return serviceResult;
    }



}
