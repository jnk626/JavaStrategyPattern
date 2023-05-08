package org.generation.italy.strategy;

import java.util.Random;

public class WordOfDeathStrategy implements AttackStrategy {
    private Mage owner;
    private Random random = new Random();

    public WordOfDeathStrategy(Mage owner) {
        this.owner = owner;
    }

    @Override
    public int attack(Character c) {
        //1 /50 -> uccide l'avversario
        int r = random.nextInt(50) + 1;
        int damage = 0;

        if (r == 45) {
            damage = c.getHp();
            System.out.printf("%s ha ucciso %s. Che culo!%n", owner.getName(), c.getName());
        } else {
            System.out.printf("La Word of Death di %s è completamente inutile...%n", owner.getName());
        }

        return damage;
    }

}
