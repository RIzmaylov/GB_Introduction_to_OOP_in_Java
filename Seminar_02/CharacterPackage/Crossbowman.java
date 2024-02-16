package Seminar_02.CharacterPackage;

public class Crossbowman extends BaseArcher{
    public Crossbowman(String name, int x, int y) {
        super(name, "crossbow", x, y);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Арбалетчик\n" +
                "Имя: " + this.name;
    }
}
