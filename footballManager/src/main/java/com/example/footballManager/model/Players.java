package com.example.footballManager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Players  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idplayers;
    private String first_name;
    private String last_name;
    private Integer age;
    private Integer experience;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    @JoinColumn(name = "teams_id",referencedColumnName="idteams" )
    private Teams teams;
}
