package Seminar_06.CharacterPackage;

import java.util.ArrayList;

import Seminar_06.Field.Position;

public abstract class BaseInfantryman extends BaseCharacter{
    private int strength;
    private int endurance;
    
    private int expForAttack = 20;
    private int expForMove = 10;
    private int strengthForLevel = 1;
    private int enduranceForLevel = 1;
    private int defForLevelUp = 1;

    protected BaseInfantryman(String name, String weapon, int x, int y, Team teamSide) {
        super(name, weapon, 4, 5, x, y, 2, teamSide);
        this.strength = 1;
        this.endurance = 1;
        this.damage += strength + endurance;
    }
    
    @Override
    public void Attack(BaseCharacter target) {
        super.Attack(target);
    }
    
    @Override
    public String toString() {
        return getInfo() + super.toString() + (isAlive() ? " \u2620 :" + this.damage + " " + lastAct : " умер \u2639");
    }
    
    @Override
    public void GetXp(int xp) {
        if (this.current_xp + xp >= this.xpInLevel) {
            this.level++;
            this.current_xp += xp - xpInLevel;
            boostStrength(strengthForLevel);
            boostEndurance(enduranceForLevel);
            this.damage += strengthForLevel + enduranceForLevel;
            this.defense += defForLevelUp;
            System.out.println(this.getInfo() + " " + this.name + " повысил уровень!");
        } else {
            this.current_xp += xp;
        }
    }
    
    private void boostStrength(int points) {
        this.strength += points;
    }

    private void boostEndurance(int points) {
        this.endurance += points;
    }

    @Override
    public void step(ArrayList<BaseCharacter> AllUnits) {
        if (isAlive) {
            BaseCharacter target = nearestEnemy(AllUnits);
            if (target == null) return;
            if (position.CalcDistToAnotherPos(target.position) < 2) {
                Attack(target);
                GetXp(expForAttack);
                lastAct = "атакует!";
                return;
            }

            // Нахождение всех занятых сокомандниками позиций вокруг текущего юнита
            ArrayList<Position> friendsPosAround = new ArrayList<>();
            for (BaseCharacter baseCharacter : AllUnits) {
                if (baseCharacter.teamSide == teamSide && position.isAround(baseCharacter.GetPosition())) friendsPosAround.add(baseCharacter.GetPosition());
            }
            
            Position difPosition = position.GetDifToEnotherPos(target.GetPosition());

            if (Math.abs(difPosition.getX()) > Math.abs(difPosition.getY())) {
                if (difPosition.getX() < 0) {
                    ArrayList<Position> posToMove = new ArrayList<>();  // массив для трех возможных ходов юнита
                    posToMove.add(new Position(position.getX() + 1, position.getY()));
                    posToMove.add(new Position(position.getX() + 1, position.getY() + 1 <= 9 ? position.getY() + 1 : 9));
                    posToMove.add(new Position(position.getX() + 1, position.getY() - 1 >= 0 ? position.getY() - 1 : 0));
                    for (Position pos : posToMove) {
                        if (!friendsPosAround.contains(pos)) { position.setX(pos.getX()); position.setY(pos.getY()); break; }
                    }
                } else {
                    ArrayList<Position> posToMove = new ArrayList<>();  // массив для трех возможных ходов юнита
                    posToMove.add(new Position(position.getX() - 1, position.getY()));
                    posToMove.add(new Position(position.getX() - 1, position.getY() + 1 <= 9 ? position.getY() + 1 : 9));
                    posToMove.add(new Position(position.getX() - 1, position.getY() - 1 >= 0 ? position.getY() - 1 : 0));
                    for (Position pos : posToMove) {
                        if (!friendsPosAround.contains(pos)) { position.setX(pos.getX()); position.setY(pos.getY()); break; }
                    }
                }
            } else {
                if (difPosition.getY() < 0) {
                    ArrayList<Position> posToMove = new ArrayList<>();  // массив для трех возможных ходов юнита
                    posToMove.add(new Position(position.getX(), position.getY() + 1));
                    posToMove.add(new Position(position.getX() + 1 <= 9 ? position.getX() + 1 : 9, position.getY() + 1));
                    posToMove.add(new Position(position.getX() - 1 >= 0 ? position.getX() - 1 : 0, position.getY() + 1));
                    for (Position pos : posToMove) {
                        if (!friendsPosAround.contains(pos)) { position.setX(pos.getX()); position.setY(pos.getY()); break; }
                    }
                } else {
                    ArrayList<Position> posToMove = new ArrayList<>();  // массив для трех возможных ходов юнита
                    posToMove.add(new Position(position.getX(), position.getY() - 1));
                    posToMove.add(new Position(position.getX() + 1 <= 9 ? position.getX() + 1 : 9, position.getY() - 1));
                    posToMove.add(new Position(position.getX() - 1 >= 0 ? position.getX() - 1 : 0, position.getY() - 1));
                    for (Position pos : posToMove) {
                        if (!friendsPosAround.contains(pos)) { position.setX(pos.getX()); position.setY(pos.getY()); break; }
                    }
                }
            }
            
            GetXp(expForMove);
            lastAct = "идет к врагу!";
        }
    }
    
}
