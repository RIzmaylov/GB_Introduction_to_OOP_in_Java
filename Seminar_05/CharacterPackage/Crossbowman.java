package Seminar_05.CharacterPackage;

public class Crossbowman extends BaseArcher{
    public Crossbowman(String name, int x, int y, Team teamSide) {
        super(name, "crossbow", x, y, teamSide);
        this.lastAct = "ищет жертву";
    }

    @Override
    public String toString() {
        return "Арбалетчик " + this.name + (isAlive() ? " HP:" + this.health + " DMG:" + this.damage + " " + lastAct : " умер");
    }

    @Override
    public String getInfo() {
        return "Арбалетчик";
    }
}
