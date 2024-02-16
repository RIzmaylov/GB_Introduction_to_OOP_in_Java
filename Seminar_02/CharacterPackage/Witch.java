package Seminar_02.CharacterPackage;

public class Witch extends BaseWizard{

    public Witch(String name, int x, int y) {
        super(name, "staff", x, y);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Колдун\n" +
                "Имя: " + this.name;
    }

}

