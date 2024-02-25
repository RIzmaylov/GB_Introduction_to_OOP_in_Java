package Seminar_03.CharacterPackage;

import java.util.ArrayList;

public abstract class BaseArcher extends BaseCharacter{
    private int accuracy;
    private int fireRange;
    private int fireRate;
    private int arrows;

    protected BaseArcher(String name, String weapon, int x, int y, Team teamSide) {
        super(name, weapon, 75, 5, x, y, 3, teamSide);
        this.accuracy = 10;
        this.fireRange = 10;
        this.fireRate = 10;
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
            boostAccuracy(10);
            boostFireRange(10);
            boostfireRate(10);
        } else {
            this.current_xp += xp;
        }
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

    private void boostAccuracy(int points) {
        this.accuracy += points;
    }

    private void boostFireRange(int points) {
        this.fireRange += points;
    }

    private void boostfireRate(int points) {
        this.fireRate += points;
    }

    @Override
    public void step(ArrayList<BaseCharacter> AllUnits) {
        if (isAlive) {
            Attack(nearestEnemy(AllUnits));
        }
    }
    
}
