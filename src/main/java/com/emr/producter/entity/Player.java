package com.emr.producter.entity;

import com.emr.producter.enums.Position;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String surname;
    Position position;

    public Player(String name, String surname, Position position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(surname, player.surname) && position == player.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, position);
    }
}
