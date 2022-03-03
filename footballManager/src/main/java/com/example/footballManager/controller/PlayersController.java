package com.example.footballManager.controller;

import com.example.footballManager.model.Players;
import com.example.footballManager.repository.TeamsRepository;
import com.example.footballManager.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayersController {
    @Autowired
    public PlayersService playersService;
    @Autowired
    public TeamsRepository teamsRepository;

    @GetMapping("/allPlayers")
    public List<Players> getAllPlayers(){
        return playersService.playersList();
    }
    @PostMapping("/addPlayers")
    public void addPlayers(@RequestBody Players players){
        playersService.savePlayers(players);
    }
    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable("id")long id){
        playersService.deletePlayers(id);
    }
    @PutMapping("/updatePlayers")
    public void updatePlayer(@RequestBody Players players){
        playersService.savePlayers(players);
    }
    @GetMapping("/changeTeam/{idPlayers}/{teams_id}")
    public ResponseEntity changeTeams(@PathVariable long idPlayers, @PathVariable long teams_id/*,@PathVariable double cash_balance,@PathVariable int experince,@PathVariable int age*/){
      try {
        //  playersService.buyingPlayer(idPlayers,teams_id,cash_balance,experince,age);
          playersService.changeTeam(idPlayers,teams_id);
      }catch (Exception e){
          return ResponseEntity.badRequest().body(e.getMessage());
      }
        return ResponseEntity.ok("ok");
    }
}
