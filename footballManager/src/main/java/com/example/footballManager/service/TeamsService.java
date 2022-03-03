package com.example.footballManager.service;

import com.example.footballManager.model.Teams;
import com.example.footballManager.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {
    @Autowired
    private TeamsRepository teamsRepository;

    public List<Teams> teamsList(){
        return teamsRepository.findAll();
    }
    public Teams saveTeams(Teams teams){
        teamsRepository.save(teams);
        return teams;
    }
    public Teams getTeams(long id){
        return teamsRepository.findById(id).get();
    }
    public void deleteTeams(long id){
        teamsRepository.deleteById(id);
    }
}
