package Seminar_05.CharacterPackage;

public class Sniper extends BaseArcher{
    public Sniper(String name, int x, int y, Team teamSide) {
        super(name, "rifle", x, y, teamSide);
        this.lastAct = "настраивает прицел";
    }

    @Override
    public String toString() {
        return "Снайпер " + this.name + (isAlive() ? " HP:" + this.health + " DMG:" + this.damage + " " + lastAct : " умер");
    }
    
    @Override
    public String getInfo() {
        return "Снайпер";
    }
}
