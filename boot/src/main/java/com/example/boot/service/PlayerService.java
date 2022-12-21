package com.example.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.entities.Player;
import com.example.boot.repository.PlayerDao;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerDao playerDao;

    public Player findPlayerById(int id){
        Optional<Player> possiblePlayer = this.playerDao.findById(id);
        if(possiblePlayer.isPresent()){
            return possiblePlayer.get();
        } else{
            return new Player();
        }
    }

    public Player findByPlayerName(String name){
        Optional<Player> possiblePlayer = this.playerDao.findByPlayerName(name);
        if(possiblePlayer.isPresent()){
            return possiblePlayer.get();
        } else{
            return new Player();
        }
    }

    public List<Player> findAllPlayers(){
        return this.playerDao.findAll();
    }

    public String createPlayer(Player player){
        this.playerDao.createPlayer(player.getPlayerName(), player.getPlayerTeamId());
        return "Player created";
    }

    public String updatePlayer(Player player){
        int rowCount = this.playerDao.updatePlayer(player.getPlayerName(), player.getPlayerTeamId(), player.getPlayerId());
        if(rowCount == 1){
            return "Player updated successfully";
        } else{
            return "Something went wrong";
        }
    }

    public String deletePlayerById(int id){
        this.playerDao.deleteById(id);
        return "Player with given id deleted";
    }

}
