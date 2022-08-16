package com.example.footballleagueapi.controller;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.LeagueDto;
import com.example.footballleagueapi.dto.MatchDto;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.entity.Match;
import com.example.footballleagueapi.entity.Team;
import com.example.footballleagueapi.repository.ITeamRepository;
import com.example.footballleagueapi.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("leagueapi/matches")
public class MatchController {

    private final MatchService matchService;
    private final ITeamRepository teamRepository;

    public MatchController(MatchService matchService, ITeamRepository teamRepository) {
        this.matchService = matchService;
        this.teamRepository = teamRepository;
    }


    @GetMapping()
    public ResponseEntity<List<MatchDto>> getAllMatches(){


        ServiceResult<List<MatchDto>> serviceResult = matchService.getAllMatches();
        if (serviceResult.isSuccess()){

            return new ResponseEntity<List<MatchDto>>(serviceResult.getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/matchesByLeague/{leagueId}")
    public ResponseEntity<List<MatchDto>> getMatchesByLeagueId(@PathVariable Integer leagueId){

        ServiceResult<List<MatchDto>> serviceResult = matchService.getMatchesByLeaguId(leagueId);
        if (serviceResult.isSuccess()){

            return new ResponseEntity<List<MatchDto>>(serviceResult.getData(), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }



    @GetMapping("/create/{id}")
    public ResponseEntity<List<MatchDto>> createAllMatches(@PathVariable Integer id){

        ServiceResult<List<MatchDto>> serviceResult = matchService.createMatches(id);

        if (serviceResult.isSuccess()){

            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllMatches(){
        ServiceResult<Void> serviceResult = matchService.deleteAllMatches();
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }




    @PostMapping("/save")
    public ResponseEntity<List<MatchDto>> saveMatch(@RequestBody List<MatchDto> matchDtoList){

        ServiceResult<List<MatchDto>> serviceResult = matchService.saveMatch(matchDtoList);

        if (serviceResult.isSuccess()){

            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<MatchDto> updateMatch(@RequestBody MatchDto matchDto){

        ServiceResult<MatchDto> serviceResult = matchService.updateMatch(matchDto);

        if (serviceResult.isSuccess()){

            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/deleteByLeagueId/{leagueId}")
    public ResponseEntity<Void> deleteMatchesByLeagueId(@PathVariable Integer leagueId){
        ServiceResult<Void> serviceResult = matchService.deleteMatchesByLeagueId(leagueId);

        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/matchesByDate/{id}/{date}")
    public ResponseEntity<List<MatchDto>> getMatchesByDate(@PathVariable Integer id, @PathVariable Integer date){
        ServiceResult<List<MatchDto>> serviceResult = matchService.getMatchesByDate(id,date);
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }



    @GetMapping("/{matchId}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable Integer matchId){

        ServiceResult<MatchDto> serviceResult = matchService.getMatchById(matchId);
        if (serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }


}

