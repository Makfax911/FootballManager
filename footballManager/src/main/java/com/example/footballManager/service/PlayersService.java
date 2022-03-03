package com.example.footballManager.service;

import com.example.footballManager.model.Players;
import com.example.footballManager.model.Teams;
import com.example.footballManager.repository.PlayersRepository;
import com.example.footballManager.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlayersService {
    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private TeamsRepository teamsRepository;

    public List<Players> playersList(){
        return playersRepository.findAll();
    }
    public Players savePlayers(Players players){
        playersRepository.save(players);
        return players;
    }
    public Players getPlayers(long id){
        return playersRepository.findById(id).get();
    }
    public void deletePlayers(long id){
        playersRepository.deleteById(id);
    }
    @Transactional
    public void changeTeam( long idPlayers, long teams_id){
     Optional<Players> players= Optional.of(playersRepository.getById(idPlayers));
     if(!players.isPresent())throw new RuntimeException("player not found");
     Optional<Teams> teams1= Optional.of(teamsRepository.getById(teams_id));
     if(!teams1.isPresent())throw new RuntimeException("team not found");
     Players players1=players.get();
     players1.setTeams(teams1.get());
     playersRepository.save(players1);
    }
//    public double transferCost(int experience, int age, long teams_id){
//        Players playersExperience= playersRepository.getByPlayerId(experience);
//        Players playersAge=playersRepository.getByPlayerId(age);
//        Teams teamsCommission=teamsRepository.getById(teams_id);
//        double transferPlayerCommission= ((playersExperience.getExperience() * 100000) / (playersAge.getAge() / 12)*100)/teamsCommission.getCommission();
//        return transferPlayerCommission;
//    }
//    public void buyingPlayer(long idPlayers, long teams_id, double cash_balance,int experience,int age){
//        Optional<Players> players= Optional.of(playersRepository.getById(idPlayers));
//        if(!players.isPresent())throw new RuntimeException("player not found");
//        Optional<Teams> teams1= Optional.of(teamsRepository.getById(teams_id));
//        if(!teams1.isPresent())throw new RuntimeException("team not found");
//        Optional<Teams> balanceTeam=Optional.of(teamsRepository.getById(teams_id));
//        if(cash_balance<transferCost(experience, age, teams_id)){
//            throw new RuntimeException("not enough balance");
//        }else {
////            Teams balance1=balanceTeam.get();
////            balance1.setTeams(teams1.get());
////            teamsRepository.save(balance1);
//            Teams balanceTeam1=teams1.get();
//            balanceTeam1.setCash_balance(teams1.get());
//
//        }
//    }
}
