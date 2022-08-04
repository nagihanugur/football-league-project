package com.example.footballleagueapi.entity;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "league")
public class League {

    @Id
    @Column(name = "league_id")
    private Integer leagueId;

    @Column(name = "name")
    private String name;


    public League() {
    }

    public League(Integer leagueId, String name){

        this.leagueId = leagueId;
        this.name = name;

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

}
