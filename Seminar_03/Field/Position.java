package Seminar_03.Field;

public class Position {

    private int x;
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }    
    /**
     * Функция рассчета ближайшего расстояния до другого персонажа
     * @param other - другой персонаж
     * @return  - возвращает расстояние
     */
    public double CalcDistToAnotherPos(Position other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

    /**
     * Функция возвращает разницу dX и dY до другой позиции в Position
     * @param other - другая позиция
     * @return - возвращает разницу dX и dY до другой позиции в Position
     */
    public Position GetDifOfToEnotherPos(Position other) {
        return new Position(x - other.getX(), y - other.getY());
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
