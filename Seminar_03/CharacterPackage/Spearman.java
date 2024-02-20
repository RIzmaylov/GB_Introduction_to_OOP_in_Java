package Seminar_03.CharacterPackage;

public class Spearman extends BaseInfantryman {
    public Spearman(String name, int x, int y) {
        super(name, "spear", x, y);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Копейщик\n" +
                "Имя: " + this.name;
    }
}
