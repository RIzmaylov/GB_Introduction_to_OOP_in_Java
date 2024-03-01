package Seminar_05.CharacterPackage;

public class Sniper extends BaseArcher{
    public Sniper(String name, int x, int y, Team teamSide) {
        super(name, "rifle", x, y, teamSide);
    }

    @Override
    public String toString() {
        return "Снайпер " + this.name;
    }
    
    @Override
    public String getInfo() {
        return "Снайпер";
    }
}
