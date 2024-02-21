package Seminar_03.CharacterPackage;

public class Witch extends BaseWizard{

    public Witch(String name, int x, int y, Team teamSide) {
        super(name, "staff", x, y, teamSide);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Колдун " +
                "Имя: " + this.name;
    }

}

