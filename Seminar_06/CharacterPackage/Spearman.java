package Seminar_06.CharacterPackage;

public class Spearman extends BaseInfantryman {
    public Spearman(String name, int x, int y, Team teamSide) {
        super(name, "spear", x, y, teamSide);
        this.lastAct = "точит копье";
    }

    @Override
    public String toString() {
        return "Копейщик " + this.name + (isAlive() ? " HP:" + this.health + " Def:" + this.defense + " DMG:" + this.damage + " Lvl:" + this.level + " " + lastAct : " умер");
    }
        
    @Override
    public String getInfo() {
        return "Копейщик";
    }
}
