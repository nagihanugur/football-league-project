package com.example.footballleagueapi.service;

import com.example.footballleagueapi.common.ServiceResult;
import com.example.footballleagueapi.dto.MatchDto;
import com.example.footballleagueapi.dto.TeamDto;
import com.example.footballleagueapi.dto.mapper.LeagueMapper;
import com.example.footballleagueapi.dto.mapper.MatchMapper;
import com.example.footballleagueapi.dto.mapper.TeamMapper;
import com.example.footballleagueapi.entity.Match;
import com.example.footballleagueapi.entity.Team;
import com.example.footballleagueapi.repository.IMatchRepository;
import com.example.footballleagueapi.repository.ITeamRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class MatchService {

    private final IMatchRepository matchRepository;

    private final  MatchMapper matchMapper;
    private final TeamMapper teamMapper;
    private final LeagueMapper leagueMapper;
    private final TeamService teamService;
    private final ITeamRepository teamRepository;


    public MatchService(IMatchRepository matchRepository, TeamService teamService, ITeamRepository teamRepository){
        this.matchRepository = matchRepository;
        this.teamService = teamService;
        this.teamRepository = teamRepository;
        this.leagueMapper = new LeagueMapper();
        this.matchMapper = new MatchMapper();
        this.teamMapper = new TeamMapper();
    }

    public ServiceResult<List<MatchDto>> getAllMatches(){

        List<Match> matches = matchRepository.getAllByOrderByMatchId();
        List<MatchDto> matchDtos = matchMapper.toMatchDtoList(matches);


        return new ServiceResult<List<MatchDto>>(matchDtos);
    }

    public ServiceResult<List<MatchDto>> getMatchesByLeaguId(Integer id){

        List<Match> matches = (List<Match>) matchRepository.findAll();
        ServiceResult<List<MatchDto>> serviceResult = new ServiceResult<>();
        List<Match> matchList = new ArrayList<>();


        for (Match match:matches
        ) {
            if (match.getTeamFirst().getLeague().getLeagueId()== id && match.getTeamSecond().getLeague().getLeagueId() == id){
               matchList.add(match);

            }

        }
        List<MatchDto> matchDtos = matchMapper.toMatchDtoList(matchList);
        serviceResult.setData(matchDtos);
        serviceResult.setSuccess(true);
        return serviceResult;

    }

    public ServiceResult<Void> deleteAllMatches(){

        ServiceResult<Void> serviceResult = new ServiceResult<>();

        List<Match> matchList = matchRepository.getAllByOrderByMatchId();

        if (matchList.isEmpty()){
            serviceResult.setSuccess(false);
            serviceResult.setErrorMessage("were not fount matches");
            return serviceResult;
        }

        matchRepository.deleteAll(matchList);
        serviceResult.setSuccess(true);
        return serviceResult;

    }


    public ServiceResult<MatchDto> getMatchById(Integer id){
        ServiceResult<MatchDto> serviceResult = new ServiceResult<>();

        Optional<Match> match = matchRepository.findById(id);

        if (match.isPresent()){
            serviceResult.setData(matchMapper.toMatchDto(match.get()));
            return serviceResult;
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("can't found match by id...");
        return serviceResult;
    }

    public ServiceResult<List<MatchDto>> saveMatch(List<MatchDto> matchDtoList){


        ServiceResult<List<MatchDto>>serviceResult = new ServiceResult<>();
        List<Match> matchList = new ArrayList<>();

        for (MatchDto matchDto: matchDtoList
             ) {
          Match match = matchRepository.save(matchMapper.toMatch(matchDto));
          matchList.add(match);
        }
        serviceResult.setData(matchMapper.toMatchDtoList(matchList));

        return serviceResult;
    }

    public ServiceResult<MatchDto> updateMatch(MatchDto matchDto){

        Optional<Match> match = matchRepository.findById(matchDto.getMatchId());


        ServiceResult<MatchDto> serviceResult = new ServiceResult<>();
        if(match.isPresent()){

          match.get().setTeamFirst(teamMapper.toTeam(matchDto.getTeamFirst()));
           match.get().setTeamSecond(teamMapper.toTeam(matchDto.getTeamSecond()));
           match.get().setGoalFt(matchDto.getGoalFt());
           match.get().setGoalSt(matchDto.getGoalSt());
         //  match.get().setLeague(leagueMapper.toLeague(matchDto.getLeagueDto()));

            Match updatedMatch =  matchRepository.save(match.get());

            serviceResult.setData(matchMapper.toMatchDto(updatedMatch));

            return serviceResult;

        }else{

            matchRepository.save(match.get());
            serviceResult.setData(matchMapper.toMatchDto(match.get()));

        }
        return serviceResult;
    }

    public ServiceResult<Void> deleteMatchesByLeagueId(Integer id){

        ServiceResult<Void> serviceResult = new ServiceResult<>();
        List<Match> matchList = matchRepository.getAllByOrderByMatchId();

        for (Match match : matchList) {
            if (match.getTeamFirst().getLeague().getLeagueId() == id && match.getTeamSecond().getLeague().getLeagueId() == id){
                matchRepository.delete(match);
            }

        }
        for (Match match : matchList) {
            if (match.getTeamFirst().getLeague().getLeagueId() == id){
                serviceResult.setSuccess(false);
                return serviceResult;
            }

        }

        serviceResult.setSuccess(true);

        return serviceResult;


    }

    public ServiceResult<List<MatchDto>> getMatchesByDate(Integer id, Integer date){

        List<Match> matchList = matchRepository.findAllByLeague_LeagueIdAndAndMatchDate(id, date);
        List<MatchDto> matchDtoList = matchMapper.toMatchDtoList(matchList);

        return new ServiceResult<List<MatchDto>>(matchDtoList);

    }


//CREATE MATCH

   public ServiceResult<List<MatchDto>> createMatches(Integer id){

        ServiceResult<List<MatchDto>> serviceResult = new ServiceResult<>();

        List<Team> teams = teamRepository.findAllByLeague_LeagueId(id);
        teamMapper.toTeamDtoList(teams);


        List<Match> matchList = new ArrayList<>();

        int weekCount = teams.size()-1;
        int matchCountPerWeek = teams.size()/2;

         for(int i=0; i < weekCount; i++){

             for (int j = 0; j < matchCountPerWeek; j++){

                 int firstIndex = j;
                 int secondIndex = (teams.size()-1) - j;

                 Match match = (new Match(teams.get(firstIndex), teams.get(secondIndex),0,0,i+1, teams.get(firstIndex).getLeague()));
                 Match match2 = (new Match(teams.get(secondIndex), teams.get(firstIndex),0,0,i+ teams.size(),teams.get(secondIndex).getLeague()));

               //  Match match = (new Match(teamMapper.toTeam(teams.get(firstIndex)), teamMapper.toTeam(teams.get(secondIndex)),0,0,i+1));
                //  Match match2 = (new Match(teamMapper.toTeam(teams.get(secondIndex)), teamMapper.toTeam(teams.get(firstIndex)),0,0,i+ teams.size()));

                 matchList.add(match);
                 matchList.add(match2);
                 matchRepository.save(match);
                 matchRepository.save(match2);

             }
             List<Team> tempList = new ArrayList<>();
             tempList.add(teams.get(0));
             tempList.add(teams.get(teams.size()-1));

             for (int k = 1; k < teams.size() - 1; k++){  // aradaki takımlar eklendi
                 tempList.add(teams.get(k));
             }
             teams = tempList;
         }

         return new ServiceResult<List<MatchDto>>(matchMapper.toMatchDtoList(matchList));

    }


/*
    public ServiceResult<List<MatchDto>> createMatches(){

        List<Team> teamList = teamRepository.getAllByOrderByTeamId();
        List<Match> matchList = new ArrayList<>();

        int totalWeek = teamList.size() - 1;
        int n = teamList.size();

       /*     for (int i = 1; i < teamList.size() - 1; i++) {

                int rand = (int) (Math.random() * (teamList.size() - 1)) + 1;

                Team stableTeam = teamList.get(rand);
                teamList.remove(stableTeam);

                Date nowDate = new Date();
                Match firstMatch = new Match(null, stableTeam, teamList.get(0), 0, 0, nowDate);
                matchList.add(firstMatch);
                matchRepository.save(firstMatch);
                teamList.remove(teamList.get(0));


        for(int i = 1; i< teamList.size(); i++) {

            Collections.shuffle(teamList);

            for (int j = 0; j < teamList.size() / 2; j++) {

                //Date otherDate = new Date();


                Match otherMatch = new Match(null, teamList.get(j), teamList.get((teamList.size() - 1) - j), 0, 0, i+".Hafta");

                matchList.add(otherMatch);
                matchRepository.save(otherMatch);

            }
        }
          //  }

     //    matchRepository.saveAll(matchList);


        return new ServiceResult<List<MatchDto>>(matchMapper.toMatchDtoList(matchList));


    }

    */

   /* public ServiceResult<List<MatchDto>> createAllMatches(List<TeamDto> teamDtoList){
        List<Match> matchList = new ArrayList<>();

        int sumMatch = teamDtoList.size() - 1;

        Collections.shuffle(teamDtoList);

        for(int i = 1; i < teamDtoList.size(); i++){
            for(int j = 1; j < teamDtoList.size(); j++){

                int firstTeam = i;
                int secondTeam = j;

                if(teamDtoList.get(firstTeam) != teamDtoList.get(secondTeam)){

                Match match = new Match(teamMapper.toTeam(teamDtoList.get(firstTeam)),teamMapper.toTeam(teamDtoList.get(secondTeam)),null,null, nowTime)
                 if (matchList.contains(match)) {
                    serviceResult.setSuccess(false);
                    serviceResult.setErrorMessage("This match is already exist!");
                    return serviceResult;
                }

                    Date nowTime = new Date();

                    matchList.add();

                }
            }
        }

        Collections.shuffle(matchList);

        return new ServiceResult<List<MatchDto>>(matchMapper.toMatchDtoList(matchList));
    }*/

    //Tek haftalık
/*
    public ServiceResult<List<MatchDto>> createAllMatches(List<TeamDto> teamDtoList) {

        ServiceResult<List<MatchDto>> serviceResult = new ServiceResult<>();

        List<Match> matchList = new ArrayList<>();

        //List<TeamDto> tempList = new ArrayList<>();

        //int sumMatch = teamDtoList.size() - 1;
        int firstHalf = teamDtoList.size() / 2;

        Collections.shuffle(teamDtoList);

        if(firstHalf % 2 == 0) {
            for (int j = 0; j < firstHalf; j++) {

                int firstTeam = j;
                int secondTeam = (teamDtoList.size() -1) - j;


                Match match = (new Match(teamMapper.toTeam(teamDtoList.get(firstTeam)), teamMapper.toTeam(teamDtoList.get(secondTeam)), 0, 0, null));
                Match match2 = (new Match(teamMapper.toTeam(teamDtoList.get(secondTeam)), teamMapper.toTeam(teamDtoList.get(firstTeam)),0,0, null));
                if (getAllMatches().getData().contains(match) || getAllMatches().getData().contains(match2)) {
                    serviceResult.setSuccess(false);
                    serviceResult.setErrorMessage("This match is already exist!");
                    return serviceResult;
                }

                matchList.add(match);
                matchList.add(match2);

            }

            return new ServiceResult<List<MatchDto>>(matchMapper.toMatchDtoList(matchList));
        }
        serviceResult.setSuccess(false);
        serviceResult.setErrorMessage("Please add team as even count");
        return serviceResult;

    }
*/

}
