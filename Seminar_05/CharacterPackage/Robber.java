package Seminar_05.CharacterPackage;

public class Robber extends BaseInfantryman{

    public Robber(String name, int x, int y, Team teamSide) {
        super(name, "knive", x, y, teamSide);
        this.lastAct = "точит ножи";
    }

    @Override
    public String toString() {
        return "Разбойник " + this.name + (isAlive() ? " HP:" + this.health + " DMG:" + this.damage + " " + lastAct : " умер");
    }
        
    @Override
    public String getInfo() {
        return "Разбойник";
    }
    
}
