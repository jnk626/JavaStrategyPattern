package org.generation.italy.strategy;

public class MagicBarrierStrategy implements DefenseStrategy{
    private Mage owner;

    @Override
    public int defend(int damage, Character attacker) {
        System.out.printf("%s ha deviato il 30% dell'attacco%n", owner.getName());
        return (int) (damage / 100.0) * 30;
    }
}
