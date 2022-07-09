package com.emr.producter;

import com.emr.producter.entity.Player;
import com.emr.producter.enums.Position;
import com.emr.producter.repo.PlayerRepository;
import com.graphql.spring.boot.test.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;

import java.io.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
public class GraphQLTests {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    PlayerRepository playerRepository;

    static Player player1 =
            new Player("John", "Doe", Position.SF);

    @Test
    public void testAddPlayer() throws IOException {
        doReturn(player1).when(playerRepository).save(any(Player.class));
        GraphQLResponse res = graphQLTestTemplate.postForResource("graphql/addPlayer.graphql");
        assertThat(res.isOk()).isTrue();
        assertThat(res.get("$.data.addPlayer", Player.class)).isEqualTo(player1);
    }
}
