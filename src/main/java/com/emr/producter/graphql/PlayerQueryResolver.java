package com.emr.producter.graphql;

import com.emr.producter.entity.Player;
import com.emr.producter.repo.PlayerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {

    final PlayerRepository playerRepository;

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }
}
