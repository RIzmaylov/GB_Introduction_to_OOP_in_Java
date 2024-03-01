package Seminar_05.CharacterPackage;

public class Robber extends BaseInfantryman{

    public Robber(String name, int x, int y, Team teamSide) {
        super(name, "knive", x, y, teamSide);
    }

    @Override
    public String toString() {
        return "Разбойник " + this.name;
    }
        
    @Override
    public String getInfo() {
        return "Разбойник";
    }
    
}
