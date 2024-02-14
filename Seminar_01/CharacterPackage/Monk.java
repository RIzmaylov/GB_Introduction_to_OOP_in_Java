package Seminar_01.CharacterPackage;

public class Monk extends BaseWizard{
    public Monk(String name) {
        super(name, "staff");
    }

    @Override
    public String toString() {
        return "Класс: Монах\n" +
                "Имя: " + this.name;
    }
}
