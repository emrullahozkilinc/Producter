package com.emr.producter.entity;

import com.emr.producter.enums.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
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
}
