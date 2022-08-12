package com.example.footballleagueapi.dto;
import com.example.footballleagueapi.dto.mapper.LeagueMapper;
import com.example.footballleagueapi.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamDto {
    private Integer teamId;
    private String name;
    private String features;
    private String emblem;
    private Float power;
    private Integer point;
    private Integer won;
    private Integer draw;
    private Integer lose;
    private Integer played;
    private Integer goalCount;
    private LeagueDto leagueDto;

    @Autowired
    private LeagueMapper leagueMapper;

    public TeamDto(){}


    public TeamDto(Integer teamId, String name, String features, String emblem, Float power, Integer point,
                   Integer won, Integer draw, Integer lose, Integer played, Integer goalCount, LeagueDto leagueDto){
        this.teamId = teamId;
        this.name = name;
        this.emblem = emblem;
        this.features = features;
        this.power = power;
        this.point = point;
        this.won = won;
        this.draw = draw;
        this.lose = lose;
        this.played = played;
        this.goalCount = goalCount;
        this.leagueDto = leagueDto;

    }
    public TeamDto(Team team){
        this.teamId = team.getTeamId();
        this.name = team.getName();
        this.features = team.getFeatures();
        this.emblem = team.getEmblem();
        this.power = team.getPower();
        this.point = team.getPoint();
        this.won = team.getWon();
        this.draw = team.getDraw();
        this.lose = team.getLose();
        this.played = team.getPlayed();
        this.goalCount = goalCount;
        this.leagueDto = leagueMapper.toLeagueDto(team.getLeague());

    }

    public Integer getTeamId() {

        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getGoalCount() {
        return goalCount;
    }

    public void setGoalCount(Integer goalCount) {
        this.goalCount = goalCount;
    }

    public LeagueDto getLeagueDto() {
        return leagueDto;
    }

    public void setLeagueDto(LeagueDto leagueDto) {
        this.leagueDto = leagueDto;
    }
}
