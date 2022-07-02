package com.emr.producter.enums;

public enum Position {
    PG("Point Guard"),
    SG("Shooting Guard"),
    SF("Small Forward"),
    PF("Power Forward"),
    C("Center");

    private String name;

    Position(String name) {
        this.name = name;
    }
}
