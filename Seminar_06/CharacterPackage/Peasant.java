package Seminar_06.CharacterPackage;

import java.util.ArrayList;
import java.util.Random;

public class Peasant extends BaseCharacter{
    private int strength;
    private int arrowsForStep = 1;
    private int expForBringArrows = 10;

    public Peasant(String name, int x, int y, Team teamSide) {
        super(name, "pitchfork", 10, 10, x, y, 0, teamSide);
        this.strength = 10;
        this.lastAct = "пашет землю";
    }

    public void bringArrows(BaseCharacter friendArcher) {
        if (friendArcher instanceof BaseArcher)
            ((BaseArcher)friendArcher).takeArrows(arrowsForStep);
    }

    @Override
    public void Attack(BaseCharacter target) {
        target.GetDamage(damage * strength);
    }
    
    @Override
    public void GetXp(int xp) {
        if (this.current_xp + xp >= this.xpInLevel) {
            this.level++;
            this.current_xp += xp - xpInLevel;
            System.out.println(this.getInfo() + " " + this.name + " повысил уровень!");
        } else {
            this.current_xp += xp;
        }
    }

    @Override
    public String toString() {
        return getInfo() + super.toString() + (isAlive() ? " " + lastAct : " умер \u2639");
    }

    private ArrayList<BaseCharacter> getFriendArchers(ArrayList<BaseCharacter> AllUnits) {
        ArrayList<BaseCharacter> result = new ArrayList<>();
        for (BaseCharacter bc : AllUnits) {
            if (bc.GetTeamSide() == GetTeamSide() && bc instanceof BaseArcher && bc.isAlive()) result.add(bc);
        }
        return result;
    }

    @Override
    public void step(ArrayList<BaseCharacter> AllUnits) {
        Random rand = new Random();
        ArrayList<BaseCharacter> archers = getFriendArchers(AllUnits);
        if (archers.isEmpty()) {
            System.out.println(getInfo() + " " + name + " пашет землю");
            lastAct = "пашет землю...";
        } else {
            int indexOfArcher = rand.nextInt(archers.size());
            BaseCharacter archer = archers.get(indexOfArcher);
            bringArrows(archer);
            GetXp(expForBringArrows);
            System.out.println(getInfo() + " " + name + " подносит стрелы " + archer.getInfo() + " " + archer.getName());
            lastAct = "поднес стрелы!";
        }
    }
        
    @Override
    public String getInfo() {
        return "Крестьянин ";
    }
}
