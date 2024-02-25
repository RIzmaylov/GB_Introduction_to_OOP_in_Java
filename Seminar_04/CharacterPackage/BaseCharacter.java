package Seminar_04.CharacterPackage;

import java.util.ArrayList;

import Seminar_04.Field.Position;
import Seminar_04.Interfaces.Step;

public abstract class BaseCharacter implements Step {
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
    protected Team teamSide;

    protected Position position;

    static public enum Team {
        LEFT, RIGHT
    }

    protected BaseCharacter(String name, String weapon, int damage, int defense, int x, int y, int initiative, Team teamSide) {
        this.name = name;
        this.health = 100;
        this.weapon = weapon;
        this.level = 1;
        this.damage = damage;
        this.defense = defense;
        this.current_xp = 0;
        this.initiative = initiative;
        position = new Position(x, y);
        this.teamSide = teamSide;
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

    public String getName() {
        return name;
    }

    public void healed(int Hp) {
        if (this.health + Hp >= this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            this.health += Hp;
        }
    }

    public void Attack(BaseCharacter target) {
        System.out.println(this.toString() + "\nАтаковал\n" + target + "\nУроном " + this.damage);
        target.GetDamage(this.damage);
    }

    @Override
    public String toString() {
        return "Coordinates: x = " + position.getX() + ", y = " + position.getY() + "\n";
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void dying() {
        health = 0;
        isAlive = false;
    }

    public void revival(int health) {
        this.health = health;
        isAlive = true;
    }

    public void GetDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
            System.out.println("Осталось жизней - " + this.health + "\n");
        } else {
            System.out.println("Умер :(\n");
            dying();
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

    public Position GetPosition() {
        return position;
    }

    public int GetInitiative() {
        return initiative;
    }

    public String GetTeamSide() {
        if (teamSide == Team.LEFT) return "left";
        else return "right";
    }

    protected void SetPosition(int x, int y) {
        position.setPosition(x, y);
    }
    
    public BaseCharacter nearestEnemy(ArrayList<BaseCharacter> AllUnits) {
        ArrayList<BaseCharacter> enemies = new ArrayList<>();
        for (BaseCharacter baseCharacter : AllUnits) {
            if (baseCharacter.GetTeamSide() != GetTeamSide() && baseCharacter.isAlive) {
                enemies.add(baseCharacter);
            }
        }
        
        int indexOfEnemy = 0;
        double minDistToEnemy = GetPosition().CalcDistToAnotherPos(enemies.get(indexOfEnemy).GetPosition());
        for (int i = 1; i < enemies.size(); i++) {
            double nextDistToEnemy = GetPosition().CalcDistToAnotherPos(enemies.get(i).GetPosition());
            if (nextDistToEnemy < minDistToEnemy) {  
                minDistToEnemy = nextDistToEnemy;
                indexOfEnemy = i;
            }
        }
        return enemies.get(indexOfEnemy);
    }
}
