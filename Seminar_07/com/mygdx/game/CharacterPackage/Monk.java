package com.mygdx.game.CharacterPackage;

public class Monk extends BaseWizard{
    public Monk(String name, int x, int y, Team teamSide) {
        super(name, "staff", x, y, teamSide);
        this.lastAct = "молится";
    }

    
    @Override
    public String getInfo() {
        return "Монах";
    }
}
