package com.example.footballleagueapi.controller;


import com.example.footballleagueapi.dto.GoalDto;
import com.example.footballleagueapi.service.GoalService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("leagueapi/teams/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @GetMapping
    public ResponseEntity<List<GoalDto>> getAllGoal(){

        if(goalService.getAllGoals().isSuccess()){
            return new ResponseEntity<>(goalService.getAllGoals().getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();

    }

}
