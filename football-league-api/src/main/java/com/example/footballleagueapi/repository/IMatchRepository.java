package com.example.footballleagueapi.repository;

import com.example.footballleagueapi.entity.Match;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMatchRepository extends CrudRepository<Match,Integer> {

    List<Match> getAllByOrderByMatchId();


}
