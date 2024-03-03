package Seminar_06.CharacterPackage;

public class Robber extends BaseInfantryman{

    public Robber(String name, int x, int y, Team teamSide) {
        super(name, "knive", x, y, teamSide);
        this.lastAct = "точит ножи";
    }

    @Override
    public String toString() {
        return "Разбойник " + this.name + (isAlive() ? " HP:" + this.health + " Def:" + this.defense + " DMG:" + this.damage + " Lvl:" + this.level + " " + lastAct : " умер");
    }
        
    @Override
    public String getInfo() {
        return "Разбойник";
    }
    
}
