package Seminar_01;

abstract class BaseCharacter {
    protected String name;
    protected int health;
    protected String weapon;
    protected int level;
    protected int damage;
    protected int defense;

    public BaseCharacter(String name, int health, String weapon, int damage, int defense) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.level = 1;
        this.damage = damage;
        this.defense = defense;
    }

    public void print() {
        System.out.println("Name: " + this.name + "\n" +
                "Health: " + this.health + "\n" +
                "Weapon: " + this.weapon + "\n" +
                "Level: " + this.level + "\n" +
                "Damage: " + this.damage + "\n" +
                "Defense: " + this.defense + "\n");
    }

    public void GetDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        }
    }

    public void healed(int Hp) {
        this.health += Hp;
    }

    public void Attack(BaseCharacter target) {
        target.GetDamage(damage);
    }

    
}
