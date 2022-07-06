package com.example.footballleagueapi.dto;

import com.example.footballleagueapi.entity.GameState;

public class GameStateDto {

    private Integer stateId;
    private Integer won;
    private Integer lose;
    private Integer draw;
    private Integer played;

    public GameStateDto(){}

    public GameStateDto(Integer stateId, Integer won, Integer lose, Integer draw, Integer played){
        this.stateId = stateId;
        this.won = won;
        this.lose = lose;
        this.draw = draw;
        this.played = played;
    }

    public GameStateDto(GameState gameState){
        this.stateId = gameState.getStateId();
        this.won = gameState.getWon();
        this.lose = gameState.getLose();
        this.draw = gameState.getDraw();
        this.played = gameState.getPlayed();
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }
}
