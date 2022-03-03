package com.example.footballManager.controller;

import com.example.footballManager.model.Teams;
import com.example.footballManager.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamsController {
    @Autowired
   private TeamsService teamsService;

    @GetMapping("/allTeams")
    public List<Teams> getAllTeams(){
        return teamsService.teamsList();
    }
    @PostMapping("/addTeams")
    public  void addTeams(@RequestBody Teams teams){
        teamsService.saveTeams(teams);
    }
    @DeleteMapping("/deleteTeams/{id}")
    public void deleteTeams(@PathVariable("id")long id){
        teamsService.deleteTeams(id);
    }
    @PutMapping("/updateTeams")
    public void updateAirCompany(@RequestBody Teams teams) {
        teamsService.saveTeams(teams);
    }
}
