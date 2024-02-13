package Seminar_01;

public class Peasant extends BaseCharacter{
    private int strength;
    private int agility;

    public Peasant(String name, int health, String weapon, int damage, int defense, int strength, int agility) {
        super(name, health, weapon, damage, defense);
        this.strength = strength;
        this.agility = agility;
    }

    @Override
    public void Attack(BaseCharacter target) {
        target.GetDamage(damage * strength * agility);
    }

    public void boostStrength(int points) {
        this.strength *= points;
    }

    public void boostAgility(int points) {
        this.agility *= points;
    }
    
    
}
