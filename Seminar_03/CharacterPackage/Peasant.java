package Seminar_03.CharacterPackage;

import java.util.ArrayList;

public class Peasant extends BaseCharacter{
    private int strength;

    public Peasant(String name, int x, int y, Team teamSide) {
        super(name, "pitchfork", 10, 10, x, y, 0, teamSide);
        this.strength = 10;
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
        return super.toString() +
                "Класс: Крестьянин " +
                "Имя: " + this.name;
    }

    @Override
    public void step(ArrayList<BaseCharacter> enemies) {
        System.out.println(toString() + " ничего не делает");
    }
}
