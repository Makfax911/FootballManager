package com.example.footballManager.repository;

import com.example.footballManager.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface PlayersRepository extends JpaRepository<Players,Long> {
    @Query("select p from Players p where p.teams.idteams =:idteams")
    Players getByPlayerId(int id);


}
