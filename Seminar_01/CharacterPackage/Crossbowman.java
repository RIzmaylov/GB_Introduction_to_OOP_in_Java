package Seminar_01.CharacterPackage;

public class Crossbowman extends BaseArcher{
    public Crossbowman(String name) {
        super(name, "crossbow");
    }

    @Override
    public String toString() {
        return "Класс: Арбалетчик\n" +
                "Имя: " + this.name;
    }
}
