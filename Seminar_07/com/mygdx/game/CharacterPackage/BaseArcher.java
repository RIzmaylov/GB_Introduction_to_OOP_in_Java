package com.mygdx.game.CharacterPackage;

import java.util.ArrayList;

public abstract class BaseArcher extends BaseCharacter{
    private int arrows;
    private int dmgForLevelUp = 2;
    private int defForLevelUp = 2;

    protected BaseArcher(String name, String weapon, int x, int y, Team teamSide) {
        super(name, weapon, 5, 2, x, y, 3, teamSide);
        this.arrows = 10;
    }

    public int getCntArrows() {
        return arrows;
    } 

    public void takeArrows(int arrows) {
        this.arrows += arrows;
    }

    @Override
    public void Attack(BaseCharacter target) {
        if (arrows > 0) {
            super.Attack(target);
            arrows--;
            lastAct = "атакует!";
        } else {
            lastAct = "ждет... Нужны стрелы!";
        }
    }
    
    @Override
    public void GetXp(int xp) {
        if (this.current_xp + xp >= this.xpInLevel) {
            this.level++;
            this.current_xp += xp - xpInLevel;
            this.damage += dmgForLevelUp;
            this.defense += defForLevelUp;
            System.out.println(this.getInfo() + " " + this.name + " повысил уровень!");
        } else {
            this.current_xp += xp;
        }
    }


    @Override
    public void step(ArrayList<BaseCharacter> AllUnits) {
        if (isAlive) {
            BaseCharacter enemy = nearestEnemy(AllUnits);
            if (enemy == null) return;
            Attack(enemy);
        }
    }
    
    @Override
    public String toString() {
        return getInfo() + super.toString() + (isAlive() ? " \u27B6 :" + this.getCntArrows() + " " + lastAct : " умер \u2639");
    }
    
}
