package Seminar_01.CharacterPackage;

public class Peasant extends BaseInfantryman{
    public Peasant(String name) {
        super(name, "pitchfork");
    }

    @Override
    public String toString() {
        return "Класс: Крестьянин\n" +
                "Имя: " + this.name;
    }
}
