package Seminar_05.CharacterPackage;

public class Monk extends BaseWizard{
    public Monk(String name, int x, int y, Team teamSide) {
        super(name, "staff", x, y, teamSide);
    }

    @Override
    public String toString() {
        return "Монах " + this.name;
    }
    
    @Override
    public String getInfo() {
        return "Монах";
    }
}
