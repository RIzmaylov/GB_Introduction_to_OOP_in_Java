package Lecture_01.Ex002;


/**
 * Это точка 2D
 */
public class Point2D {
    private int x, y;

    /**
     * Это конструктор
     * @param valueX    это координата X
     * @param valueY    это координата Y
     */
    public Point2D(int valueX, int valueY) {
        x = valueX;
        y = valueY;
    }

    // public Point2D() {
    //     x = 0;
    //     y = 0;
    // }

    // public Point2D(int value) {
    //     x = value;
    //     y = value;
    // }

    // Конструкторы сверху это нарушение принципа DRY (Don't repeat yorself), надо сделать так:
    public Point2D(int value) {
        this(value, value);
    }

    public Point2D() {
        this(0);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int value) {
        this.x = value;
    }
    public void setY(int value) {
        this.y = value;
    }

    private String getInfo() {
        return String.format("x: %d; y: %d",x, y);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public static double distance(int x1, int y1, int x2, int y2) {                 // делаем static, теперь можно обращаться к методу через имя класса (типа)
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double distance(Point2D a, Point2D b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)); 
    }
}
