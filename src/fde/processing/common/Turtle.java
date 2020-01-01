
package fde.processing.common;

import processing.core.PApplet;

public class Turtle {
    private final PApplet pApplet;

    private double x;
    private double y;
    private double degrees;

    public Turtle(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public void go(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    public void go(double distance) {
        double newX = this.x + Math.cos(Math.toRadians(this.degrees)) * distance;
        double newY = this.y + Math.sin(Math.toRadians(this.degrees)) * distance;

        pApplet.line((float) this.x, (float) this.y, (float) newX, (float) newY);

        this.x = newX;
        this.y = newY;
    }

    public void heading(double degrees) {
        this.degrees = 0;
        turn(degrees);
    }

    public void turn(double degrees) {
        this.degrees += degrees;

        while (this.degrees > 360) {
            this.degrees -= 360;
        }

        while (this.degrees < 0) {
            this.degrees += 360;
        }
    }
}
