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

   public ServiceResult<List<GoalDto>> getAllGoals(){

        List<Goal> goals = goalRepository.getAllByOrderByGoalId();
        List<GoalDto> goalDtoList = goalMapper.toGoalDtoList(goals);

        return new ServiceResult<List<GoalDto>>(goalDtoList);
   }


}
