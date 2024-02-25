package Seminar_04.CharacterPackage;

public class Crossbowman extends BaseArcher{
    public Crossbowman(String name, int x, int y, Team teamSide) {
        super(name, "crossbow", x, y, teamSide);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Арбалетчик " +
                "Имя: " + this.name;
    }
}
