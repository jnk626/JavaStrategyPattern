package org.generation.italy.strategy;

import java.util.Random;

public class SmallSwordStrategy implements AttackStrategy{
    private Barbarian owner;
    private Random random = new Random();

    public SmallSwordStrategy(Barbarian owner) {
        this.owner = owner;
    }

    @Override
    public int attack(Character c) {
        int r = random.nextInt(10) + 1;
        int damage = 0;
        if (r <= 8) {
            damage = 5;
        }

        if (damage == 0) {
            System.out.printf("%s manca clamorosamente il bersaglio%n", owner.getName());
        } else {
            System.out.printf("La SPADINA di %s infligge %d a %s%n", owner.getName(), damage, c.getName());
        }

        return damage;
    }
}
