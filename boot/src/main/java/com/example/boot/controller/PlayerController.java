package com.example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.entities.Player;
import com.example.boot.service.PlayerService;

@RestController
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;

    @GetMapping("/player/id/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id){
        Player player = this.playerService.findPlayerById(id);
        if(player.getPlayerId() != 0){
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(player, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/player/{name}")
    public ResponseEntity<Player> getPlayerByName(@PathVariable String name){
        Player player = this.playerService.findByPlayerName(name);
        if(player.getPlayerId() != 0){
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(player, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> players = this.playerService.findAllPlayers();
        if(players.size() != 0){
            return new ResponseEntity<>(players, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(players, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/player")
    public ResponseEntity<String> createPlayer(@RequestBody Player player){
        String message = this.playerService.createPlayer(player);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PatchMapping("/player")
    public ResponseEntity<String> updatePlayer(@RequestBody Player player){
        String message = this.playerService.updatePlayer(player);
        if(message.length() == 27){
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id){
        try{
            String message = this.playerService.deletePlayerById(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>("COULD NOT DELETE PLAYER", HttpStatus.BAD_REQUEST);
        }
    }


}
