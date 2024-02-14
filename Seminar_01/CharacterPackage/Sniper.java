package Seminar_01.CharacterPackage;

public class Sniper extends BaseArcher{
    public Sniper(String name) {
        super(name, "rifle");
    }

    @Override
    public String toString() {
        return "Класс: Снайпер\n" +
                "Имя: " + this.name;
    }
}
