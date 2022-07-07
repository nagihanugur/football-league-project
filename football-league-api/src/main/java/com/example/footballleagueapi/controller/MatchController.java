package com.example.footballleagueapi.controller;

import com.example.footballleagueapi.dto.MatchDto;
import com.example.footballleagueapi.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
