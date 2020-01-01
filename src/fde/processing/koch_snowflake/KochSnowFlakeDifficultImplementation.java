package fde.processing.koch_snowflake;

import processing.core.PApplet;

public class KochSnowFlakeDifficultImplementation extends PApplet {
     final double oneThird = 1.0 / 3.0;
     final double twoThird = 2.0 / 3.0;
     final int level = 2;
     final int size = 400;
     final double x1 = 200;
     final double y1 = 200;
     final double x2 = x1 + size;
     final double y2 = y1 + size;

    public KochSnowFlakeDifficultImplementation() {
    }

    public void settings() {
        size(800, 800);
    }

    public void setup () {
        // f(level, 100, 100, 600, 600);

        f(level, x1, y1, x2, y1);
        f(level, x1, y1, x1, y2);
        f(level, x1, y2, x2, y2);
        f(level, x2, y1, x2, y2);
    }

    public void g (double x1, double y1, double x2, double y2) {
        line ((float) x1, (float) y1, (float) x2, (float) y2);
    }

    public void f (
            int level,
            double xA,
            double yA,
            double xE,
            double yE) {

        System.out.println("MyPApplet.f");
        System.out.println("level = " + level + ", xA = " + xA + ", yA = " + yA + ", xE = " + xE + ", yE = " + yE);

        if (level <= 0) {
            g(xA, yA, xE, yE);
        }
        else {
            double xDelta = (xE - xA);
            double yDelta = (yE - yA);

            double xB = xA + oneThird * xDelta;
            double yB = yA + oneThird * yDelta;

            double xD = xA + twoThird * xDelta;
            double yD = yA + twoThird * yDelta;

            f(level - 1, xA, yA, xB, yB);
            f(level - 1, xD, yD, xE, yE);

            double lineLength = Math.sqrt(xDelta * xDelta + yDelta * yDelta);

            double cos = xDelta / lineLength;
            double sin = yDelta / lineLength;

            double aCos = Math.acos(cos);

            final double degrees;

            if (yA < yE) {
                degrees = aCos - PI * 1.0 / 3.0;
            }
            else {
                degrees = -aCos - PI * 1.0 / 3.0;
            }

            double xC = xB + (Math.cos(degrees) * lineLength / 3.0);
            double yC = yB + (Math.sin(degrees) * lineLength / 3.0);

            f(level - 1, xB, yB, xC, yC);
            f(level - 1, xC, yC, xD, yD);
        }
    }

    public void draw () {

    }

    public static void main(String[] args) {
        PApplet.main(KochSnowFlakeDifficultImplementation.class);
    }
}
