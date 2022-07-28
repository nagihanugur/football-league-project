package com.example.footballleagueapi.service;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.GoalDto;
import com.example.footballleagueapi.dto.TeamDto;
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

   public ServiceResult<List<GoalDto>> getAllGoals(){

        List<Goal> goals = goalRepository.getAllByOrderByGoalId();
        List<GoalDto> goalDtoList = goalMapper.toGoalDtoList(goals);

        return new ServiceResult<List<GoalDto>>(goalDtoList);
   }

   public ServiceResult<GoalDto> addGoal(GoalDto goalDto){
        ServiceResult<GoalDto> serviceResult = new ServiceResult<>();
        if ( goalDto.getGoalCount() == null){

            serviceResult.setErrorMessage("Please fill all requirements!!");
            serviceResult.setSuccess(false);
            return serviceResult;
        }
        Goal addedGoal = goalRepository.save(goalMapper.toGoal(goalDto));
        serviceResult.setData(goalMapper.toGoalDto(addedGoal));
        return serviceResult;



   }

   public ServiceResult<GoalDto> getGoalById(Integer goalId){

       ServiceResult<GoalDto> serviceResult = new ServiceResult<>();

       Optional<Goal> goal = goalRepository.findById(goalId);

       if (goal.isPresent()){

           serviceResult.setData(goalMapper.toGoalDto(goal.get()));
           return serviceResult;

       }

       serviceResult.setSuccess(false);
       serviceResult.setErrorMessage("this goal was not found...");
       return serviceResult;

   }


}
