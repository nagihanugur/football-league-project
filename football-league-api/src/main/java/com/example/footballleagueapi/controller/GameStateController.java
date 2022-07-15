package com.example.footballleagueapi.controller;


import com.example.footballleagueapi.dto.GameStateDto;
import com.example.footballleagueapi.service.GameStateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leagueapi/teams/gamestates")
public class GameStateController {

    private final GameStateService gameStateService;

    public GameStateController(GameStateService gameStateService){
        this.gameStateService = gameStateService;
    }

    @GetMapping
    public ResponseEntity<List<GameStateDto>> getStates(){

        if(gameStateService.getAllState().isSuccess()){

            return new ResponseEntity<>(gameStateService.getAllState().getData(), HttpStatus.OK);

        }

        return ResponseEntity.badRequest().header(gameStateService.getAllState().getErrorMessage()).build();
    }

    @PostMapping
    public ResponseEntity<GameStateDto> saveState(GameStateDto dto){

        if (gameStateService.addState(dto).isSuccess()){
            return new ResponseEntity<>(gameStateService.addState(dto).getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();

    }
}
