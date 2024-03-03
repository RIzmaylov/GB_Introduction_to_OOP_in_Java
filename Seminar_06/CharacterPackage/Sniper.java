package Seminar_06.CharacterPackage;

public class Sniper extends BaseArcher{
    public Sniper(String name, int x, int y, Team teamSide) {
        super(name, "rifle", x, y, teamSide);
        this.lastAct = "настраивает прицел";
    }
    
    @Override
    public String getInfo() {
        return "Снайпер ";
    }
}
