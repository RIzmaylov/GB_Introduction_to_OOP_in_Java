package Seminar_05.CharacterPackage;

import java.util.ArrayList;

public class Peasant extends BaseCharacter{
    private int strength;
    private int arrowsForStep = 1;

    public Peasant(String name, int x, int y, Team teamSide) {
        super(name, "pitchfork", 10, 10, x, y, 0, teamSide);
        this.strength = 10;
        this.lastAct = "пашет землю";
    }

    public void bringArrows(BaseArcher friendArcher) {
        friendArcher.takeArrows(arrowsForStep);
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
        } else {
            this.current_xp += xp;
        }
    }

    @Override
    public String toString() {
        return "Крестьянин " + this.name + (isAlive() ? " HP:" + this.health + " DMG:" + this.damage + " " + lastAct : " умер");
    }

    private ArrayList<BaseCharacter> getFriendArchers(ArrayList<BaseCharacter> AllUnits) {
        ArrayList<BaseCharacter> result = new ArrayList<>();
        for (BaseCharacter bc : AllUnits) {
            if (bc instanceof BaseArcher) result.add(bc);
        }
        return result;
    }

    @Override
    public void step(ArrayList<BaseCharacter> AllUnits) {
        for (BaseCharacter baseCharacter : AllUnits) {
            if (baseCharacter instanceof BaseArcher) {

            }
        }
        System.out.println(getInfo() + " " + name + " пашет землю");
    }
        
    @Override
    public String getInfo() {
        return "Крестьянин";
    }
}
