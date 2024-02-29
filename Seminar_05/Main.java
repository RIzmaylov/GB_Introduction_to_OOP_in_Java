package Seminar_05;

import java.util.ArrayList;
import java.util.Scanner;

import Seminar_05.CharacterPackage.*;
import Seminar_05.CharacterPackage.BaseCharacter.Team;
import Seminar_05.Engine.Engine;

public class Main {
    public static void main(String[] args) {
      Engine engine = new Engine();
      ArrayList<BaseCharacter> AllUnits = engine.createTeam(Team.LEFT, 10);
      AllUnits.addAll(engine.createTeam(Team.RIGHT, 10));


      AllUnits.sort((o1, o2) -> o2.GetInitiative() - o1.GetInitiative());

      for (BaseCharacter character : AllUnits) {
        // System.out.println("Team: " + character.GetTeamSide());
        System.out.println(character);
      }
      System.out.println("------------------------------------");

      Scanner scanner = new Scanner(System.in);
      while(true) {
        scanner.nextLine();
        for (BaseCharacter baseCharacter : AllUnits) {
          baseCharacter.step(AllUnits);
        }
        System.out.println("------------------------------------");
  
        
        for (BaseCharacter character : AllUnits) {
          // System.out.println("Team: " + character.GetTeamSide());
          System.out.println(character);
        }
        System.out.println("------------------------------------");
        // scanner.close();
      }
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