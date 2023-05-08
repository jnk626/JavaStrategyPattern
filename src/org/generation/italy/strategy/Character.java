package org.generation.italy.strategy;

public abstract class Character {
    protected final int INITIAL_HP;
    protected int hp;
    protected String name;
    protected AttackStrategy offensiveStrategy;
    protected DefenseStrategy defensiveStrategy;
    protected boolean switched;

    public Character(int hp, String name) {
        this.INITIAL_HP = hp;
        this.hp = hp;
        this.name = name;
    }

    public Character(int hp, String name, AttackStrategy attack, DefenseStrategy defense) {
        this.INITIAL_HP = hp;
        this.hp = hp;
        this.name = name;
        this.offensiveStrategy = attack;
        this.defensiveStrategy = defense;
    }

    public int attack(Character c) {
        return offensiveStrategy.attack(c);
    }

    public int defend(int damage, Character attacker) {
        return defensiveStrategy.defend(damage, attacker);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setOffensiveStrategy(AttackStrategy offensiveStrategy) {
        this.offensiveStrategy = offensiveStrategy;
    }

    public void setDefensiveStrategy(DefenseStrategy defensiveStrategy) {
        this.defensiveStrategy = defensiveStrategy;
    }

    public void setSwitched() {
        this.switched = true;
    }

    public boolean hasSwitched() {
        return switched;
    }

    public int suffer(int damage) {
        hp -= damage;
        if (hp <= 0) {
            System.out.printf("%s IS DEAD, R.I.P.%n", this.getName());
        }
        return hp;
    }

    public boolean isBadlyHurt(){
        return hp < INITIAL_HP * 0.3;
    }

    public boolean isAlive(){
        return hp > 0;
    }
}
