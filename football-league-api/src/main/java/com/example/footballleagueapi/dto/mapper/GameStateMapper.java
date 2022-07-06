package com.example.footballleagueapi.dto.mapper;

import com.example.footballleagueapi.dto.GameStateDto;
import com.example.footballleagueapi.entity.GameState;

import java.util.ArrayList;
import java.util.List;

public class GameStateMapper {

    public GameStateDto toGameStateDto(GameState gameState){

        GameStateDto dto = new GameStateDto();
        dto.setStateId(gameState.getStateId());
        dto.setWon(gameState.getWon());
        dto.setLose(gameState.getLose());
        dto.setDraw(gameState.getDraw());
        dto.setPlayed(gameState.getPlayed());

        return dto;
    }

    public List<GameStateDto> toGameStateList(List<GameState> gameStates){

        List<GameStateDto> dtos = new ArrayList<>();
        gameStates.forEach(gameState -> dtos.add(toGameStateDto(gameState)));

        return dtos;
    }

    public GameState toGameState(GameStateDto gameStateDto){

        GameState gameState = new GameState();
        gameState.setStateId(gameStateDto.getStateId());
        gameState.setWon(gameStateDto.getWon());
        gameState.setLose(gameStateDto.getLose());
        gameState.setDraw(gameStateDto.getDraw());
        gameState.setPlayed(gameStateDto.getPlayed());

        return gameState;
    }
}
