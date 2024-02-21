package Seminar_03.Comparators;

import java.util.Comparator;

import Seminar_03.CharacterPackage.BaseCharacter;

public class InitiativeComparator implements Comparator<BaseCharacter> {

    @Override
    public int compare(BaseCharacter o1, BaseCharacter o2) {
        // return Integer.compare(o1.GetInitiative(), o2.GetInitiative());
        int first = o1.GetInitiative(), second = o2.GetInitiative();

        if (first < second) return 1;
        else if (first > second) return -1;
        else return 0; 
    }
    
}
