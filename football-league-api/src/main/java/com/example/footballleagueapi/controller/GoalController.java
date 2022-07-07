package com.example.footballleagueapi.controller;


import com.example.footballleagueapi.dto.GoalDto;
import com.example.footballleagueapi.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("leagueapi/teams/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<GoalDto> findGoalById(Integer goalId){

        if (goalService.getAllGoalById(goalId).isSuccess()){

            return new ResponseEntity<>(goalService.getAllGoalById(goalId).getData(), HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();


    }
}
