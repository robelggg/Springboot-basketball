package com.nba.spring_basketball;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @Column(name = "name", unique=true)
    private String name;
    private String team;
    private Double blocks;
    private Double steals;
    private Double rebounds;
    private Double assists;
    @Column(name = "minutes_played")
    private Double minutesPlayed;
    @Column(name="points_per_game")
    private Double pointsPerGame;

    public Player() {

    }

    public Player(String name, String team, Double blocks, Double steals, Double rebounds, Double assists,
                  Double minutesPlayed, Double pointsPerGame) {
        this.name = name;
        this.team = team;
        this.blocks = blocks;
        this.steals = steals;
        this.rebounds = rebounds;
        this.assists = assists;
        this.minutesPlayed = minutesPlayed;
        this.pointsPerGame = pointsPerGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getBlocks() {
        return blocks;
    }

    public void setBlocks(Double blocks) {
        this.blocks = blocks;
    }

    public Double getSteals() {
        return steals;
    }

    public void setSteals(Double steals) {
        this.steals = steals;
    }

    public Double getRebounds() {
        return rebounds;
    }

    public void setRebounds(Double rebounds) {
        this.rebounds = rebounds;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public Double getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Double minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Double getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(Double pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", blocks=" + blocks +
                ", steals=" + steals +
                ", rebounds=" + rebounds +
                ", assists=" + assists +
                ", minutesPlayed=" + minutesPlayed +
                ", pointsPerGame=" + pointsPerGame +
                '}';
    }
}
