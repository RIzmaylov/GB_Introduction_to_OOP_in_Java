package Seminar_05.CharacterPackage;

import java.util.ArrayList;

public abstract class BaseWizard extends BaseCharacter{
    private int mana;
    private int maxMana = 100;

    protected BaseWizard(String name, String weapon, int x, int y, Team teamSide) {
        super(name, weapon, 75, 5, x, y, 1, teamSide);
        this.mana = 100;
    }

    @Override
    public void Attack(BaseCharacter target) {
        if (mana > 0) {
            super.Attack(target);
            lastAct = "атакует!";
            mana-= 5;
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
    
    public void getMana(int mana) {
        if (this.mana + mana >= this.maxMana) {
            this.mana = this.maxMana;
        } else {
            this.mana += mana;
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
}
