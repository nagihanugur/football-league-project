package com.example.footballleagueapi.dto;

import com.example.footballleagueapi.entity.Goal;

public class GoalDto {

    Integer goalId;
    Integer goalCount;

    public GoalDto(){}

    public GoalDto(Integer goalId, Integer goalCount){
        this.goalId = goalId;
        this.goalCount = goalCount;

    }

    public GoalDto(Goal goal){
        this.goalId= goal.getGoalId();
        this.goalCount = goal.getGoalCount();
    }

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public Integer getGoalCount() {
        return goalCount;
    }

    public void setGoalCount(Integer goalCount) {
        this.goalCount = goalCount;
    }
}
