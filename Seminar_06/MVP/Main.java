// Для отображения символов в терминале VS Code chcp 65001

package Seminar_06.MVP;

import java.util.ArrayList;
import java.util.Scanner;

import Seminar_06.CharacterPackage.*;
import Seminar_06.CharacterPackage.BaseCharacter.Team;
import Seminar_06.Engine.Engine;

public class Main {

    public static ArrayList<BaseCharacter> LeftTeam = new ArrayList<>();
    public static ArrayList<BaseCharacter> RightTeam = new ArrayList<>();
    public static ArrayList<BaseCharacter> AllUnits = new ArrayList<>();
    public static void main(String[] args) {
      Engine engine = new Engine();

      // Создание случайных команд: 
      LeftTeam = engine.createTeam(Team.LEFT, 10);
      RightTeam = engine.createTeam(Team.RIGHT, 10);
      
      // Создание определенных команд: 
      // LeftTeam = engine.createBalancedTeam(Team.LEFT, 10);
      // RightTeam = engine.createBalancedTeam(Team.RIGHT, 10);

      AllUnits.addAll(LeftTeam);
      AllUnits.addAll(RightTeam);
      for (BaseCharacter character : AllUnits) {
        // System.out.println("Team: " + character.GetTeamSide());
        System.out.println(character);
      }
      System.out.println("------------------------------------");
      ArrayList<BaseCharacter> sortedAllUnits = new ArrayList<>();
      sortedAllUnits.addAll(AllUnits);
      sortedAllUnits.sort((o1, o2) -> o2.GetInitiative() - o1.GetInitiative());

      Scanner scanner = new Scanner(System.in);
      while(true) {
        View.view();
        scanner.nextLine();
        for (BaseCharacter baseCharacter : sortedAllUnits) {
          baseCharacter.step(sortedAllUnits);
        }
        if (engine.TeamIsDead(LeftTeam)) {
          View.view();
          System.out.println("\u250c------------------------------\u2510");
          System.out.println("|----Команда Blue победила!----|");
          System.out.println("\u2514------------------------------\u2518");
          break;
        }
        if (engine.TeamIsDead(RightTeam)) {
          View.view();
          System.out.println("\u250c-------------------------------\u2510");
          System.out.println("|----Команда Green победила!----|");
          System.out.println("\u2514-------------------------------\u2518");
          break;
        }
        
        // for (BaseCharacter character : AllUnits) {
        //   // System.out.println("Team: " + character.GetTeamSide());
        //   System.out.println(character);
        // }
        // System.out.println("------------------------------------");
        // scanner.close();
      }
      scanner.close();
    }
    
}

/*
Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определить 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников. 
Расположить классы в пакет так, чтобы в основной программе небыло видно их полей. 
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя. 
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.
 */

 /*
  Крестьянин:
    - Имя
    - Здоровье
    - Оружие
    - Уровень
    - Урон
    - Защита

    - Сила
    - Выносливость

  Разбойник:
    - Имя
    - Здоровье
    - Оружие
    - Уровень
    - Урон
    - Защита

    - Ловкость
    - Скрытность

  Снайпер:
    - Имя
    - Здоровье
    - Оружие
    - Уровень
    - Урон
    - Защита

    - Меткость
    - Дальность стрельбы
    - Скорость стрельбы

  Колдун:
    - Имя
    - Здоровье
    - Оружие
    - Уровень
    - Урон
    - Защита

    - Мана
    - Интеллект

  Копейщик:
    - Имя
    - Здоровье
    - Оружие
    - Уровень
    - Урон
    - Защита

    - Сила
    - Выносливость

  Арбалетчик:
    - Имя
    - Здоровье
    - Оружие
    - Уровень
    - Урон
    - Защита

    - Меткость
    - Скорость стрельбы
    - Кол-во стрел

  Монах:
    - Имя
    - Здоровье
    - Оружие
    - Уровень
    - Урон
    - Защита

    - Мана
    - Интеллект
  */