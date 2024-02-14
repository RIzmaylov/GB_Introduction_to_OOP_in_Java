package Seminar_01.CharacterPackage;

public class Spearman extends BaseInfantryman {
    public Spearman(String name) {
        super(name, "spear");
    }

    @Override
    public String toString() {
        return "Класс: Копейщик\n" +
                "Имя: " + this.name;
    }
}
