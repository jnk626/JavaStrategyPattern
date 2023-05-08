package org.generation.italy.strategy;

import java.util.Random;

public class MirrorOfDefenseStrategy implements DefenseStrategy {
    private Mage owner;
    private Random random = new Random();

    public MirrorOfDefenseStrategy(Mage owner) {
        this.owner = owner;
    }

    @Override
    public int defend(int damage, Character attacker) {
        // 3/10 -> assorbe tutto e riflette il doppio del danno all'avversario
        int r = random.nextInt(10) + 1;
        int absorbed = 0;
        int inflicted = 0;
        if (r <= 3) {
            absorbed = damage;
            inflicted = damage * 2;
            attacker.suffer(inflicted);
            System.out.printf("%s non riceve danno mentre %s ne riceve il doppio%n", owner.getName(), attacker.getName());
        } else {
            System.out.printf("Il mirror of defense di %s non è molto efficace...%n", owner.getName());
        }

        return damage;
    }
}
