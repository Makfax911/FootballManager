package com.example.footballManager.repository;

import com.example.footballManager.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TeamsRepository extends JpaRepository<Teams,Long> {
}
