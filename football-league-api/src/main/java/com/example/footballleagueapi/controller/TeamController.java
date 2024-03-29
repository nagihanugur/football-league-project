package com.example.footballleagueapi.controller;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("leagueapi/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams(){
        ServiceResult<List<TeamDto>> serviceResult = teamService.getAll();

        if(serviceResult.isSuccess()){

            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamDto> getAllById(@PathVariable Integer teamId){

        ServiceResult<TeamDto> serviceResult = teamService.getTeamById(teamId);
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("leagueId/{leagueId}")
    public ResponseEntity<List<TeamDto>> getAllTeamByLeagueId(@PathVariable Integer leagueId){

        ServiceResult<List<TeamDto>> serviceResult = teamService.getAllTeamByLeagueId(leagueId);

        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/save")
    public ResponseEntity<TeamDto> save(@RequestBody TeamDto teamDto){
        ServiceResult<TeamDto> serviceResult = teamService.saveTeam(teamDto);

        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{teamId}")
    public ResponseEntity<TeamDto> update(@RequestBody TeamDto teamDto, @PathVariable Integer teamId){
        ServiceResult<TeamDto> serviceResult = teamService.updateTeam(teamDto, teamId);

        if(serviceResult.isSuccess()){

            return new ResponseEntity<>(serviceResult.getData(),HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable Integer teamId){
        return new ResponseEntity<>(teamService.deleteTeamById(teamId).getData(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllTeam(){
        return new ResponseEntity<>(teamService.deleteAllTeam().getData(), HttpStatus.OK);
    }
}
