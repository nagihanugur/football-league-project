package com.example.footballleagueapi.controller;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.MatchDto;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leagueapi/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<MatchDto>> getAllMatchList() {

        if (matchService.getAllMatches().isSuccess()) {
            return new ResponseEntity<>(matchService.getAllMatches().getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/create")
    public ResponseEntity<List<MatchDto>> createAllMatches(){
        ServiceResult<List<MatchDto>> serviceResult = matchService.createMatches();

        if (serviceResult.isSuccess()){

            return new ResponseEntity<>(matchService.createMatches().getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();

    }



    @GetMapping("/{matchId}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable Integer matchId){

        ServiceResult<MatchDto> serviceResult = matchService.getMatchById(matchId);
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(matchService.getMatchById(matchId).getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }


}

