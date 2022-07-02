package com.emr.producter;

import com.emr.producter.entity.Player;
import com.emr.producter.enums.Position;
import com.emr.producter.repo.PlayerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void createPlayerTest() {
        playerRepository.save(new Player("John", "Smith", Position.PG));

        Iterable<Player> players = playerRepository.findAll();
        Assertions.assertThat(players).extracting(Player::getName).contains("John");
    }

    @Test
    public void deletePlayerTest() {
        playerRepository.save(new Player("Bat", "Man", Position.SF));

        int length = playerRepository.findAll().size();
        playerRepository.deleteByNameAndSurname("Bat", "Man");
        Assertions.assertThat(length-1).isEqualTo(playerRepository.findAll().size());
    }
}
