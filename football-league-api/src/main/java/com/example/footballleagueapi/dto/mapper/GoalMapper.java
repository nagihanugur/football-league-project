package com.example.footballleagueapi.dto.mapper;

import com.example.footballleagueapi.dto.GoalDto;
import com.example.footballleagueapi.entity.Goal;

import java.util.ArrayList;
import java.util.List;

public class GoalMapper {

    public GoalDto toGoalDto( Goal goal){

        GoalDto dto = new GoalDto();
        dto.setGoalId(goal.getGoalId());
        dto.setGoalCount(goal.getGoalCount());

        return dto;
    }

    public List<GoalDto> toGoalDtoList(List<Goal> goals){
        List<GoalDto> dtos = new ArrayList<>();
        goals.forEach(goal -> dtos.add(toGoalDto(goal)));

        return dtos;
    }

    public Goal toGoal( GoalDto goalDto){

        Goal goal = new Goal();
        goal.setGoalId(goalDto.getGoalId());
        goal.setGoalCount(goalDto.getGoalCount());

        return goal;
    }

}
