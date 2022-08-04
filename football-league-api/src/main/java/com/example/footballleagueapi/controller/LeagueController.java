package com.example.footballleagueapi.controller;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.LeagueDto;
import com.example.footballleagueapi.repository.IMatchRepository;
import com.example.footballleagueapi.service.LeagueService;
import com.example.footballleagueapi.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/leagues")
public class LeagueController {

    private final LeagueService leagueService;
    private final MatchService matchService;
    private final IMatchRepository matchRepository;


    public LeagueController(LeagueService leagueService, MatchService matchService, IMatchRepository matchRepository) {
        this.leagueService = leagueService;
        this.matchService = matchService;
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public ResponseEntity<List<LeagueDto>> getAllLeagues(){

        ServiceResult<List<LeagueDto>> serviceResult = leagueService.getAllLeagues();

        if (serviceResult.isSuccess()){

            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/save")
    public ResponseEntity<LeagueDto> saveLeague(@RequestBody LeagueDto leagueDto){

        ServiceResult<LeagueDto> serviceResult = leagueService.saveLeague(leagueDto);
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();

    }

    @PutMapping("/update")
    public ResponseEntity<LeagueDto> updateLeague(@RequestBody LeagueDto leagueDto){

        ServiceResult<LeagueDto> serviceResult = leagueService.saveLeague(leagueDto);
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();

    }
}
