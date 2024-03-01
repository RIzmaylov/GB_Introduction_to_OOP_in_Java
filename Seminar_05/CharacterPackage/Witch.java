package Seminar_05.CharacterPackage;

public class Witch extends BaseWizard{

    public Witch(String name, int x, int y, Team teamSide) {
        super(name, "staff", x, y, teamSide);
        this.lastAct = "крафтит зелья";
    }

    @Override
    public String toString() {
        return "Колдун " + this.name + (isAlive() ? " HP:" + this.health + " DMG:" + this.damage + " " + lastAct : " умер");
    }
        
    @Override
    public String getInfo() {
        return "Колдун";
    }

}

