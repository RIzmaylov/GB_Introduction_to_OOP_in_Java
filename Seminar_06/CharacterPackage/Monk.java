package Seminar_06.CharacterPackage;

public class Monk extends BaseWizard{
    public Monk(String name, int x, int y, Team teamSide) {
        super(name, "staff", x, y, teamSide);
        this.lastAct = "молится";
    }

    @Override
    public String toString() {
        return "Монах " + this.name + (isAlive() ? " HP:" + this.health + " Def:" + this.defense + " Mana:" + this.getMana() + " Lvl:" + this.level + " " + lastAct : " умер");
    }
    
    @Override
    public String getInfo() {
        return "Монах";
    }
}
