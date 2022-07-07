package com.example.footballleagueapi.service;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.GoalDto;
import com.example.footballleagueapi.dto.mapper.GoalMapper;
import com.example.footballleagueapi.entity.Goal;
import com.example.footballleagueapi.repository.IGoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    private final IGoalRepository goalRepository;
    private final GoalMapper goalMapper;

    public GoalService(IGoalRepository goalRepository){
        this.goalRepository = goalRepository;
        this.goalMapper = new GoalMapper();
    }

     public ServiceResult<GoalDto> getAllGoalById(Integer goalId){

        ServiceResult<GoalDto> serviceResult = new ServiceResult<>();
        Optional<Goal> goal = goalRepository.findById(goalId);

        if (goal.isPresent()){

            serviceResult.setData(goalMapper.toGoalDto(goal.get()));
            return serviceResult;
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("can't found any goal with this id");
        return serviceResult;
    }


}
