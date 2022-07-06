package com.example.footballleagueapi.entity;

import javax.persistence.*;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Integer goalId;

    @Column(name = "goal_count")
    private Integer goalCount;

    public Goal(){

    }

    public Goal(Integer goalId, Integer goalCount){
        this.goalId = goalId;
        this.goalCount = goalCount;

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
