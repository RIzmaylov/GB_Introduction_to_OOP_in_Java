package Seminar_04.CharacterPackage;

import java.util.ArrayList;

import Seminar_04.Field.Position;

public abstract class BaseInfantryman extends BaseCharacter{
    private int strength;
    private int endurance;

    protected BaseInfantryman(String name, String weapon, int x, int y, Team teamSide) {
        super(name, weapon, 1, 1, x, y, 2, teamSide);
        this.strength = 1;
        this.endurance = 1;
        this.damage += strength + endurance;
    }
    
    @Override
    public void Attack(BaseCharacter target) {
        super.Attack(target);
    }
    
    @Override
    public void GetXp(int xp) {
        if (this.current_xp + xp >= this.xpInLevel) {
            this.level++;
            this.current_xp += xp - xpInLevel;
            boostStrength(10);
            boostEndurance(10);
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
            if (position.CalcDistToAnotherPos(target.position) < 2) {
                Attack(target);
                return;
            }

            // Нахождение всех занятых сокомандниками позиций вокруг текущего юнита
            ArrayList<Position> friendsPosAround = new ArrayList<>();
            for (BaseCharacter baseCharacter : AllUnits) {
                if (baseCharacter.teamSide == teamSide && position.equals(baseCharacter.GetPosition())) friendsPosAround.add(baseCharacter.GetPosition());
            }
            
            Position difPosition = GetPosition().GetDifToEnotherPos(target.GetPosition());

            if (Math.abs(difPosition.getX()) > Math.abs(difPosition.getY())) {
                // position.setX(difPosition.getX() < 0 ? position.getX() + 1 : position.getX() - 1);
                if (difPosition.getX() < 0) {
                    ArrayList<Position> posToMove = new ArrayList<>();  // массив для трех возможных ходов юнита
                    posToMove.add(new Position(position.getX() + 1, position.getY()));
                    posToMove.add(new Position(position.getX() + 1, position.getY() + 1 <= 9 ? position.getY() + 1 : 9));
                    posToMove.add(new Position(position.getX() + 1, position.getY() - 1 >= 0 ? position.getY() - 1 : 0));
                    for (Position pos : posToMove) {
                        if (!friendsPosAround.contains(pos)) { position = pos; break; }
                    }
                } else {
                    ArrayList<Position> posToMove = new ArrayList<>();  // массив для трех возможных ходов юнита
                    posToMove.add(new Position(position.getX() - 1, position.getY()));
                    posToMove.add(new Position(position.getX() - 1, position.getY() + 1 <= 9 ? position.getY() + 1 : 9));
                    posToMove.add(new Position(position.getX() - 1, position.getY() - 1 >= 0 ? position.getY() - 1 : 0));
                    for (Position pos : posToMove) {
                        if (!friendsPosAround.contains(pos)) { position = pos; break; }
                    }
                }
            } else {
                // position.setY(difPosition.getY() < 0 ? position.getY() + 1 : position.getY() - 1);
                if (difPosition.getY() < 0) {
                    ArrayList<Position> posToMove = new ArrayList<>();  // массив для трех возможных ходов юнита
                    posToMove.add(new Position(position.getX(), position.getY() + 1));
                    posToMove.add(new Position(position.getX() + 1 <= 9 ? position.getX() + 1 : 9, position.getY() + 1));
                    posToMove.add(new Position(position.getX() - 1 >= 0 ? position.getX() - 1 : 0, position.getY() + 1));
                    for (Position pos : posToMove) {
                        if (!friendsPosAround.contains(pos)) { position = pos; break; }
                    }
                } else {
                    ArrayList<Position> posToMove = new ArrayList<>();  // массив для трех возможных ходов юнита
                    posToMove.add(new Position(position.getX(), position.getY() - 1));
                    posToMove.add(new Position(position.getX() + 1 <= 9 ? position.getX() + 1 : 9, position.getY() - 1));
                    posToMove.add(new Position(position.getX() - 1 >= 0 ? position.getX() - 1 : 0, position.getY() - 1));
                    for (Position pos : posToMove) {
                        if (!friendsPosAround.contains(pos)) { position = pos; break; }
                    }
                }
            }
        }
    }
    
}
