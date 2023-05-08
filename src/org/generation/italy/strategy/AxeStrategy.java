package org.generation.italy.strategy;

import java.util.Random;

public class AxeStrategy implements AttackStrategy{
    private Barbarian owner;
    private Random random = new Random();

    public AxeStrategy(Barbarian owner) {
        this.owner = owner;
    }

    @Override
    public int attack(Character c) {
        int r = random.nextInt(10) + 1;
        int damage = 0;
        if (r >= 6 && r <= 10) {
            damage = 50;
        } else if (r == 5) {
            damage = 10;
        }

        if (damage == 0) {
            System.out.printf("%s manca clamorosamente il bersaglio%n", owner.getName());
        } else {
            System.out.printf("L'ASCIA di %s infligge %d a %s%n", owner.getName(), damage, c.getName());
        }

        return damage;
    }
}
