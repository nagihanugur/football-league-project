package com.example.footballleagueapi.service;

import com.example.footballleagueapi.dto.mapper.GoalMapper;
import com.example.footballleagueapi.repository.IGoalRepository;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    private final IGoalRepository goalRepository;
    private final GoalMapper goalMapper;

    public GoalService(IGoalRepository goalRepository){
        this.goalRepository = goalRepository;
        this.goalMapper = new GoalMapper();
    }


}
