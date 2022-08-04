package com.example.footballleagueapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "game_state")
public class GameState {

    @Id
  //  @SequenceGenerator(name="jpaStateSeq", sequenceName="stateseq", allocationSize=1, initialValue = 1)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaStateSeq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "won")
    private Integer won;

    @Column(name = "lose")
    private Integer lose;

    @Column(name = "draw")
    private Integer draw;

    @Column(name = "played")
    private Integer played;

    public GameState(){

    }
    public GameState(Integer stateId, Integer won, Integer lose, Integer draw, Integer played){

        this.stateId = stateId;
        this.won = won;
        this.lose = lose;
        this.draw = draw;
        this.played = played;
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
