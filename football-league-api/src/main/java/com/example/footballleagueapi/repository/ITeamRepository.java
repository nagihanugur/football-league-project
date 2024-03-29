package com.example.footballleagueapi.repository;

import com.example.footballleagueapi.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeamRepository extends CrudRepository<Team, Integer> {


    List<Team> getAllByOrderByTeamId();

    Team findAllByTeamId(Integer id);
    Team findTeamByTeamId(Integer id);
    List<Team> findAllByLeague_LeagueId(Integer id);



    void deleteByTeamId(Integer id);

    boolean existsByTeamId(Integer id);
}
