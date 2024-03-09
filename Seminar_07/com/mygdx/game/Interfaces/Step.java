package com.mygdx.game.Interfaces;

import java.util.ArrayList;

import com.mygdx.game.CharacterPackage.BaseCharacter;

public interface Step {
    void step(ArrayList<BaseCharacter> AllUnits);
}
