package Seminar_04.CharacterPackage;

public class Robber extends BaseInfantryman{

    public Robber(String name, int x, int y, Team teamSide) {
        super(name, "knive", x, y, teamSide);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Разбойник " +
                "Имя: " + this.name;
    }
    
}
