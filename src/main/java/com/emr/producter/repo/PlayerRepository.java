package com.emr.producter.repo;

import com.emr.producter.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByNameAndSurname(String name, String surname);
    void deleteByNameAndSurname(String name, String surname);
}