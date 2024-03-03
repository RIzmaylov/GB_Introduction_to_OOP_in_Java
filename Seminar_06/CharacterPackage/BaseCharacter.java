package Seminar_06.CharacterPackage;

import java.util.ArrayList;
import java.util.Random;

import Seminar_06.Field.Position;
import Seminar_06.Interfaces.Step;

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
    protected String lastAct = "стоит";

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

    public int getHp() {
        return health;
    }

    public void healed(int Hp) {
        if (this.health + Hp >= this.maxHealth) {
            System.out.println(this.getInfo() + " " + this.name + " вылечился на " + (this.maxHealth - this.health) + " HP");
            this.health = this.maxHealth;
        } else {
            System.out.println(this.getInfo() + " " + this.name + " вылечился на " + Hp + " HP");
            this.health += Hp;
        }
    }

    public void Attack(BaseCharacter target) {
        System.out.print(this.getInfo() + " " + this.name + " aтаковал " + 
            target.getInfo() + " " + target.name + " уроном " + this.damage + " ");
        target.GetDamage(this.damage);
    }

    // @Override
    // public String toString() {
    //     return "Coordinates: x = " + position.getX() + ", y = " + position.getY() + " ";
    // }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isFullHP() {
        return health == maxHealth;
    }

    public void dying() {
        health = 0;
        isAlive = false;
    }

    public void revival(int health) {
        this.health = health;
        isAlive = true;
    }

    public abstract String getInfo();

    public void GetDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
            System.out.println("Осталось жизней - " + this.health);
        } else {
            System.out.println(this.name + " умер :(");
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
    
    protected BaseCharacter nearestEnemy(ArrayList<BaseCharacter> AllUnits) {
        ArrayList<BaseCharacter> enemies = new ArrayList<>();
        for (BaseCharacter baseCharacter : AllUnits) {
            if (baseCharacter.GetTeamSide() != GetTeamSide() && baseCharacter.isAlive) {
                enemies.add(baseCharacter);
            }
        }
        if (enemies.isEmpty()) return null;
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

    protected BaseCharacter getFriendWithMinHealth(ArrayList<BaseCharacter> AllUnits) {
        int minHP = 0;
        int indexOfFriend = 0;
        boolean flag = true;
        for (int i = 1; i < AllUnits.size(); i++) {
            if (AllUnits.get(i).GetTeamSide() == GetTeamSide()) {
                if (flag) {
                    minHP = AllUnits.get(i).getHp();
                    flag = false;
                    indexOfFriend = i;
                } else if (AllUnits.get(i).getHp() < minHP) {
                    minHP = AllUnits.get(i).getHp();
                    indexOfFriend = i;
                }
            }
        }
        return AllUnits.get(indexOfFriend);
    }

    private ArrayList<Integer> getListIndexesOfDeceasedFriends(ArrayList<BaseCharacter> AllUnits) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < AllUnits.size(); ++i) {
            if (AllUnits.get(i).GetTeamSide() == GetTeamSide() && !AllUnits.get(i).isAlive()) {
                result.add(i);
            }
        }
        return result;
    }

    protected int getCountDyingFriends(ArrayList<BaseCharacter> AllUnits) {
        return getListIndexesOfDeceasedFriends(AllUnits).size();
    }

    protected BaseCharacter getRandomDeceasedFriend(ArrayList<BaseCharacter> AllUnits) {
        Random rand = new Random();
        return AllUnits.get(rand.nextInt(getListIndexesOfDeceasedFriends(AllUnits).size()));
    }
}
