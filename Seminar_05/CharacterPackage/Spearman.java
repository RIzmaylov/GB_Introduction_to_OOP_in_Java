package Seminar_05.CharacterPackage;

public class Spearman extends BaseInfantryman {
    public Spearman(String name, int x, int y, Team teamSide) {
        super(name, "spear", x, y, teamSide);
        this.lastAct = "точит копье";
    }

    @Override
    public String toString() {
        return "Копейщик " + this.name + (isAlive() ? " HP:" + this.health + " DMG:" + this.damage + " " + lastAct : " умер");
    }
        
    @Override
    public String getInfo() {
        return "Копейщик";
    }
}
