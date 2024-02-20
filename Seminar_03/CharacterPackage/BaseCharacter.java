package Seminar_03.CharacterPackage;

import Seminar_03.Field.Position;
import Seminar_03.Interfaces.Step;

public abstract class BaseCharacter implements Step{
    protected String name;
    protected int health;
    protected int maxHealth = 100;
    protected String weapon;
    protected int level;
    protected int current_xp;
    protected int xpInLevel = 100;
    protected int maxLevel = 80;
    protected int damage;
    protected int defense;
    protected boolean isAlive = true;
    protected int initiative;

    protected Position position;

    protected BaseCharacter(String name, String weapon, int damage, int defense, int x, int y, int initiative) {
        this.name = name;
        this.health = 100;
        this.weapon = weapon;
        this.level = 1;
        this.damage = damage;
        this.defense = defense;
        this.current_xp = 0;
        this.initiative = initiative;
        position = new Position(x, y);
    }

    public void print() {
        System.out.println("Name: " + this.name + "\n" +
                "Health: " + this.health + "\n" +
                "Weapon: " + this.weapon + "\n" +
                "Level: " + this.level + "\n" +
                "Damage: " + this.damage + "\n" +
                "Defense: " + this.defense + "\n" +
                "XP: " + this.current_xp + "\n");
    }

    public void GetDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        }
    }

    public void GetXp(int xp) {
        if (this.current_xp + xp >= this.xpInLevel) {
            this.level++;
            this.current_xp += xp - xpInLevel;
        } else {
            this.current_xp += xp;
        }
    }

    public void healed(int Hp) {
        if (this.health + Hp >= this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            this.health += Hp;
        }
    }

    public void Attack(BaseCharacter target) {
        target.GetDamage(this.damage);
    }

    public Position GetPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Coordinates: x = " + position.getX() + ", y = " + position.getY() + "\n";
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void dying() {
        isAlive = false;
    }

    public void revival() {
        isAlive = true;
    }
}
