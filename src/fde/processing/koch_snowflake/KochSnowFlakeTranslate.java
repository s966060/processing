package fde.processing.koch_snowflake;

import processing.core.PApplet;

public class KochSnowFlakeTranslate
        extends PApplet {

    public void settings() {
        setSize(1000, 1000);
    }

    public void setup() {
        int level = 4;
        float lineLength = 400;
        float x = 300;
        float y = 150;

        pushMatrix();
        translate(x, y);
        stroke(0, 255, 0);
        g(1, lineLength);
        stroke(0, 0, 255);
        g(level, lineLength);
        popMatrix();

        pushMatrix();
        translate(x, y);
        translate(lineLength, 0);
        rotate(radians(120));
        stroke(0, 255, 0);
        g(1, lineLength);
        stroke(0, 0, 255);
        g(level, lineLength);
        popMatrix();

        pushMatrix();
        translate(x, y);
        translate(lineLength, 0);
        rotate(radians(120));
        translate(lineLength, 0);
        rotate(radians(120));
        stroke(0, 255, 0);
        g(1, lineLength);
        stroke(0, 0, 255);
        g(level, lineLength);
        popMatrix();
    }

    public void g(int level, double lineLength) {
        if (level <= 0) {
            line(0, 0, (float) lineLength, 0);
        }
        else {
            double oneThird = lineLength / 3;

            pushMatrix();
            g(level - 1, oneThird);

            translate((float) oneThird,0);
            rotate(radians(-60));
            g(level - 1, oneThird);

            translate((float) oneThird,0);
            rotate(radians(+120));
            g(level - 1, oneThird);

            translate((float) oneThird,0);
            rotate(radians(-60));
            g(level - 1, oneThird);
            popMatrix();
        }
    }

    public void draw() {

    }

    public static void main(String[] args) {
        PApplet.main(KochSnowFlakeTranslate.class);
    }
}
