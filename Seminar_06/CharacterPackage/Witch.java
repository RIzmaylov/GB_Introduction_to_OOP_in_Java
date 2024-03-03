package Seminar_06.CharacterPackage;

public class Witch extends BaseWizard{

    public Witch(String name, int x, int y, Team teamSide) {
        super(name, "staff", x, y, teamSide);
        this.lastAct = "крафтит зелья";
    }

    @Override
    public String toString() {
        return "Колдун " + this.name + (isAlive() ? " HP:" + this.health + " Def:" + this.defense + " Mana:" + this.getMana() + " Lvl:" + this.level + " " + lastAct : " умер");
    }
        
    @Override
    public String getInfo() {
        return "Колдун";
    }

}

