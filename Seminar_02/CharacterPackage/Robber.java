package Seminar_02.CharacterPackage;

public class Robber extends BaseInfantryman{

    public Robber(String name, int x, int y) {
        super(name, "knive", x, y);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Разбойник\n" +
                "Имя: " + this.name;
    }
    
}
