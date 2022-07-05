package com.emr.producter.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.emr.producter.entity.Player;
import com.emr.producter.repo.PlayerRepository;
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
