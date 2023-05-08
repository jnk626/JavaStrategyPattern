package org.generation.italy.strategy;

import java.util.Random;

public class NoShieldStrategy implements DefenseStrategy{
    private Barbarian owner;
    private Random random = new Random();

    public NoShieldStrategy(Barbarian owner) {
        this.owner = owner;
    }

    @Override
    public int defend(int damage, Character attacker) {
        int r = random.nextInt(10) + 1;
        int damagePrevented = 0;
        if (r <= 6) {
            damagePrevented = damage;
        }

        if (damagePrevented == 0) {
            System.out.printf("%s non riesce a schivare l'attacco e subisce tutti i danni%n", owner.getName());
        } else {
            System.out.printf("%s schiva completamente l'attacco%n", owner.getName());
        }

        return damagePrevented;
    }
}
