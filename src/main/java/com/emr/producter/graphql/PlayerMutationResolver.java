package com.emr.producter.graphql;

import com.emr.producter.dto.AddPlayerDTO;
import com.emr.producter.entity.Player;
import com.emr.producter.exception.exceptions.PlayerNotFoundException;
import com.emr.producter.repo.PlayerRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Validated
public class PlayerMutationResolver implements GraphQLMutationResolver {

    final PlayerRepository playerRepository;

    public Player addPlayer(@Valid AddPlayerDTO dtoPlayer) {
        Player player = new Player(dtoPlayer.getName(), dtoPlayer.getSurname(), dtoPlayer.getPosition());
        return playerRepository.save(player);
    }

    public Player deletePlayer(@NotNull(message = "Id cannot be empty.") Long id) {
        Optional<Player> player = playerRepository.findById(id);
        playerRepository.deleteById(id);
        return player.orElseThrow(PlayerNotFoundException::new);
    }
}
