package Seminar_03.CharacterPackage;

public class Monk extends BaseWizard{
    public Monk(String name, int x, int y) {
        super(name, "staff", x, y);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Класс: Монах\n" +
                "Имя: " + this.name;
    }
}
