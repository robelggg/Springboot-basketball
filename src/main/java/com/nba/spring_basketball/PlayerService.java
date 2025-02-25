package com.nba.spring_basketball;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }

    public List<Player> getPlayer(){
        return playerRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    public List<Player>getPlayerFromTeam(String team){
        return playerRepository.findAll().stream()
                .filter(player -> team.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByName(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().equals(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        Optional<Player> newPlayer = playerRepository.findByName(player.getName());
        if(newPlayer.isEmpty()){

            Player addNewPlayer = new Player();
            addNewPlayer.setName(player.getName());
            addNewPlayer.setTeam(player.getTeam());
            addNewPlayer.setBlocks(player.getBlocks());
            addNewPlayer.setSteals(player.getSteals());
            addNewPlayer.setRebounds(player.getRebounds());
            addNewPlayer.setAssists(player.getAssists());
            addNewPlayer.setMinutesPlayed(player.getMinutesPlayed());
            addNewPlayer.setPointsPerGame(player.getPointsPerGame());


            playerRepository.save(addNewPlayer);
            return addNewPlayer;
        }
        return null;
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());
                if (existingPlayer.isPresent()){

                    Player playerToUpdate = existingPlayer.get();
                    playerToUpdate.setName(updatedPlayer.getName());
                    playerToUpdate.setTeam(updatedPlayer.getTeam());
                    playerToUpdate.setMinutesPlayed(updatedPlayer.getMinutesPlayed());
                    playerToUpdate.setAssists(updatedPlayer.getAssists());
                    playerToUpdate.setBlocks(updatedPlayer.getBlocks());
                    playerToUpdate.setPointsPerGame(updatedPlayer.getPointsPerGame());
                    playerToUpdate.setRebounds(updatedPlayer.getRebounds());
                    playerToUpdate.setSteals(updatedPlayer.getSteals());

                    playerRepository.save(playerToUpdate);
                    return playerToUpdate;
                }
                return null;
    }

    public List<String> getTeams(String team){
        return playerRepository.findAll().stream()
                .map(player -> player.getTeam())
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePlayer(String playerName){
        playerRepository.deleteByName(playerName);
    }
    @Transactional
    public void findPlayer(String playerName){
        playerRepository.findByName(playerName);
    }
}
