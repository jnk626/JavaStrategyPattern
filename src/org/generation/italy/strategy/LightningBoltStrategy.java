package org.generation.italy.strategy;

import java.util.Random;

public class LightningBoltStrategy implements AttackStrategy{
    private Mage owner;
    private Random random = new Random();

    public LightningBoltStrategy(Mage owner) {
        this.owner = owner;
    }

    @Override
    public int attack(Character c) {
        // 5/10 -> 30 hp
        // 1/10 -> 30 self damage
        // 4/10 -> 15 hp
        int r = random.nextInt(10) + 1;
        int damage = 0;
        int selfInflicted = 0;
        if (r >= 1 && r <= 5) {
            damage = 10;
        } else if (r >= 6 && r <= 9) {
            damage = 1;
        } else {
            selfInflicted = 30;
        }

        if (selfInflicted != 0) {
            System.out.printf("%s si esplode in faccia la lightning bolt e subisce %d di danno%n", owner.getName(), selfInflicted);
        } else {
            System.out.printf("Il lightning bolt di %s infligge %d a %s%n", owner.getName(), damage, c.getName());
        }

        return damage;



    }
}
