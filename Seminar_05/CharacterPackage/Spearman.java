package Seminar_05.CharacterPackage;

public class Spearman extends BaseInfantryman {
    public Spearman(String name, int x, int y, Team teamSide) {
        super(name, "spear", x, y, teamSide);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Копейщик " +
                "Имя: " + this.name;
    }
}
