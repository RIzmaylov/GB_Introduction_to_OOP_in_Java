package com.mygdx.game.CharacterPackage;

public class Spearman extends BaseInfantryman {
    public Spearman(String name, int x, int y, Team teamSide) {
        super(name, "spear", x, y, teamSide);
        this.lastAct = "точит копье";
    }
        
    @Override
    public String getInfo() {
        return "Копейщик";
    }
}
