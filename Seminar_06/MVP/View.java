package Seminar_06.MVP;

import Seminar_06.CharacterPackage.BaseCharacter;
import java.util.Collections;
public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max + 1 - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (BaseCharacter human: Main.AllUnits) {
            if (human.GetPosition().getX() == x && human.GetPosition().getY() == y){
                if (!human.isAlive()) {
                    out = "|" + (AnsiColors.ANSI_RED + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (Main.LeftTeam.contains(human)) out = "|" + (AnsiColors.ANSI_GREEN + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                if (Main.RightTeam.contains(human)) out = "|" + (AnsiColors.ANSI_BLUE + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        Main.AllUnits.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
        System.out.print("_".repeat(l[0]*2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Green side");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0]-9));
        System.out.println(":\tBlue side");
        for (int i = 0; i < 10; i++) {
            System.out.print(getChar(0, i));
        }
        System.out.print("|    ");
        System.out.print(Main.LeftTeam.get(0));
        tabSetter(Main.LeftTeam.get(0).toString().length(), l[0]);
        System.out.println(Main.RightTeam.get(0));
        System.out.println(midl10);

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.LeftTeam.get(i));
            tabSetter(Main.LeftTeam.get(i).toString().length(), l[0]);
            System.out.println(Main.RightTeam.get(i));
            System.out.println(midl10);
        }
        for (int j = 0; j < 10; j++) {
            System.out.print(getChar(9, j));
        }
        System.out.print("|    ");
        System.out.print(Main.LeftTeam.get(9));
        tabSetter(Main.LeftTeam.get(9).toString().length(), l[0]);
        System.out.println(Main.RightTeam.get(9));
        System.out.println(bottom10);
    }
}