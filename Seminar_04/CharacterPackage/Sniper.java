package Seminar_04.CharacterPackage;

public class Sniper extends BaseArcher{
    public Sniper(String name, int x, int y, Team teamSide) {
        super(name, "rifle", x, y, teamSide);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Снайпер " +
                "Имя: " + this.name;
    }
}
