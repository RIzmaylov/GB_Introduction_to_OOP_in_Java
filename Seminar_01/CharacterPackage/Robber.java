package Seminar_01.CharacterPackage;

public class Robber extends BaseInfantryman{

    public Robber(String name) {
        super(name, "knive");
    }

    @Override
    public String toString() {
        return "Класс: Разбойник\n" +
                "Имя: " + this.name;
    }
    
}
