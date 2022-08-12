package com.example.footballleagueapi.repository;

import com.example.footballleagueapi.entity.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILeagueRepository extends CrudRepository<League, Integer> {

    List<League> getAllByOrderByLeagueId();
    League findLeagueByLeagueId(Integer leagueId);
}
