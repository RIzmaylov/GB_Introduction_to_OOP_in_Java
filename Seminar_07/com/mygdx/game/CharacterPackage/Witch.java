package com.mygdx.game.CharacterPackage;

public class Witch extends BaseWizard{

    public Witch(String name, int x, int y, Team teamSide) {
        super(name, "staff", x, y, teamSide);
        this.lastAct = "крафтит зелья";
    }
        
    @Override
    public String getInfo() {
        return "Волшебник";
    }

}

