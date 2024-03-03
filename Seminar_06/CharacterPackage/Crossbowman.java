package Seminar_06.CharacterPackage;

public class Crossbowman extends BaseArcher{
    public Crossbowman(String name, int x, int y, Team teamSide) {
        super(name, "crossbow", x, y, teamSide);
        this.lastAct = "ищет жертву";
    }

    @Override
    public String getInfo() {
        return "Арбалетчик ";
    }
}
