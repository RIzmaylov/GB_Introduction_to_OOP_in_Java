package com.mygdx.game.Engine;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.CharacterPackage.*;
import com.mygdx.game.CharacterPackage.BaseCharacter.Team;

public class Engine {
    private int maxNumOfCharacters = 7;
    private ArrayList<String> names = new ArrayList<>(Arrays.asList(
        "Вася", "Петя", "Сережа", "Валя", "Саша", "Никита", "Вова", "Надя", "Женя", "Витя", "Андрей", "Тоня",
         "Леша", "Дима", "Жора", "Иннокентий", "Петрович", "Сан Саныч", "Шарик"));

    /**
     * Создание команды персонажей
     * @param teamSide  - выбор стороны. Left или Right
     * @param cnt   - количество персонажей в команде
     * @return  - возвращает список персонажей случайных имен и типов
     */
    public ArrayList<BaseCharacter> createTeam(Team teamSide, int cnt) {
        ArrayList<BaseCharacter> team = new ArrayList<>();
        int posY = 0;
        if (teamSide == Team.RIGHT) {
            posY = cnt - 1;
        }
        for (int i = 0; i < cnt; i++) {
            team.add(createCharacter(MathUtils.random(maxNumOfCharacters - 1), i, posY, teamSide));
        }
        return team;
    }
    
    /**
     * Создание команды с определенным набором персонажей
     * @param teamSide  - выбор стороны. Left или Right
     * @param cnt   - количество персонажей в команде
     * @return  - возвращает список персонажей случайных имен и определенных типов
     */
    public ArrayList<BaseCharacter> createBalancedTeam(Team teamSide, int cnt) {
        ArrayList<BaseCharacter> team = new ArrayList<>();
        int posY = 0;
        if (teamSide == Team.RIGHT) {
            posY = cnt - 1;
        }
        for (int i = 0; i < cnt; i++) {
            team.add(createCharacter(i % 7, i, posY, teamSide));
        }
        return team;
    }

    
    public boolean TeamIsDead(ArrayList<BaseCharacter> team) {
        for (BaseCharacter baseCharacter : team) {
            if (baseCharacter.isAlive()) return false;
        }
        return true;
    }

    /**
     * Функция создает персонажа
     * @param i - случайное число, определяющее тип персонажа
     * @param x - позиция по X
     * @param y - позиция по Y
     * @return  - возвращается персонаж
     */
    private BaseCharacter createCharacter(int i, int x, int y, Team teamSide) {
        switch (i) {
            case 0:
                return new Crossbowman(names.get(MathUtils.random(names.size() - 1)), x, y, teamSide);
            case 1:
                return new Monk(names.get(MathUtils.random(names.size() - 1)), x, y, teamSide);
            case 2:
                return new Peasant(names.get(MathUtils.random(names.size() - 1)), x, y, teamSide);
            case 3:
                return new Robber(names.get(MathUtils.random(names.size() - 1)), x, y, teamSide);
            case 4:
                return new Sniper(names.get(MathUtils.random(names.size() - 1)), x, y, teamSide);
            case 5:
                return new Spearman(names.get(MathUtils.random(names.size() - 1)), x, y, teamSide);
            default:
                return new Witch(names.get(MathUtils.random(names.size() - 1)), x, y, teamSide);
        }
    }


}
