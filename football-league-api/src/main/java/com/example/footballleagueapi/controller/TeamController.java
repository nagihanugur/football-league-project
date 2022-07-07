package com.example.footballleagueapi.controller;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        if(teamService.getAll().isSuccess()){

            return new ResponseEntity<>(teamService.getAll().getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();

    }
}
