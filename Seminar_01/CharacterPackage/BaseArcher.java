package Seminar_01.CharacterPackage;

public abstract class BaseArcher extends BaseCharacter{
    private int accuracy;
    private int fireRange;
    private int fireRate;

    protected BaseArcher(String name, String weapon) {
        super(name, weapon, 75, 5);
        this.accuracy = 10;
        this.fireRange = 10;
        this.fireRate = 10;        
    }

    @Override
    public void Attack(BaseCharacter target) {
        target.GetDamage(damage * accuracy * fireRange + fireRate);
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

    private void boostAccuracy(int points) {
        this.accuracy += points;
    }

    private void boostFireRange(int points) {
        this.fireRange += points;
    }

    private void boostfireRate(int points) {
        this.fireRate += points;
    }
    
}
