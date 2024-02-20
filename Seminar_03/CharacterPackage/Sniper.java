package Seminar_03.CharacterPackage;

public class Sniper extends BaseArcher{
    public Sniper(String name, int x, int y) {
        super(name, "rifle", x, y);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Снайпер\n" +
                "Имя: " + this.name;
    }
}
