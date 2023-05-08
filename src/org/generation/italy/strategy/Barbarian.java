package org.generation.italy.strategy;

public class Barbarian extends Character {
    public Barbarian(int hp, String name) {
        super(hp, name);
        this.offensiveStrategy = new AxeStrategy(this);
        this.defensiveStrategy = new NoShieldStrategy(this);
    }
}
