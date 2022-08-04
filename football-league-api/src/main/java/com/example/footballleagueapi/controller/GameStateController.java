package com.example.footballleagueapi.controller;


import com.example.footballleagueapi.common.ServiceResult;
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
        ServiceResult<List<GameStateDto>> serviceResult = gameStateService.getAllState();

        if(serviceResult.isSuccess()){

            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);

        }

        return ResponseEntity.badRequest().header(gameStateService.getAllState().getErrorMessage()).build();
    }

    @GetMapping("/{state_id}")
    public ResponseEntity<GameStateDto> getStateById(@PathVariable Integer state_id){

        ServiceResult<GameStateDto> serviceResult = gameStateService.getStateById(state_id);
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<GameStateDto> saveState(@RequestBody GameStateDto gameStateDto){

        ServiceResult<GameStateDto> serviceResult = gameStateService.addState(gameStateDto);

        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();

    }

    @PutMapping
    public ResponseEntity<GameStateDto> updateState(@RequestBody GameStateDto gameStateDto){

        ServiceResult<GameStateDto> serviceResult = gameStateService.addState(gameStateDto);

        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();

    }


}
