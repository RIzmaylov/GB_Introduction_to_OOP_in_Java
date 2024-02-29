package Seminar_05.CharacterPackage;

import java.util.ArrayList;

public abstract class BaseArcher extends BaseCharacter{
    private int arrows;

    protected BaseArcher(String name, String weapon, int x, int y, Team teamSide) {
        super(name, weapon, 7, 5, x, y, 3, teamSide);
        this.arrows = 100;    
    }

    @Override
    public void Attack(BaseCharacter target) {
        if (arrows > 0) {
            super.Attack(target);
            arrows--;
        }
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
    public void step(ArrayList<BaseCharacter> AllUnits) {
        if (isAlive) {
            Attack(nearestEnemy(AllUnits));
        }
    }
    
}
