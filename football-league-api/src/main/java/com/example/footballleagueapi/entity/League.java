package com.example.footballleagueapi.entity;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "league")
public class League {

    @Id
    @SequenceGenerator(name="jpaPkSeqLeague", sequenceName="league_league_id_seq", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeqLeague")
    @Column(name="league_id")

    private Integer leagueId;

    @Column(name = "name")
    private String name;

   @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    List<Match> matchList;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    List<Team> teamList;


    public League() {
    }

    public League(Integer leagueId, String name,  List<Team> teamList, List<Match> matchList){

        this.leagueId = leagueId;
        this.name = name;
        this.matchList = matchList;
        this.teamList = teamList;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
