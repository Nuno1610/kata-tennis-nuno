package org.kata.tennis;

public class Player {

    private final String name;
    private int points = 0;

    public Player(String name) {
        this.name = name;
    }

    public void score() {
        points++;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}