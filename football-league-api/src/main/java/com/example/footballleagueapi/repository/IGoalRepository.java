package com.example.footballleagueapi.repository;

import com.example.footballleagueapi.entity.Goal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGoalRepository extends CrudRepository<Goal, Integer> {

}
