package org.generation.italy.strategy;

public class Mage extends Character{
    public Mage(int hp, String name) {
        super(hp, name);
        this.offensiveStrategy = new LightningBoltStrategy(this);
        this.defensiveStrategy = new MirrorOfDefenseStrategy(this);
    }

    @Override
    public boolean isBadlyHurt() {
        return hp <= INITIAL_HP / 2;
    }
}
