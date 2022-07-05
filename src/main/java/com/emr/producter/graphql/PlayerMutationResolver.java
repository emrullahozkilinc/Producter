package com.emr.producter.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.emr.producter.dto.AddPlayerDTO;
import com.emr.producter.entity.Player;
import com.emr.producter.exception.PlayerNotFoundException;
import com.emr.producter.repo.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    final PlayerRepository playerRepository;

    public Player addPlayer(AddPlayerDTO dtoPlayer) {
        Player player = new Player(dtoPlayer.getName(), dtoPlayer.getSurname(), dtoPlayer.getPosition());
        return playerRepository.save(player);
    }

    public Player deletePlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        playerRepository.deleteById(id);
        return player.orElseThrow(PlayerNotFoundException::new);
    }
}
