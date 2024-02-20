package Seminar_03.CharacterPackage;

public abstract class BaseInfantryman extends BaseCharacter{
    private int strength;
    private int endurance;

    protected BaseInfantryman(String name, String weapon, int x, int y) {
        super(name, weapon, 10, 10, x, y);
        this.strength = 10;
        this.endurance = 10;
    }
    
    @Override
    public void Attack(BaseCharacter target) {
        target.GetDamage(damage * strength * endurance);
    }
    
    @Override
    public void GetXp(int xp) {
        if (this.current_xp + xp >= this.xpInLevel) {
            this.level++;
            this.current_xp += xp - xpInLevel;
            boostStrength(10);
            boostEndurance(10);
        } else {
            this.current_xp += xp;
        }
    }
    
    private void boostStrength(int points) {
        this.strength += points;
    }

    private void boostEndurance(int points) {
        this.endurance += points;
    }

    @Override
    public void step() {
        // TODO Auto-generated method stub
        
    }
}
