package com.example.footballleagueapi.repository;

import com.example.footballleagueapi.entity.Goal;
import com.example.footballleagueapi.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGoalRepository extends CrudRepository<Goal, Integer> {

    //List<Goal> GetAllGoalsByGoalId();
   // List<Goal> findAllByOrderByGoalId(Integer id);
   // List<Goal> findByGoalId(Integer id);
    List<Goal> getAllByOrderByGoalId();

}
