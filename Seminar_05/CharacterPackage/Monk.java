package Seminar_05.CharacterPackage;

public class Monk extends BaseWizard{
    public Monk(String name, int x, int y, Team teamSide) {
        super(name, "staff", x, y, teamSide);
        this.lastAct = "молится";
    }

    @Override
    public String toString() {
        return "Монах " + this.name + (isAlive() ? " HP:" + this.health + " DMG:" + this.damage + " " + lastAct : " умер");
    }
    
    @Override
    public String getInfo() {
        return "Монах";
    }
}
