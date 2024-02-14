package Seminar_01.CharacterPackage;

public class BaseWizard extends BaseCharacter{
    private int mana;
    private int maxMana = 100;
    private int intelligence;

    protected BaseWizard(String name, String weapon) {
        super(name, weapon, 75, 5);
        this.mana = 100;
        this.intelligence = 10;
    }

    @Override
    public void Attack(BaseCharacter target) {
        target.GetDamage(damage * intelligence);
    }
    
    @Override
    public void GetXp(int xp) {
        if (this.current_xp + xp >= this.xpInLevel) {
            this.level++;
            this.current_xp += xp - xpInLevel;
            boostIntelligence(10);
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

    private void boostIntelligence(int points) {
        this.intelligence += points;
    }
}
