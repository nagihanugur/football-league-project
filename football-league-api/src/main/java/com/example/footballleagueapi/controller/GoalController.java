package com.example.footballleagueapi.controller;


import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.GoalDto;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.service.GoalService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<GoalDto> saveGoal(@RequestBody GoalDto goalDto){

        ServiceResult<GoalDto> serviceResult = goalService.addGoal(goalDto);

        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(goalService.addGoal(goalDto).getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<GoalDto> getGoalById(@PathVariable Integer goalId){
        ServiceResult<GoalDto> serviceResult = goalService.getGoalById(goalId);
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(goalService.getGoalById(goalId).getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();

    }

}
