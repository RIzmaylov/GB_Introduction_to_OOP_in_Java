package Seminar_01.CharacterPackage;

public class Witch extends BaseWizard{

    public Witch(String name) {
        super(name, "staff");
    }

    @Override
    public String toString() {
        return "Класс: Колдун\n" +
                "Имя: " + this.name;
    }

}

