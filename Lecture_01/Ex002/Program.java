package Lecture_01.Ex002;

public class Program {

    public static void main(String[] args) {
        // Point2D a = new Point2D();
        // a.x = 0;
        // a.y = 2;

        Point2D a = new Point2D(0, 2);
        System.out.println(a);

        // Point2D b = new Point2D();
        // b.x = 0;
        // b.y = 10;

        Point2D b = new Point2D(10);
        System.out.println(b);
        // System.out.println(distance(a, b));

        System.out.println(a.getX());
        System.out.println(a.getY());

        var dis = Point2D.distance(a, b);   // обращаемся через имя типа, так как static
        System.out.println(dis);
    }
}
