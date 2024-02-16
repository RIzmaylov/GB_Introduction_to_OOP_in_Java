package Seminar_02.CharacterPackage;

public class Peasant extends BaseInfantryman{
    public Peasant(String name, int x, int y) {
        super(name, "pitchfork", x, y);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Крестьянин\n" +
                "Имя: " + this.name;
    }
}
