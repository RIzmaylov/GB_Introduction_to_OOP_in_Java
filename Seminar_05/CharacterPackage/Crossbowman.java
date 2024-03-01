package Seminar_05.CharacterPackage;

public class Crossbowman extends BaseArcher{
    public Crossbowman(String name, int x, int y, Team teamSide) {
        super(name, "crossbow", x, y, teamSide);
    }

    @Override
    public String toString() {
        return "Арбалетчик " + this.name;
    }

    @Override
    public String getInfo() {
        return "Арбалетчик";
    }
}
