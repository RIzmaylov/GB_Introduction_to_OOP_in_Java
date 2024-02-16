package Seminar_02.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Seminar_02.CharacterPackage.*;

public class Engine {
    private int maxNumOfCharacters = 7;
    private ArrayList<String> names = new ArrayList<>(Arrays.asList(
        "Вася", "Петя", "Сережа", "Валя", "Саша", "Никита", "Вова", "Надя", "Женя", "Витя", "Андрей", "Тоня",
         "Леша", "Дима", "Жора", "Иннокентий", "Петрович", "Сан Саныч", "Шарик"));
    private Random random = new Random();

    public ArrayList<BaseCharacter> createTeam(String side, int cnt) {
        ArrayList<BaseCharacter> team = new ArrayList<>();
        int posY = 0;
        if (side == "Right") {
            posY = 9;
        }
        for (int i = 0; i < cnt; i++) {
            team.add(createCharacter(random.nextInt(maxNumOfCharacters), i, posY));
        }
        return team;
    }

    private BaseCharacter createCharacter(int i, int x, int y) {
        switch (i) {
            case 0:
                return new Crossbowman(names.get(random.nextInt(names.size())), x, y);
            case 1:
                return new Monk(names.get(random.nextInt(names.size())), x, y);
            case 2:
                return new Peasant(names.get(random.nextInt(names.size())), x, y);
            case 3:
                return new Robber(names.get(random.nextInt(names.size())), x, y);
            case 4:
                return new Sniper(names.get(random.nextInt(names.size())), x, y);
            case 5:
                return new Spearman(names.get(random.nextInt(names.size())), x, y);
            default:
                return new Witch(names.get(random.nextInt(names.size())), x, y);
        }
    }
}
