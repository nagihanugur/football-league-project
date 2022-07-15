package com.example.footballleagueapi.controller;

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

    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<MatchDto>> getAllMatchList(){

        if (matchService.getAllMatches().isSuccess()){
            return new ResponseEntity<>(matchService.getAllMatches().getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<List<MatchDto>> getCreatingMatches(@RequestBody List<TeamDto> teamList){
        if(matchService.createAllMatches(teamList).isSuccess()){

            return new ResponseEntity<>(matchService.createAllMatches(teamList).getData(), HttpStatus.OK);

        }

        return ResponseEntity.badRequest().build();
    }
}
