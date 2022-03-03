package com.example.footballManager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity

public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idteams;
    private String name_teams;
    private Double cash_balance;
    private Double commission;




}
