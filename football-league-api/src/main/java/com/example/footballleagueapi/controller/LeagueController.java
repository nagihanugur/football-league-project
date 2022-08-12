package com.example.footballleagueapi.controller;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.LeagueDto;
import com.example.footballleagueapi.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ExcludeDefaultListeners;
import java.util.List;
@RestController
@RequestMapping("leagueapi/leagues")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }


    @GetMapping
    public ResponseEntity<List<LeagueDto>> getLeagues(){

        ServiceResult<List<LeagueDto>> serviceResult = leagueService.getAllLeagues();

        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{leagueId}")
    public ResponseEntity<LeagueDto> getLeagueById(@PathVariable Integer leagueId){
        ServiceResult<LeagueDto> serviceResult = leagueService.getLeagueById(leagueId);

        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/delete/{leagueId}")
    public ResponseEntity<Void> deleteLeagueById(@PathVariable Integer leagueId){
        ServiceResult<Void> serviceResult = leagueService.deleteLeagueById(leagueId);
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

}
