package com.nba.spring_basketball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/player")
public class PlayerController {


    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayer(String name) {

        if(name != null){
           return playerService.getPlayerByName(name);

        }else{
            return playerService.getPlayer();
        }
    }

//    @GetMapping
//    public List<String> getTeam(String team){
//
//        if(team != null){
//            return playerService.getTeams(team);
//        }
//        return null;
//    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){

        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player resultPlayer = playerService.updatePlayer(player);
        if (resultPlayer != null){
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player Deleted Successfully", HttpStatus.OK);

    }


}

