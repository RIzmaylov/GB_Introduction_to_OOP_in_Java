package Lecture_01.Ex004;

public class Program {
    public static void main(String[] args) {
        // //#region Robot1 demo

        Robot1 robot1 = new Robot1("name_01", 1);

        System.out.printf("%s %d\n", robot1.name, robot1.level);
        robot1.startBIOS();
        robot1.startOS();
        robot1.sayHi();

        robot1.work();
        robot1.work();
        robot1.work();
        robot1.work();

        robot1.sayHi();
        robot1.stopOS();
        robot1.stopBIOS();
        ////#region

        
        //#region Robo2 demo

        Robot2 robot2 = new Robot2("name_2", 1);

        System.out.printf("%s %d\n", 
        robot2.getName(), robot2.getLevel());
        robot2.powerOn();
        robot2.work();
        robot2.work();
        robot2.work();
        robot2.powerOff();

        //#endregion

        //#region Robo3 demo

        Robot3 robot3 = new Robot3("name_03");
        System.out.println("---------------");
        System.out.println(robot3);
        robot3.power();
        robot3.work();
        robot3.power();
        robot3.work();

        robot3.power();

        //#endregion

    }
}
