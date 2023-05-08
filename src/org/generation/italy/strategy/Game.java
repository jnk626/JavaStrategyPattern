package org.generation.italy.strategy;

public class Game {
    public static void main(String[] args) {
        Barbarian conan = new Barbarian(500, "Conan");
        Mage merlin = new Mage(180, "Merlin");

        while (conan.isAlive() && merlin.isAlive()) {
            int damage = merlin.attack(conan);
            int avoided = conan.defend(damage, merlin);
            int finalDamage = damage - avoided;
            if (finalDamage > 0) conan.suffer(finalDamage);

            if (!conan.isAlive()) return;

            damage = conan.attack(merlin);
            avoided = merlin.defend(damage, conan);
            finalDamage = damage - avoided;
            if (finalDamage > 0) merlin.suffer(finalDamage);

            if (!merlin.isAlive()) return;

            if (merlin.isBadlyHurt() && !merlin.hasSwitched()) {
                System.out.printf("%s se la fa' sotto e cambia strategia %n", merlin.getName());
                merlin.setOffensiveStrategy(new WordOfDeathStrategy(merlin));
                merlin.setDefensiveStrategy(new MirrorOfDefenseStrategy(merlin));
                merlin.setSwitched();
            }
            if (conan.isBadlyHurt() && !conan.hasSwitched()) {
                System.out.printf("%s se la fa' sotto e cambia strategia%n", conan.getName());
                conan.setOffensiveStrategy(new SmallSwordStrategy(conan));
                conan.setSwitched();
            }
        }
    }
}
