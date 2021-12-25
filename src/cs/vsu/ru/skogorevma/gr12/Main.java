package cs.vsu.ru.skogorevma.gr12;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final Line L1 = new Line(1, 3, 1.0 / 4);
    public static final HorizontalParabola P1 = new HorizontalParabola(2, -3, -1);
    public static final DefaultParabola D1 = new DefaultParabola(3, 0, 1.0 / 8);
    public static final DefaultParabola D2 = new DefaultParabola(6, 4, 1.0 / 4);
    public static final DefaultParabola D3 = new DefaultParabola(0, 0, -1.0 / 4);

    public static SimpleColor getColor(double x, double y) {
        if ((x >= -10.5) && (x <= 10.5) && (y > -10.5) && (y < 10.5)) {
            if (L1.isPointAboveLine(x, y)) {
                if (!D1.isPointAboveOfParabola(x, y)) {
                    if (x < D1.x0) {
                        if (!P1.isPointRightOfParabola(x, y)) {
                            return SimpleColor.GRAY;
                        } else return SimpleColor.GREEN;
                    } else return SimpleColor.BLUE;
                } else {
                    if (!D2.isPointAboveOfParabola(x, y)) {
                        if (x < D2.x0) {
                            return SimpleColor.BLUE;
                        } else return SimpleColor.WHITE;
                    } else return SimpleColor.WHITE;
                }
            } else {
                if (!D1.isPointAboveOfParabola(x, y)) {
                    if (!D3.isPointAboveOfParabola(x, y)) {
                        if (!P1.isPointRightOfParabola(x, y)) {
                            return SimpleColor.YELLOW;
                        } else return SimpleColor.BLUE;
                    } else {
                        if (P1.isPointRightOfParabola(x, y) && y < P1.y0) {
                            return SimpleColor.BLUE;
                        } else return SimpleColor.GRAY;
                    }
                } else {
                    if (D2.isPointAboveOfParabola(x, y)) {
                        return SimpleColor.YELLOW;
                    } else return SimpleColor.WHITE;
                }
            }
        } else return null;
    }

    public static void printColorForPoint(double x, double y) {
        if (getColor(x, y) == null) {
            System.out.println("Точка выходит за границы рисунка (противоречит условию)");
        } else {
            System.out.printf("(%.2f, %.2f) -> ", x, y);
            System.out.println(getColor(x, y));
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scan = new Scanner(System.in);
        printColorForPoint(-10, 0.4);
        printColorForPoint(-9, 1);
        printColorForPoint(2, 4);
        printColorForPoint(6.4, 4.1);
        printColorForPoint(4, 6);
        printColorForPoint(2, 2);
        printColorForPoint(10, 5.5);
        printColorForPoint(5, -1);
        printColorForPoint(1, -1);
        printColorForPoint(0, -2);
        printColorForPoint(-5, -1);
        printColorForPoint(-7, -7);

        System.out.print("Input X: ");
        double x = scan.nextDouble();
        System.out.print("Input Y: ");
        double y = scan.nextDouble();

        printColorForPoint(x, y);

    }

}
