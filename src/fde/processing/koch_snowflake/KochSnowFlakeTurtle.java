package fde.processing.koch_snowflake;

import fde.processing.common.Turtle;
import processing.core.PApplet;

public class KochSnowFlakeTurtle extends PApplet {
    private final int level = 5;
    private final Turtle turtle;

    public KochSnowFlakeTurtle() {
        this.turtle = new Turtle(this);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup () {
        // f(level, 100, 100, 600, 600);

        this.turtle.go(200, 200);
        this.turtle.heading(0);

        f(level, 400);

        this.turtle.turn(120);
        f(level, 400);

        this.turtle.turn(120);
        f(level, 400);
    }

    public void f (
            int level,
            double lineLength) {

        if (level <= 0) {
            turtle.go(lineLength);
        }
        else {
            f (level - 1, lineLength / 3);
            turtle.turn(-60);
            f (level - 1, lineLength / 3);
            turtle.turn(120);
            f (level - 1, lineLength / 3);
            turtle.turn(-60);
            f (level - 1, lineLength / 3);
        }
    }

    public void draw () {

    }

    public static void main(String[] args) {
        PApplet.main(KochSnowFlakeTurtle.class);
    }
}
