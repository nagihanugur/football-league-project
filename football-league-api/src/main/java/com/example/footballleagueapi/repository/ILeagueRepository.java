package com.example.footballleagueapi.repository;

import com.example.footballleagueapi.entity.League;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILeagueRepository extends CrudRepository<League, Integer> {

    List<League> getAllByOrderByLeagueId();
}
