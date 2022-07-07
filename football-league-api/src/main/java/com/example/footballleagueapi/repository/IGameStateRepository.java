package com.example.footballleagueapi.repository;

import com.example.footballleagueapi.entity.GameState;
import com.example.footballleagueapi.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGameStateRepository extends CrudRepository<GameState, Integer> {

   // List<GameState> findGameStatesByStateId();
    List<GameState> getAllByOrderByStateId();

}
