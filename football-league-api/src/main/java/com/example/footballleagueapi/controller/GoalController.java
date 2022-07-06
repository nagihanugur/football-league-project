package com.example.footballleagueapi.controller;


import com.example.footballleagueapi.service.GoalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("leagueapi/teams/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }
}
